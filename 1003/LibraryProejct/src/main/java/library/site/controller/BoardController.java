
package library.site.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/others")
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/Board")
	public ModelAndView list(HttpServletRequest request, HttpSession session, 
		String catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		int ps = 10;
		if (psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		if(catgo == null) {
			Object catgoObj = session.getAttribute("catgo");
			if(catgoObj != null) {
				catgo = (String)catgoObj;
			}
		}else {
			catgo = catgo.trim();
		}
		session.setAttribute("catgo", catgo);
		
		if(keyword == null) {
			Object keywordObj = session.getAttribute("keyword");
			if(keywordObj != null) {
				keyword = (String)keywordObj;
			}
		}else {
			keyword = keyword.trim();
		}
		session.setAttribute("keyword", keyword);
		
		if(searchModeStr == null) {
			Object searchModeStrObj = session.getAttribute("searchModeStr");
			if(searchModeStrObj != null) {
				searchModeStr = (String)searchModeStrObj;
			}else {
				searchModeStr = "F";
			}
		}else {
			searchModeStr = searchModeStr.trim();
		}
		session.setAttribute("searchModeStr", searchModeStr);
		
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		BoardListResult listResult = null;
		if(!searchMode) {
			listResult = boardService.getBoardListResult(cp, ps);
		}else {
			listResult = boardService.getBoardListResult(cp, ps, catgo, keyword);
		}
		ModelAndView mv = new ModelAndView("others/Board","listResult",listResult);
		
		
		if(listResult.getList().size() == 0) {
			if(cp>1)
				return new ModelAndView("redirect:Board?cp="+(cp-1));
			else
				return new ModelAndView("others/Board","listResult", null);
		}else {
			return mv;
		}
	}
	@GetMapping("/Bcontent")
	public ModelAndView content(long pb_num, HttpServletResponse response, HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
	    Map mapCookie = new HashMap();
	    if(request.getCookies() != null){
	      for (int i = 0; i < cookies.length; i++) {
	        Cookie obj = cookies[i];
	        mapCookie.put(obj.getName(),obj.getValue());
	      }
	    }
	    String cookie_review = (String) mapCookie.get("pb_view");
	    String new_cookie_review = "|" + pb_num;
	    if ( StringUtils.indexOfIgnoreCase(cookie_review, new_cookie_review) == -1 ) {
	          Cookie cookie = new Cookie("pb_view", cookie_review + new_cookie_review);
	          response.addCookie(cookie);

	          boardService.review(pb_num);
	     }
		Board board = boardService.getBoard(pb_num);
	    ModelAndView mv = new ModelAndView("others/Bcontent", "board", board);
		return mv;
		}
		
	@GetMapping("/write")
	public String write() {
		return "others/write";
	}
	@PostMapping("write.do")
	public String write(Board board, HttpServletRequest request) throws IOException {
		
		String fName=null;
		String pb_rName=null;
		//String rName=null;
		MultipartFile uploadFile = board.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String ofname = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(ofname);	//Ȯ���� ���ϱ�
			UUID uuid = UUID.randomUUID();	//UUID ���ϱ�
			fName=uuid+"."+ext;
			uploadFile.transferTo(new File("C:\\Temp\\" + fName));
			pb_rName = ofname;
		}

		board.setFileName(fName);
		board.setPb_rName(pb_rName);		
		boardService.write(board);
		return "redirect:Board?cp=1";
	}
	
	@GetMapping("/Update")
	public ModelAndView update(long pb_num) {
		Board board = boardService.getBoard(pb_num);
		ModelAndView mv = new ModelAndView("others/Update", "board", board);
		return mv;
	}
	@PostMapping("Update.do")
	public String update(Board board) {
		boardService.edit(board);
		return "redirect:Board";
	}
	
	@PostMapping("del.do")
	public String remove(long pb_num) {
		boardService.remove(pb_num);
		return "redirect:Board";
	}
	@GetMapping("download.do")
	public void download(HttpServletResponse response, HttpServletRequest request) {
	 	String filename =request.getParameter("pb_fName");
	    String realFilename="";
	    System.out.println(filename);
	    try {
	        String browser = request.getHeader("User-Agent"); 
	        //���� ���ڵ� 
	        if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
	        	filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+","%20");
	        } else {
	            filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
	        }
	    } catch (UnsupportedEncodingException ex) {
	        System.out.println("UnsupportedEncodingException");
	    }
	    
	    realFilename = "C:\\Temp\\" + filename;
	    System.out.println(realFilename);
	    File file1 = new File(realFilename);
	    if (!file1.exists()) {
	        return ;
	    }
	     
	    // ���ϸ� ����        
	    response.setContentType("application/octer-stream");
	    response.setHeader("Content-Transfer-Encoding", "binary;");
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	        try {
	            OutputStream os = response.getOutputStream();
	            FileInputStream fis = new FileInputStream(realFilename);
	 
	            int ncount = 0;
	            byte[] bytes = new byte[512];
	 
	            while ((ncount = fis.read(bytes)) != -1 ) {
	                os.write(bytes, 0, ncount);
	            }
	            fis.close();
	            os.close();
	        } catch (Exception e) {
	          System.out.println("FileNotFoundException : " + e);
	    }
	}
}

