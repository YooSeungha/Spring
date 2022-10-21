package library.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import library.site.domain.Book;
import library.site.domain.LibraryBook;
import library.site.domain.Member;
import library.site.domain.RentalBook;
import library.site.service.BookSearch;
import library.site.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class IndexController {
	
	private LoginService loginService;
	private BookSearch bookSearch;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session, RedirectAttributes ratb) {
		Member member = (Member)session.getAttribute("member");
		if(member!=null) {
			Member memberCheck = loginService.login(member);
			log.info("##로그인 정보: "+memberCheck);
			long mem_num = memberCheck.getMem_num();			
			List<RentalBook> rentalList = loginService.getMem_rental(mem_num);
			session.setAttribute("mem_rental", rentalList);
			session.setAttribute("member", memberCheck);
			
		}		
		List<LibraryBook> listRecomend = bookSearch.getRecomendBook();
		request.setAttribute("listRecomend", listRecomend);
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
