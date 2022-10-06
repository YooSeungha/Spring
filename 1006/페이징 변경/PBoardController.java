
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javafx.scene.control.Alert;
import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;
import library.site.domain.PagingVO;
import library.site.service.PBoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/others")
public class PBoardController {
	private PBoardService pboardService;
	
	@GetMapping("/PBoard")
	public String boardList(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		// 페이징
		int total = pboardService.countBoard();
		if(nowPage == null && cntPerPage == null) {
			nowPage="1";
			cntPerPage="5";
		}else if(nowPage == null) {
			nowPage ="1";
		}else if(cntPerPage == null) {
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging",vo);
		model.addAttribute("viewAll", pboardService.selectBoard(vo));
		return "others/pboard/PBoard";
	}

	@GetMapping("/PBcontent")
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

	          pboardService.review(pb_num);
	     }
		PBoard pboard = pboardService.getPBoard(pb_num);
	    ModelAndView mv = new ModelAndView("others/pboard/PBcontent", "pboard", pboard);
		return mv;
		}
		
	@GetMapping("/edit")
	public String write() {
		return "others/pboard/edit";
	}
	@PostMapping("edit.do")
	public String write(PBoard pboard, HttpServletRequest request, HttpSession session) throws IOException {
		String fName=null;
		String pb_rName=null;
		//String rName=null;
		MultipartFile uploadFile = pboard.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String ofname = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(ofname);	//확장자 구하기
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			fName=uuid+"."+ext;
			uploadFile.transferTo(new File("C:\\Temp\\" + fName));
			pb_rName = ofname;
		}

		pboard.setPb_fname(fName);
		pboard.setPb_rname(pb_rName);		
		pboardService.write(pboard);
		return "redirect:PBoard?cp=1";
	}
	
	@GetMapping("/Update")
	public ModelAndView update(long pb_num) {
		PBoard pboard = pboardService.getPBoard(pb_num);
		ModelAndView mv = new ModelAndView("others/pboard/Update", "pboard", pboard);
		return mv;
	}
	@PostMapping("Update.do")
	public String update(PBoard pboard, HttpServletRequest request) throws IOException{
		String fName=null;
		String pb_rName=null;
		//String rName=null;
		MultipartFile uploadFile = pboard.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String ofname = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(ofname);	//확장자 구하기
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			fName=uuid+"."+ext;
			uploadFile.transferTo(new File("C:\\Temp\\" + fName));
			pb_rName = ofname;
		}

		pboard.setPb_fname(fName);
		pboard.setPb_rname(pb_rName);
		pboardService.edit(pboard);
		return "redirect:PBoard";
	}
	
	@PostMapping("delete.do")
	public String remove(PBoard pboard, long pb_num, HttpServletRequest reqeust) {
		pboardService.remove(pb_num);
		return "redirect:PBoard";
	}
	@GetMapping("download.do")
	public void download(HttpServletResponse response, HttpServletRequest request) {
	 	String filename =request.getParameter("pb_fname");
	    String realFilename="";
	    System.out.println(filename);
	    try {
	        String browser = request.getHeader("User-Agent"); 
	        //파일 인코딩 
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
	    File file = new File(realFilename);
	    if (!file.exists()) {
	    	return ;
	    }
	    // 파일명 지정        
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
	
	@GetMapping("logout.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:PBoard";
	}

}

