
package library.site.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javafx.scene.control.Alert;
import library.site.domain.PBoard;
import library.site.domain.PBoardListResult;
import library.site.domain.uploadFile;
import library.site.mapper.PBoardMapper;
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
		PBoardListResult listResult = null;
		if(!searchMode) {
			listResult = pboardService.getPBoardListResult(cp, ps);
		}else {
			listResult = pboardService.getPBoardListResult(cp, ps, catgo, keyword);
		}
		ModelAndView mv = new ModelAndView("others/pboard/PBoard","listResult",listResult);
		
		
		if(listResult.getList().size() == 0) {
			if(cp>1)
				return new ModelAndView("redirect:/pboard/PBoard?cp="+(cp-1));
			else
				return new ModelAndView("others/pboard/PBoard","listResult", null);
		}else {
			return mv;
		}
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
	    
		PBoard pboard = new PBoard();
		pboard = pboardService.getPBoard(pb_num);
		List<uploadFile> list = pboardService.getfileList(pb_num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
	    mv.addObject("pboard",pboard);
	    mv.addObject("move",pboardService.movePage(pboard.getPb_num()));
	    mv.setViewName("others/pboard/PBcontent");
		return mv;
		}
		
	@GetMapping("/edit")
	public String write() {
		return "others/pboard/edit";
	}
	@PostMapping("edit.do")
	public ModelAndView write(PBoard pboard, HttpServletRequest request, HttpSession session, MultipartHttpServletRequest mpRequest) throws IOException {
		pboardService.write(pboard);
		String path = "C:\\Temp\\";
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		List<MultipartFile> list = mpRequest.getFiles("uploadFile");
		if (list.size() == 1 && list.get(0).getOriginalFilename().equals("")) {
			
		}else {
			for (int i=0; i<list.size();i++) {
				String genId = UUID.randomUUID().toString();
				String f_rname = list.get(i).getOriginalFilename();
				String Extension = f_rname.substring(f_rname.lastIndexOf("."));
				String f_fname = genId + Extension;
				String savePath = path + f_fname ;
				list.get(i).transferTo(new File(savePath));
				pboardService.fileUpload(f_rname, f_fname);
			}
		}
		ModelAndView mv = new ModelAndView("redirect:PBoard?cp=1");
		return mv;
	}
	
	@GetMapping("/Update")
	public ModelAndView update(long pb_num) {
		PBoard pboard = pboardService.getPBoard(pb_num);
		List<uploadFile> list = pboardService.getfileList(pb_num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pboard",pboard);
		mv.addObject("list",list);
		mv.setViewName("others/pboard/Update");
		return mv;
	}
	@PostMapping("Update.do")
	public ModelAndView update(long pb_num, PBoard pboard, uploadFile uploadfile, MultipartHttpServletRequest mpRequest, HttpServletRequest request) throws IOException{
		pboardService.edit(pboard);
		ModelAndView mv = new ModelAndView("redirect:PBoard");
		List<uploadFile> list = pboardService.getfileList(pb_num);
		String fnum = request.getParameter("FNUM");
		if(fnum == null) {
			pboardService.deleteFile(pb_num);
		}else if(fnum != null){
			long f_num = Integer.parseInt(fnum);
			log.info("####"+f_num);
			for(int i=0; i<list.size(); i++) {
				long idx = list.get(i).getF_num();
				log.info("###"+idx);
				if(idx != f_num) {
					log.info("####"+"!ㅇㄹㅇㄹ");
					pboardService.delFile(idx);
					return mv;
				}
			}
		}
		String path = "C:\\Temp\\";
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		List<MultipartFile> ulist = mpRequest.getFiles("uploadFile");
		if (ulist.size() == 1 && ulist.get(0).getOriginalFilename().equals("")) {
			
		}else {
			for (int i=0; i<ulist.size();i++) {
				String genId = UUID.randomUUID().toString();
				String f_rname = ulist.get(i).getOriginalFilename();
				String Extension = f_rname.substring(f_rname.lastIndexOf("."));
				String f_fname = genId + Extension;
				String savePath = path + f_fname ;
				ulist.get(i).transferTo(new File(savePath));
				pboardService.fileUpdate(f_rname, f_fname, pb_num);
			}
		}
		return mv;
	}
	
	@PostMapping("delete.do")
	public String remove(PBoard pboard, long pb_num) {
		pboardService.deleteFile(pb_num);
		pboardService.remove(pb_num);
		return "redirect:PBoard";
	}
	@GetMapping("download")
	public void download(HttpServletResponse response, HttpServletRequest request) {
	 	String filename =request.getParameter("f_fname");
	    String realFilename="";
	   log.info(filename);
	    try {
	        String browser = request.getHeader("User-Agent"); 
	        //파일 인코딩 
	        if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
	        	filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+","%20");
	        } else {
	            filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
	        }
	    } catch (UnsupportedEncodingException ex) {
	       log.info("UnsupportedEncodingException");
	    }
	    
	    realFilename = "C:\\Temp\\" + filename;
	    log.info(realFilename);
	    File file = new File(realFilename);
	    if (!file.exists()) {
	    	return ;
	    }
	    // 파일명 지정        
	    response.setContentType("application/octet-stream");
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
	          log.info("FileNotFoundException : " + e);
	    }
	}
	@GetMapping("logout.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:PBoard";
	}

}

