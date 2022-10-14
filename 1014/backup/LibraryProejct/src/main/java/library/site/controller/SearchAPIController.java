package library.site.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.Book;
import library.site.domain.BookListResult;
import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;
import library.site.service.BookSearch;
import library.site.service.RentalBookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SearchAPIController {
	@Autowired
	private BookSearch bookService;
	@Autowired
	private RentalBookService rbService;
	
	@RequestMapping(value = "detail/book", method = RequestMethod.GET)
	public ModelAndView detailBook(HttpServletRequest request, HttpSession session,
			@RequestParam("isbn")String isbn) {
		HashMap<String, Object> books = new HashMap<String, Object>();
		Book book = null;
		book = bookService.getBook(isbn);
		int catgoId = book.getCatgoId();
		BookListResult blrcatgo = null;
		blrcatgo = bookService.getBookCatgoRefer(catgoId);
		String writer = book.getWriter();
		writer = writer.substring(0, writer.indexOf("("));
		log.info("#writer: " + writer);
		writer = writer.trim();
		BookListResult blrwriter = null;		
		blrwriter = bookService.getBookWriterRefer(writer); 
		
		books.put("detail", book);
		books.put("catgo", blrcatgo);
		books.put("writer", blrwriter);
		books.put("author", writer);
		
		LibraryBook Lbook = bookService.getLibraryBook(isbn);
		request.setAttribute("Lbook", Lbook); //db책 정보 jsp에 전달
		long book_num = 0;
		String Lbook_isbn = "";
		try {
			 book_num = Lbook.getBook_num();
			 Lbook_isbn = Lbook.getBook_isbn();
		}catch(NullPointerException npe) {
			book_num = 0;
			Lbook_isbn = "";
		}		
		long book_count = rbService.rentalBookCount(book_num);
		String book_loc = bookService.BookLocation(Lbook_isbn);
		
		request.setAttribute("Rbook_count", book_count);
		request.setAttribute("book_loc", book_loc);
		
		ModelAndView mv = new ModelAndView("shop/single-product-v4", "books", books);
		return mv;
	}
	//@RequestMapping(value = "search/book", method = RequestMethod.POST)
	@RequestMapping(value = "search/book", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public ModelAndView searchBook(HttpServletRequest request, HttpSession session,
			@RequestParam("keyword")String keyword, @RequestParam("type")long type,
			@RequestParam("page")int cp) {
		log.info("keyword: " + keyword);
		log.info("type: " + type);//1. 통합검색, 2.책제목, 3.저자, 4.출판사		
		String sortedStr = request.getParameter("sorted"); //1인기, 2정확, 3출판일, 4평점
		String showStr = request.getParameter("show");// 갯수
		int sorted = 2;
		if(sortedStr==null) {
			Object sortedObj = session.getAttribute("sorted");
			if(sortedObj != null) {
				sorted = (Integer)sortedObj;
			}
		}else {
			sortedStr = sortedStr.trim();
			sorted = Integer.parseInt(sortedStr);
		}
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
		int index = keyword.indexOf("(지은이)");
		log.info("#index: " + index);
		log.info("keyword: " + keyword);
		if(type==3) {
			if(index!=-1) {
				keyword = keyword.substring(0, keyword.indexOf("(지은이)"));
				keyword = keyword.trim();
			}
		}
		//long isbn = Long.parseLong(keyword);
		//log.info("#isbn: " + isbn);
		//bookService.getBook(isbn);
		//bookService.getBookListResult(1, 2);
		BookListResult blr = null;
		blr = bookService.getBookListResult(sorted, cp, show, type, keyword);
		blr.setKeyword(keyword);
		log.info("#keyword: " + keyword);		
		ModelAndView mv = new ModelAndView("shop/v3", "listResult", blr);
		return mv;
	}
	
	@RequestMapping(value = "category/book", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	public ModelAndView categoryBook(HttpServletRequest request, HttpSession session,
			@RequestParam("catgoId")int catgoId, @RequestParam("page")int cp) {
		String qtypeStr = request.getParameter("qtype"); //1신간 전체 리스트, 2주목할 만한 신간 리스트, 3편집자 추천 리스트, 4베스트셀러
		String showStr = request.getParameter("show");// 갯수
		String catgoStr = request.getParameter("catgo");// 국내도서, 외국도서 분류 
		log.info("#catgoStr: " + catgoStr);
		log.info("#catgoId: "+catgoId);
		
		if(catgoStr.equals("kor")) {//국내도서
			if(catgoId==1) {
				catgoId=1; // 소설/시/희곡
				request.setAttribute("catgosub", "소설");
			}else if(catgoId==2) {
				catgoId=55889; //국내도서 에세이
				request.setAttribute("catgosub", "에세이");
			}
			else if(catgoId==3) {
				catgoId=987; //과학
				request.setAttribute("catgosub", "과학");
			}
			else if(catgoId==4) {
				catgoId=656; //인문학
				request.setAttribute("catgosub", "인문학");
			}else if(catgoId==5) {
				catgoId=517; //예술/대중문화
				request.setAttribute("catgosub", "예술/대중문화");
			}
			request.setAttribute("catgo", "국내도서");
		}else if(catgoStr.equals("for")){ //외국도서
			if(catgoId==1) {
				catgoId=90842; // 소설/시/희곡
				request.setAttribute("catgosub", "소설");
			}else if(catgoId==2) {
				catgoId=106165; //어린이
				request.setAttribute("catgosub", "어린이");
			}
			else if(catgoId==3) {
				catgoId=28261; //일본도서
				request.setAttribute("catgosub", "일본도서");
			}
			else if(catgoId==4) {
				catgoId=28492; //중국도서
				request.setAttribute("catgosub", "중국도서");
			}else if(catgoId==5) {
				catgoId=90848; //예술/대중문화
				request.setAttribute("catgosub", "예술/대중문화");
			}
			request.setAttribute("catgo", "외국도서");
		}		
		int typed = 1;
		if(qtypeStr==null) {
			Object sortedObj = session.getAttribute("qtype");
			if(sortedObj != null) {
				typed = (Integer)sortedObj;
			}
		}else {
			qtypeStr = qtypeStr.trim();
			typed = Integer.parseInt(qtypeStr);
		}
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
		//long isbn = Long.parseLong(keyword);
		//log.info("#isbn: " + isbn);
		//bookService.getBook(isbn);
		//bookService.getBookListResult(1, 2);
		BookListResult blr = null;
		blr = bookService.getBookCatgoListResult(typed, cp, show, catgoId);
		log.info("##controll: " + blr);
		ModelAndView mv = new ModelAndView("shop/v1", "listResult", blr);
		return mv;
	}
	@GetMapping("popup/read")
	public @ResponseBody HashMap<String, Object> read(HttpServletRequest request, HttpSession session,
			String isbn) {
		HashMap<String, Object> books = new HashMap<String, Object>();
		Book book = bookService.getBook(isbn);
		LibraryBook Lbook = bookService.getLibraryBook(isbn);
		long book_num = 0;
		String Lbook_isbn = "";
		try {
			book_num = Lbook.getBook_num();
			Lbook_isbn = Lbook.getBook_isbn();
		}catch(NullPointerException npe) {
			book_num = 0;
			Lbook_isbn = "";
		}		
		long rbook_count = rbService.rentalBookCount(book_num);
		String rbook_loc = bookService.BookLocation(Lbook_isbn);
		book.setLbook(Lbook);
		books.put("book", book);
		books.put("rbook_count", rbook_count);
		books.put("rbook_loc", rbook_loc);
		books.put("member", session.getAttribute("member"));
		return books;
	}
}
