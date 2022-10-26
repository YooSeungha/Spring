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
		request.setAttribute("Lbook", Lbook); //dbå ���� jsp�� ����
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
		log.info("type: " + type);//1. ���հ˻�, 2.å����, 3.����, 4.���ǻ�		
		String sortedStr = request.getParameter("sorted"); //1�α�, 2��Ȯ, 3������, 4����
		String showStr = request.getParameter("show");// ����
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
		int index = keyword.indexOf("(������)");
		log.info("#index: " + index);
		log.info("keyword: " + keyword);
		if(type==3) {
			if(index!=-1) {
				keyword = keyword.substring(0, keyword.indexOf("(������)"));
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
		String qtypeStr = request.getParameter("qtype"); //1�Ű� ��ü ����Ʈ, 2�ָ��� ���� �Ű� ����Ʈ, 3������ ��õ ����Ʈ, 4����Ʈ����
		String showStr = request.getParameter("show");// ����
		String catgoStr = request.getParameter("catgo");// ��������, �ܱ����� �з� 
		log.info("#catgoStr: " + catgoStr);
		log.info("#catgoId: "+catgoId);
		
		if(catgoStr.equals("kor")) {//��������
			if(catgoId==1) {
				catgoId=1; // �Ҽ�/��/���
				request.setAttribute("catgosub", "�Ҽ�");
			}else if(catgoId==2) {
				catgoId=55889; //�������� ������
				request.setAttribute("catgosub", "������");
			}
			else if(catgoId==3) {
				catgoId=987; //����
				request.setAttribute("catgosub", "����");
			}
			else if(catgoId==4) {
				catgoId=656; //�ι���
				request.setAttribute("catgosub", "�ι���");
			}else if(catgoId==5) {
				catgoId=517; //����/���߹�ȭ
				request.setAttribute("catgosub", "����/���߹�ȭ");
			}
			request.setAttribute("catgo", "��������");
		}else if(catgoStr.equals("for")){ //�ܱ�����
			if(catgoId==1) {
				catgoId=90842; // �Ҽ�/��/���
				request.setAttribute("catgosub", "�Ҽ�");
			}else if(catgoId==2) {
				catgoId=106165; //���
				request.setAttribute("catgosub", "���");
			}
			else if(catgoId==3) {
				catgoId=28261; //�Ϻ�����
				request.setAttribute("catgosub", "�Ϻ�����");
			}
			else if(catgoId==4) {
				catgoId=28492; //�߱�����
				request.setAttribute("catgosub", "�߱�����");
			}else if(catgoId==5) {
				catgoId=90848; //����/���߹�ȭ
				request.setAttribute("catgosub", "����/���߹�ȭ");
			}
			request.setAttribute("catgo", "�ܱ�����");
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
