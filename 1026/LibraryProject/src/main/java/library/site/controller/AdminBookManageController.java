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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.Book;
import library.site.domain.BookListResult;
import library.site.domain.BookRequestListResult;
import library.site.domain.DvdDAO;
import library.site.domain.DvdListResult;
import library.site.domain.Facility;
import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;
import library.site.domain.RentalBookListResult;
import library.site.service.AdminBookManageService;
import library.site.service.BookRequestService;
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
	@Autowired
	private BookRequestService brService;
	
	
	@GetMapping("/admin/book/search") //for Search
	public ModelAndView admin_book_search(HttpServletRequest request, HttpSession session, 
			Integer catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp 
		int cp = 1; // 현재페이지 초기화
		if(cpStr != null) {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}		
		
		//(2) ps 
		int ps = 10; // 페이지 사이즈 초기화
		if(psStr != null) {
			psStr = psStr.trim();
			ps = Integer.parseInt(psStr);
		}
		
		//(3) searchModeStr
		if(searchModeStr == null) {
				searchModeStr = "F";			
		}else{
			searchModeStr = "T";
		}
		
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		log.info("##searchMode: " + searchMode);
		//(4) ModelAndView 
		Map<String, Object> listResult = new HashMap<String, Object>();
		List<String> facNameList = abmService.facilityList();
		List<String> clsList = abmService.ClassList();
		List<Long> clsCount = abmService.clsCount();
		BookListResult bookListResult = null;
		if(!searchMode) {			
			log.info("###searchMode : " + searchMode);			
			bookListResult = abmService.getBookListResult(cp, ps);
		}else {
			log.info("###searchMode : " + searchMode);
			bookListResult = abmService.getBookListResult(cp, ps, catgo, keyword);//for Search
		}
		listResult.put("bookListResult", bookListResult);
		listResult.put("facilityList", facNameList);
		listResult.put("clsList", clsList);
		listResult.put("clsCount", clsCount);
		log.info("#BookListResult : " + bookListResult);
		ModelAndView mv = new ModelAndView("blog-v3", "listResult", listResult);
		log.info("##listResult: " + listResult);
		if(bookListResult.getBookList().size()==0) { //listResult.getList().size() == 0
			if(cp > 1)
				return new ModelAndView("redirect:/admin/book/search?cp="+(cp-1)+"&ps=10");
			else 
				return new ModelAndView("blog-v3", "listResult", listResult);
		}else {
			return mv;
		}
	}
	
	@GetMapping("/admin/book/add")
	public String admin_book_add(HttpServletRequest request, HttpSession session) {
		List<String> clsList = abmService.ClassList();
		List<String> facList = abmService.facilityList();
		session.setAttribute("clsList", clsList);
		session.setAttribute("facList", facList);
		return "shop/book_add";
	}
	
	@PostMapping("/admin/book/add.do")
	public String admin_book_add(HttpServletRequest request, HttpSession session, LibraryBook libraryBook) {
		log.info("###libraryBook" + libraryBook);
		abmService.insertBook(libraryBook);
		return "redirect:/admin/book/search";
	}
	
	@GetMapping("/admin/book/update")
	public ModelAndView admin_book_update(HttpServletRequest request, HttpSession session, long book_num) {
		Map<String, Object> listResult = new HashMap<String, Object>();
		LibraryBook libraryBook = abmService.findBook(book_num);
		List<String> facList = abmService.facilityList();
		List<String> clsList = abmService.ClassList();
		listResult.put("libraryBook", libraryBook);
		listResult.put("facList", facList);
		listResult.put("clsList", clsList);
		ModelAndView mv = new ModelAndView("shop/book_update", "listResult", listResult);
		return mv;
	}
	
	@PostMapping("/admin/book/update.do")
	public String admin_book_update(HttpServletRequest request, HttpSession session, LibraryBook libraryBook) {
		log.info("##libraryBook: " + libraryBook);	
		abmService.updateBook(libraryBook);
		return "redirect:/admin/book/search";
	}
	
	@GetMapping("/admin/book/del")
	public String admin_book_delete(HttpServletRequest request, HttpSession session, long book_num) {
		log.info("##book_num : " + book_num);
		abmService.deleteBook(book_num);
		return "redirect:/admin/book/search";
	}
	
	@GetMapping("/admin/rental/manage")
	public ModelAndView admin_rental_manage(HttpServletRequest request, HttpSession session,
			String catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		int cat=-1;
		try {
			if(catgo.equals("all")) {
				cat=-1;
			}else if(catgo.equals("wait")) {
				cat=0;
			}else if(catgo.equals("bor")) {
				cat=1;
			}else if(catgo.equals("return")) {
				cat=2;
			}else {
				cat=-1;
			}
		}
		catch(NullPointerException npe) {
			cat=-1;
		}
		
		//(1) cp 
		int cp = 1; // 현재페이지 초기화
		if(cpStr != null) {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}		
		
		//(2) ps 
		int ps = 10; // 페이지 사이즈 초기화
		if(psStr != null) {
			psStr = psStr.trim();
			ps = Integer.parseInt(psStr);
		}		
		
		//(3) searchModeStr
		if(searchModeStr == null) {
				searchModeStr = "F";			
		}else{
			searchModeStr = "T";
		}
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		//(4) ModelAndView 
		Map<String, Object> listResult = new HashMap<String, Object>();
		RentalBookListResult rblr = null;				
		if(!searchMode) {											
			rblr = abmService.getRentalBookListReuslt(cp, ps);
		}else {						
			rblr = abmService.getRentalBookListReuslt(cp, ps, cat, keyword);
		}			
		listResult.put("rblr", rblr);		
		ModelAndView mv = new ModelAndView("rental_manage", "listResult", listResult);
		log.info("##listResult22: " + listResult);
		log.info("##cp: " + cp);
		log.info("##ps: " + ps);
		log.info("catgo : " + cat);
		log.info("keyword : " + keyword);
		if(rblr.getItems().size()==0) { //listResult.getList().size() == 0
			if(cp > 1) {				
				return new ModelAndView("redirect:/admin/rental/manage?cp="+(cp-1)+"&ps=10");
			}
			else { 
				return new ModelAndView("rental_manage", "listResult", listResult);
			}
		}else {			
			return mv;
		}
	}
	
	@GetMapping("/admin/rental/ok")
	public @ResponseBody void rental_ok(long ren_num, long state) {
		abmService.updateRental(state, ren_num);		
	}
	@GetMapping("/admin/rental/del")
	public @ResponseBody void rental_del(long ren_num) {
		abmService.deleteRental(ren_num);		
	}
	@GetMapping("/admin/rental/return")
	public  @ResponseBody void rental_return(long ren_num, long state) {
		abmService.updateRental(state, ren_num);		
	}
	
	@GetMapping("/admin/request/manage")
	public ModelAndView admin_request_manage(HttpServletRequest request, HttpSession session,
			String catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		int cat=-1;
		try {
			if(catgo.equals("all")) {
				cat=-1;
			}else if(catgo.equals("wait")) {
				cat=0;
			}else if(catgo.equals("ok")) {
				cat=1;
			}else {
				cat=-1;
			}
		}
		catch(NullPointerException npe) {
			cat=-1;
		}
		
		//(1) cp 
		int cp = 1; // 현재페이지 초기화
		if(cpStr != null) {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}		
		
		//(2) ps 
		int ps = 10; // 페이지 사이즈 초기화
		if(psStr != null) {
			psStr = psStr.trim();
			ps = Integer.parseInt(psStr);
		}		
		
		//(3) searchModeStr
		if(searchModeStr == null) {
				searchModeStr = "F";			
		}else{
			searchModeStr = "T";
		}
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
	
		//(4) ModelAndView 
		Map<String, Object> listResult = new HashMap<String, Object>();
		BookRequestListResult brlr = null;
		log.info("####cp : " + cp);
		log.info("####ps : " + ps);
		log.info("####cat : " + cat);
		log.info("####keyword : " + keyword);
		if(!searchMode) {											
			brlr = abmService.getBookRequestList(cp, ps);
		}else {						
			brlr = abmService.getBookRequestList(cp, ps, cat, keyword);
		}	
		
		listResult.put("brlr", brlr);		
		
		ModelAndView mv = new ModelAndView("request_manage", "listResult", listResult);
		log.info("##listResult22: " + listResult);
		log.info("##cp: " + cp);
		log.info("##ps: " + ps);
		if(brlr.getItems().size()==0) { //listResult.getList().size() == 0
			if(cp > 1) {				
				return new ModelAndView("redirect:/admin/request/manage?cp="+(cp-1)+"&ps=10");
			}
			else { 
				return new ModelAndView("request_manage", "listResult", listResult);
			}
		}else {			
			return mv;
		}
	}
	
	@GetMapping("/admin/request/ok")
	public String request_ok(String isbn) {		
		brService.requestUpdate(isbn);
		return "redirect:/admin/request/manage";
	}
	@GetMapping("/admin/request/del")
	public String request_del(String isbn) {
		brService.requestDelete(isbn);
		return "redirect:/admin/request/manage";
	}
	@GetMapping("/admin/request/enter")
	public String request_insert(LibraryBook libraryBook) {				
		return "redirect:/admin/request/manage";
	}
	
	@PostMapping("/request/book/add.do")
	public String request_book_add(HttpServletRequest request, HttpSession session, LibraryBook libraryBook) {
		log.info("###libraryBook" + libraryBook);
		abmService.insertBook(libraryBook);
		String isbn = libraryBook.getBook_isbn();
		brService.requestDelete(isbn);
		return "redirect:/admin/book/search";
	}
	
	@GetMapping("/ajax/rental/manage")
	public @ResponseBody HashMap<String, Object> ajax_rental_manage(HttpServletRequest request, HttpSession session,
			String catgo, String keyword, String searchModeStr) {		
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		int cat=-1;
		try {
			if(catgo.equals("all")) {
				cat=-1;
			}else if(catgo.equals("wait")) {
				cat=0;
			}else if(catgo.equals("bor")) {
				cat=1;
			}else if(catgo.equals("return")) {
				cat=2;
			}else {
				cat=-1;
			}
		}
		catch(NullPointerException npe) {
			cat=-1;
		}
		
		//(1) cp 
		int cp = 1; // 현재페이지 초기화
		if(cpStr != "") {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}		
		
		//(2) ps 
		int ps = 10; // 페이지 사이즈 초기화
		if(psStr != "") {
			psStr = psStr.trim();
			ps = Integer.parseInt(psStr);
		}		
		//(3) keyword 초기화
		String keywordStr = "";
		if(keyword != null) {
			keywordStr = keyword.trim();			
		}
		
		//(4) searchModeStr
		if(searchModeStr == null) {
				searchModeStr = "F";			
		}else{
			searchModeStr = "T";
		}
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		//(5) ModelAndView 
		HashMap<String, Object> listResult = new HashMap<String, Object>();
		RentalBookListResult rblr = null;				
		if(!searchMode) {											
			rblr = abmService.getRentalBookListReuslt(cp, ps);
		}else {						
			rblr = abmService.getRentalBookListReuslt(cp, ps, cat, keywordStr);
		}			
		listResult.put("rblr", rblr);		
		if(rblr.getItems().size()==0) { //listResult.getList().size() == 0
			if(cp > 1) {				
				//return new ModelAndView("redirect:/admin/rental/manage?cp="+(cp-1)+"&ps=10");
				if(!searchMode) {			
					log.info("## 111 : ");
					rblr = abmService.getRentalBookListReuslt(cp-1, ps);
				}else {		
					log.info("## 222 : ");
					rblr = abmService.getRentalBookListReuslt(cp-1, ps, cat, keywordStr);
				}
				listResult.put("rblr", rblr);		
				return listResult;
			}
			else { 
				return listResult;
			}
		}else {			
			return listResult;
		}
	}
	
	@GetMapping("/admin/dvd/search") //dvdcontroller
	public ModelAndView admin_dvd_search(HttpServletRequest request, HttpSession session, 
			Integer catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp 
		int cp = 1; // 현재페이지 초기화
		if(cpStr != null) {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}		
		
		//(2) ps 
		int ps = 10; // 페이지 사이즈 초기화
		if(psStr != null) {
			psStr = psStr.trim();
			ps = Integer.parseInt(psStr);
		}
		
		//(3) searchModeStr
		if(searchModeStr == null) {
				searchModeStr = "F";			
		}else{
			searchModeStr = "T";
		}
		
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		log.info("##searchMode: " + searchMode);
		//(4) ModelAndView 
		Map<String, Object> listResult = new HashMap<String, Object>();		
		List<String> facNameList = abmService.facilityList();	
		DvdListResult dvdListResult = null;		
		if(!searchMode) {			
			log.info("###searchMode : " + searchMode);			
			dvdListResult = abmService.getDvdList(cp, ps);
		}else {
			log.info("###searchMode : " + searchMode);
			dvdListResult = abmService.getDvdList(cp, ps, keyword);//for Search
		}
		listResult.put("dvdListResult", dvdListResult);
		listResult.put("facilityList", facNameList);		
		log.info("#BookListResult : " + dvdListResult);
		ModelAndView mv = new ModelAndView("dvdpage", "listResult", listResult);
		log.info("##listResult: " + listResult);
		if(dvdListResult.getItems().size()==0) { //listResult.getList().size() == 0
			if(cp > 1)
				return new ModelAndView("redirect:/admin/dvd/search?cp="+(cp-1)+"&ps=10");
			else 
				return new ModelAndView("dvdpage", "listResult", listResult);
		}else {
			return mv;
		}
	}
	
	@GetMapping("/admin/dvd/add")
	public String admin_dvd_add(HttpServletRequest request, HttpSession session) {		
		List<String> facList = abmService.facilityList();		
		session.setAttribute("facList", facList);
		return "shop/dvd_add";
	}
	
	@PostMapping("/admin/dvd/add.do")
	public String admin_dvd_add(HttpServletRequest request, HttpSession session, DvdDAO dvdDAO) {
		log.info("###dvdDAO" + dvdDAO);
		abmService.insertDvd(dvdDAO);
		return "redirect:/admin/dvd/search";
	}
	
	@GetMapping("/admin/dvd/update")
	public ModelAndView admin_dvd_update(HttpServletRequest request, HttpSession session, int dvd_num) {
		Map<String, Object> listResult = new HashMap<String, Object>();
		DvdDAO dvdDAO = abmService.findDvd(dvd_num);						
		List<String> facList = abmService.facilityList();	
		log.info("#####dvdDAO : "+ dvdDAO);
		listResult.put("dvdDAO", dvdDAO);
		listResult.put("facList", facList);		
		ModelAndView mv = new ModelAndView("shop/dvd_update", "listResult", listResult);
		return mv;
	}
	
	
	 @PostMapping("/admin/dvd/update.do") 
	 public String admin_dvd_update(HttpServletRequest request, HttpSession session, DvdDAO dvdDAO) { 
		 log.info("##dvdDAO: " + dvdDAO);
		 abmService.updateDvd(dvdDAO); 
		 return "redirect:/admin/dvd/search"; 
	 }
	 
	 @GetMapping("/admin/dvd/del")
		public String admin_dvd_delete(HttpServletRequest request, HttpSession session, int dvd_num) {
			log.info("##dvd_num : " + dvd_num);
			abmService.deleteDvd(dvd_num);
			return "redirect:/admin/dvd/search";
		}
}
