package library.site.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.BookListResult;
import library.site.domain.Facility;
import library.site.domain.LibraryBook;
import library.site.service.AdminBookManageService;
import library.site.service.BookSearch;
import library.site.service.RentalBookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class AdminBookManageController {
	
	@Autowired
	private AdminBookManageService abmService;	
	
	@GetMapping("/admin/book/search") //for Search
	public ModelAndView admin_book_search(HttpServletRequest request, HttpSession session, 
			String catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp 
		int cp = 1; // 현재페이지 초기화
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
		
		//(2) ps 
		int ps = 5; // 페이지 사이즈 초기화
		if(psStr == null) {
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
		
		//(3) catgo 
		if(catgo == null) {
			Object catgoObj = session.getAttribute("catgo");
			if(catgoObj != null) {
				catgo = (String)catgoObj;
			}
		}else {
			catgo = catgo.trim();
		}
		session.setAttribute("catgo", catgo);
		log.info("#catgo2: " + catgo);
		
		//(4) keyword 
		if(keyword == null) {
			Object keywordObj = session.getAttribute("keyword");
			if(keywordObj != null) {
				keyword = (String)keywordObj;
			}
		}else {
			keyword = keyword.trim();
		}
		session.setAttribute("keyword", keyword);
		log.info("#keyword2: " + keyword);
		
		//(5) searchModeStr
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
		log.info("#searchModeStr2: " + searchModeStr);
		
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		
		//(6) ModelAndView 
		Map<String, Object> listResult = new HashMap<String, Object>();
		List<String> facNameList = abmService.facilityList();
		BookListResult bookListResult = null;
		if(!searchMode) {			
			abmService.getBookListResult(1, 1, "1", "1");
			bookListResult = abmService.getBookListResult(cp, ps);
		}else {
			//listResult = boardService.getBoardListResult(cp, ps, catgo, keyword);//for Search
		}
		listResult.put("bookListResult", bookListResult);
		listResult.put("facilityList", facNameList);
		ModelAndView mv = new ModelAndView("blog-v3", "listResult", listResult);
		log.info("##listResult: " + listResult);
		if(bookListResult.getBookList().size()==0) { //listResult.getList().size() == 0
			if(cp > 1)
				return new ModelAndView("redirect:list.do?cp="+(cp-1));
			else 
				return new ModelAndView("blog-v3", "listResult", null);
		}else {
			return mv;
		}
	}
	
	@GetMapping("/admin/book/update")
	public ModelAndView admin_book_update(HttpServletRequest request, HttpSession session, long book_num) {
		Map<String, Object> listResult = new HashMap<String, Object>();
		LibraryBook libraryBook = abmService.findBook(book_num);
		List<String> facList = abmService.facilityList();
		listResult.put("libraryBook", libraryBook);
		listResult.put("facList", facList);
		ModelAndView mv = new ModelAndView("shop/book_update", "listResult", listResult);
		return mv;
	}
	
	@PostMapping("/admin/book/update.do")
	public String admin_book_update(HttpServletRequest request, HttpSession session, LibraryBook libraryBook) {
		log.info("##libraryBook: " + libraryBook);	
		abmService.updateBook(libraryBook);
		return "redirect:/admin/book/search";
	}
}
