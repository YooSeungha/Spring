package library.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import library.site.domain.Book;
import library.site.domain.BookRequestDAO;
import library.site.domain.LibraryBook;
import library.site.domain.Member;
import library.site.domain.PBoard;
import library.site.domain.RentalBook;
import library.site.service.BookSearch;
import library.site.service.LoginService;
import library.site.service.PBoardService;
import library.site.service.RentalBookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class IndexController {
	
	private LoginService loginService;
	private BookSearch bookSearch;
	private RentalBookService rbService;
	private PBoardService pboardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session, RedirectAttributes ratb, Model model) {
		Member member = (Member)session.getAttribute("member");
		if(member!=null) {
			Member memberCheck = loginService.login(member);
			log.info("##로그인 정보: "+memberCheck);
			long mem_num = 0;
	         try {
	            mem_num = memberCheck.getMem_num();
	         }catch(NullPointerException npe) {
	            log.info("@@ 인덱스 NULL ERROR: "+npe);
	         }      			
	        	        
			List<RentalBook> rentalList = loginService.getMem_rental(mem_num);
			List<BookRequestDAO> requestList= loginService.getMem_request(mem_num);
			session.setAttribute("mem_rental", rentalList);
			session.setAttribute("mem_request", requestList);
			session.setAttribute("member", memberCheck);
		}		
		List<LibraryBook> listRecomend = bookSearch.getRecomendBook();
		request.setAttribute("listRecomend", listRecomend);
		List<LibraryBook> monthRentalList = rbService.getMonthRentalBook();
		session.setAttribute("monthRentalList", monthRentalList);
		
		List<PBoard> notice = pboardService.notice();
		model.addAttribute("notice",notice);
		List<PBoard> newlist = pboardService.newlist();
		model.addAttribute("newlist", newlist);
		return "index";
	}
	@RequestMapping("/write.do")
	public String write() {
		
		return "others/board/write";
	}	
	@RequestMapping("/modal")
	public String modal() {
		
		return "modal";
	}	
}
