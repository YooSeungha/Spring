package library.site.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import library.site.domain.Book;
import library.site.domain.LibraryBook;
import library.site.domain.Member;
import library.site.domain.RentalBook;
import library.site.service.BookSearch;
import library.site.service.RentalBookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class BookManageController {	
	RentalBookService rbservice;
	BookSearch bsService;
	
	
	@RequestMapping(value = "/rental.ok", method = RequestMethod.POST)
	public String rental(HttpServletRequest request, HttpSession session, RentalBook rb, RedirectAttributes ratb) {
		log.info("rb: " + rb);
		log.info("##session : " + session.getAttribute("member"));
		Object member = session.getAttribute("member");
		Member logmem = null;
		if(member != null) { //로그인 함
			 logmem = (Member)member;
			 String grade = logmem.getMem_grade();
			 if(grade.equals("2")) { //일반회원
				 boolean insert = rbservice.insertrentalBook(rb);
				 if (insert) {					 
					 long mem_num = rb.getMem_num();
					 long book_num = rb.getBook_num();					 
					 request.setAttribute("msg", "대출예약이 완료되었습니다!");
					 String url = "/rental_order?mem_num="+mem_num+"&book_num="+book_num;					 
					 request.setAttribute("url", url);
					 return "alert";
				 }else {
					 request.setAttribute("msg", "대출예약을 실패했습니다.");
					 request.setAttribute("url", "/");
					 return "alert";
				 }				 				
			 }else {
				 request.setAttribute("msg", "일반회원만 대출예약이 가능합니다.");
				 request.setAttribute("url", "/");
				 return "alert";
			 }
		}
		request.setAttribute("msg", "로그인이 필요합니다.");
		request.setAttribute("url", "/");
		return "alert";
	}
	
	@GetMapping("auto.do")
	public String showView() {
		return "autocomplete";
	}
	
	@PostMapping("autoData")
	public @ResponseBody List<LibraryBook> getAddressList(String title){
		List<LibraryBook> list = bsService.autoComplete(title);
		return list;
	}
	
	@RequestMapping(value = "/rental_order", method = RequestMethod.GET)
	public ModelAndView rental_order(HttpServletRequest request, HttpSession session, RedirectAttributes ratb,
			long mem_num, long book_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_num", mem_num);
		map.put("book_num", book_num);
		RentalBook rbook = rbservice.rentalBookInfo(map);
		LibraryBook book = bsService.getLibraryBookNum(book_num);
		String isbn = book.getBook_isbn();
		String loc = bsService.BookLocation(isbn);
		long floor = bsService.BookFloor(isbn);
		Map<String, Object> rental = new HashMap<String, Object>();
		Object memberObj = session.getAttribute("member");
		ModelAndView mv = null;
		if(memberObj != null) {
			Member member = (Member)memberObj;
			if(mem_num == member.getMem_num()) {
				rental.put("rbook", rbook);
				rental.put("book", book);
				rental.put("loc", loc);
				rental.put("floor", floor);
				mv= new ModelAndView("/shop/rental_order", "rental", rental);
				return mv;
			}
			else {
				request.setAttribute("msg", "예약한 회원이 아닙니다.");
				request.setAttribute("url", "/");
				mv = new ModelAndView("alert", "", "");
				return mv;
			}
		}else {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/");
			mv = new ModelAndView("alert", "", "");
			return mv;
		}				
	}
}
