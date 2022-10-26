package library.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.BookListResult;
import library.site.domain.DvdListResult;
import library.site.service.AdminBookManageService;
import library.site.service.BookSearch;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/library")
public class LibraryBookController {
	
	private AdminBookManageService abmService;
	
	@RequestMapping(value = "category/book", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public ModelAndView categoryBook(HttpServletRequest request, HttpSession session,
			@RequestParam("catgoId")int catgoId, @RequestParam("page")int cp) {		
		String showStr = request.getParameter("show");// °¹¼ö	
		String keywordStr = request.getParameter("keyword"); //°Ë»ö¾î
		log.info("#catgoId: "+catgoId);		
		
		int show = 12;
		if(showStr==null) {
			Object showObj = session.getAttribute("show");
			if(showObj != null) {
				show = (Integer)showObj;
			}
		}else {
			showStr = showStr.trim();
			show = Integer.parseInt(showStr);
		}
		
		String keyword = "";
		if(keywordStr==null) {
			Object keyObj = session.getAttribute("keyword");
			if(keyObj != null) {
				keyword = (String) keyObj;
			}
		}else {
			keyword = keywordStr.trim();		
		}
		
		BookListResult blr = null;
		blr = abmService.getBookListResult(cp, show, catgoId, keyword);
		log.info("##controll: " + blr);
		ModelAndView mv = new ModelAndView("shop/librarybooklist", "listResult", blr);
		return mv;
	}
	
	@RequestMapping(value = "category/dvd", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public ModelAndView categoryDvd(HttpServletRequest request, HttpSession session,
			@RequestParam("page")int cp) {		
		String showStr = request.getParameter("show");// °¹¼ö	
		String keywordStr = request.getParameter("keyword"); //°Ë»ö¾î
	
		
		int show = 12;
		if(showStr==null) {
			Object showObj = session.getAttribute("show");
			if(showObj != null) {
				show = (Integer)showObj;
			}
		}else {
			showStr = showStr.trim();
			show = Integer.parseInt(showStr);
		}
		
		String keyword = "";
		if(keywordStr==null) {
			Object keyObj = session.getAttribute("keyword");
			if(keyObj != null) {
				keyword = (String) keyObj;
			}
		}else {
			keyword = keywordStr.trim();		
		}
		DvdListResult dlr = null;						
		dlr = abmService.getDvdList(cp, show, keyword);			
		log.info("##controller : " + dlr);
		ModelAndView mv = new ModelAndView("shop/v8", "listResult", dlr);
		return mv;
	}
}
