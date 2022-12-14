package library.site.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.Book;
import library.site.domain.BookListResult;
import library.site.domain.BookReviews;
import library.site.domain.Classification;
import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;
import library.site.service.AdminBookManageService;
import library.site.service.BookReviewsService;
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
	@Autowired
	private AdminBookManageService abmService;
	
	@Autowired
	private BookReviewsService brs;
	
	@RequestMapping(value = "detail/book", method = RequestMethod.GET)
	public ModelAndView detailBook(HttpServletRequest request, HttpSession session,
			@RequestParam("isbn")String isbn, Model model) {
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
		String book_isbn = book.getIsbn();
		
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
		
		//추가본
		Object ObjId = session.getAttribute("member");
		model.addAttribute("book", book_num);
		//리뷰 총 개수 
		
		int reviewTotal = brs.reviewTotal(book_num);
		log.info("@@ 서치 리뷰 총 개수: "+reviewTotal);
		model.addAttribute("reviewTotal", reviewTotal);

		//리뷰 총 평균
		int sum = brs.reviewAvg(book_num); //해당 게시물의 총 합
		double sums = sum;
		double reviewTotals = reviewTotal;
		double reviewAvg = 0;
		
		try {
			reviewAvg = sums/reviewTotals;
		}catch(ArithmeticException e) {
			log.info("@@ 평균 오류[ArithmeticException]: "+e);
		}
		
		//String str = String.format("%.1f", reviewAvg);
		double str = Math.round(reviewAvg *10)/10.0;
		
		log.info("@@ 서치 평균: "+str);
		model.addAttribute("reviewAvg", str);
	
		//리뷰 개수당 값
		int one = brs.reviewOne(book_num);
		int two = brs.reviewTwo(book_num);
		int three = brs.reviewThree(book_num);
		int four = brs.reviewFour(book_num);
		int five = brs.reviewFive(book_num);
		model.addAttribute("one", one);
		model.addAttribute("two", two);
		model.addAttribute("three", three);
		model.addAttribute("four", four);
		model.addAttribute("five", five);
		
		//log.info("## 서치 id: "+ObjId);
		//추가본
		log.info("@@서치 book_num: "+book_num);
		String rePlusPage = request.getParameter("plusPage");
		
		log.info("@@ 서치 plusPage request: "+rePlusPage);
		int plusPage = 0;
		if(rePlusPage == null) {
			plusPage = 5;
		}else {
			plusPage = Integer.parseInt(rePlusPage);
		}
		log.info("@@ 서치 PLUSPAGE: "+plusPage);
		model.addAttribute("plusPage", plusPage);
		List<BookReviews> review = brs.reviewList(book_num, plusPage);
		log.info("@@ 서치 PLUSPAGE3: "+plusPage);
		log.info("@@리뷰 review: "+review);

		books.put("member", ObjId);
		books.put("list", review);
		// 추가본 끝
		
		
		books.put("detail", book);
		books.put("catgo", blrcatgo);
		books.put("writer", blrwriter); //책 저자책들 검색
		books.put("author", writer); //책 저자
		books.put("isbn", book_isbn);		
				
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
	
	@GetMapping("modal/read")
	public @ResponseBody HashMap<String, Object> read_modal(HttpServletRequest request, HttpSession session,
			String isbn) {
		HashMap<String, Object> books = new HashMap<String, Object>();
		Book book = bookService.getBook(isbn);			
		List<String> classList = abmService.ClassList();
		List<String> facList = abmService.facilityList();
		log.info("book : " + book);
		books.put("book", book);
		books.put("classList", classList);
		books.put("facList", facList);
		return books;
	}
	
	@PostMapping("detail/book/writereview")
	@ResponseBody
	public List<BookReviews> writeReview(long book_num, long mem_num, int brs_rating, String brs_content) {
		int result = brs.writeReviews(book_num, mem_num, brs_rating, brs_content);
		List<BookReviews> review = brs.brsList(book_num);
		log.info("@@ 리뷰 인서트 결과값: "+result);
		log.info("@@ 리뷰 인서트 결과값review: "+review);
		return review;
	}
	
	@PostMapping("detail/book/deletereview")
	@ResponseBody
	public int deleteReview(long brs_num) {
		int result = brs.deleteReviews(brs_num);
		log.info("@@ 리뷰 삭제 결과값: "+result);
		return result;
	}
	
	
	/// 일반 글쓰기 , 삭제 시 
	@PostMapping("detail/book/listreview")
	@ResponseBody
	public Map<String, Object> listReview(long book_num, HttpSession session){
		LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
	
		int plusPage = 5;
		List<BookReviews> review = brs.reviewList(book_num, plusPage);
		log.info("@@ 서치 PLUSPAGE 후: "+plusPage);
		log.info("@@ 댓글 리스트: "+review);
		
		//세션 멤버값
		Object ObjId = session.getAttribute("member");

		//리뷰 총 개수 
		
		int reviewTotal = brs.reviewTotal(book_num);
		log.info("@@ 서치 리뷰 총 개수: "+reviewTotal);
		double reviewTotals = reviewTotal;

		//리뷰 총 평균
		int sum = brs.reviewAvg(book_num); //해당 게시물의 총 합
		double sums = sum;
		double reviewAvg = 0;
		
		try {
			reviewAvg = sums/reviewTotals;
		}catch(ArithmeticException e) {
			log.info("@@ 평균 오류[ArithmeticException]: "+e);
		}
		
		String str = String.format("%.1f", reviewAvg);
		log.info("@@ 서치 평균: "+str);
		
		//리뷰 개수당 값
		int one = brs.reviewOne(book_num);
		int two = brs.reviewTwo(book_num);
		int three = brs.reviewThree(book_num);
		int four = brs.reviewFour(book_num);
		int five = brs.reviewFive(book_num);
		//
		result.put("book", book_num);
		result.put("plusPage", plusPage);
		result.put("reviewAvg", str);
		result.put("reviewTotal", reviewTotal);
		result.put("one", one);
		result.put("two", two);
		result.put("three", three);
		result.put("four", four);
		result.put("five", five);
		result.put("member", ObjId);
		result.put("review", review);	//BookReviews list 값 
		
		return result;
	}
	
	
	//더보기 
	@PostMapping("detail/book/listreviewplus")
	@ResponseBody
	public Map<String, Object> listReviewPlus(long book_num, HttpSession session, int plusPage, HttpServletRequest request){
		LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
		String rePlusPage = request.getParameter("plusPage");
		int reviewTotal = brs.reviewTotal(book_num);
		log.info("@@ 더보기 PLUSPAGE(re) 전: "+rePlusPage);
		log.info("@@ 더보기 PLUSPAGE 전: "+plusPage);
		
		plusPage += 10;
		
		List<BookReviews> review = brs.reviewList(book_num, plusPage);
		log.info("@@ 더보기 PLUSPAGE(re) 후: "+rePlusPage);
		log.info("@@ 더보기 PLUSPAGE 후: "+plusPage);
		log.info("@@ 더보기 댓글 리스트: "+review);
		log.info("@@ 더보기 댓글 리스트 사이즈: "+review.size());
		//plusPage += 10;
		//세션 멤버값
		Object ObjId = session.getAttribute("member");
		if(ObjId == null) {
			ObjId = "비회원";
		}
		log.info("@@ 더보기 멤버 값: "+ObjId);
		
		result.put("reviewTotal", reviewTotal);
		result.put("plusPage", plusPage);
		result.put("member", ObjId);
		result.put("review", review);	//BookReviews list 값 
		
		return result;
	}
	
	//좋아요 업데이트 
	@PostMapping("detail/book/reviewupdatelike")
	@ResponseBody
	public Map<String , Integer> reviewUpdateLike(long brs_num, long mem_num) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		int likePlus = 0;// 좋아요시 + 1 업데이트
		int likeMinus = 0;	//좋아요 한번 더 누를 시 - 1 업데이트
		int selectLike = 0;
		int dataExists = brs.dataExists(brs_num, mem_num);
		if(dataExists == 0) {	//로그 테이블에 데이터 존재 없음 
			log.info("좋아요 데이터 없음");
			int insertLikeLog = brs.likeLog(brs_num, mem_num);	//좋아요 시 인서트로 like 1
			log.info("@@ 좋아요 데이터 없어서 로그테이블에 인서트: "+insertLikeLog);
			selectLike = brs.selectLike(brs_num, mem_num);	// 해당 게시글 좋아요 쓴 흔적 select
			if(selectLike == 0) {
				likePlus = brs.reviewUpdateLike(brs_num);// 좋아요시 + 1 업데이트
				int logLikePlus = brs.updateLikePlus(brs_num, mem_num); // 좋아요시 로그에 +1 업데이트
				
				log.info("@@ 좋아요시[전] +1: "+likePlus);
				log.info("@@ 좋아요시 로그에 업데이트[전]: "+logLikePlus);
			}
			
		}else if(dataExists == 1) {	//로그 테이블에 데이터 존재 있음
			log.info("좋아요 데이터 있음");
			selectLike = brs.selectLike(brs_num, mem_num);	// 해당 게시글 좋아요 쓴 흔적 select
			if(selectLike == 1) {	// 이미 좋아요를 누른 사람
				log.info("@@ 좋아요 이미 좋아요를 누른 사람: ");
				likeMinus = brs.reviewDownLike(brs_num);	//좋아요 한번 더 누를 시 - 1 업데이트
				int logLikeMinus = brs.updateLikeMinus(brs_num, mem_num); // 좋아요 한 번 더 누를 시 로그에 -1 업데이트
				log.info("@@ 좋아요 원상복귀: "+likeMinus);
				log.info("@@ 좋아요 로그원상복귀: "+logLikeMinus);
				
			}else if(selectLike == 0) {	// 좋아요를 눌러도 되는 사람
				log.info("@@ 좋아요 눌러도 됨: ");
				likePlus = brs.reviewUpdateLike(brs_num);// 좋아요시 + 1 업데이트
				int logLikePlus = brs.updateLikePlus(brs_num, mem_num); // 좋아요시 로그에 +1 업데이트
				
				log.info("@@ 좋아요시 +1: "+likePlus);
				log.info("@@ 좋아요시 로그에 업데이트: "+logLikePlus);
			}
		}
		
		//log.info("@@ 좋아요 쓴 흔적: "+dataExists);
		
		result.put("dataExists", dataExists);
		result.put("selectLike", selectLike);
		return result;
	}
	
	//싫어요 업데이트
	@PostMapping("detail/book/reviewupdatehate")
	@ResponseBody
	public Map<String , Integer> reviewUpdateHate(long brs_num, long mem_num) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		int dataExists = brs.dataExists(brs_num, mem_num);	//로그 테이블에 데이터가 있는지 없는지 체크 
		int selectHate = 0;
		if(dataExists == 0) {
			int insertHateLog = brs.hateLog(brs_num, mem_num);	//리뷰 로그에 해당아이디를 가진사람 인서트
			selectHate = brs.selectHate(brs_num, mem_num);
			if(selectHate == 0) {
				int hatePlus = brs.reviewUpdateHate(brs_num);	//싫어요 시 +1 업데이트
				int logHatePlus = brs.updateHatePlus(brs_num, mem_num);
			}
			
		}else if(dataExists == 1) {
			selectHate = brs.selectHate(brs_num, mem_num);
			if(selectHate == 0) {
				int hatePlus = brs.reviewUpdateHate(brs_num);	//싫어요 시 +1 업데이트
				int logHatePlus = brs.updateHatePlus(brs_num, mem_num);
			}else if(selectHate == 1) {
				int hateMinus = brs.reviewDownHate(brs_num);
				int logHateMinus = brs.updateHateMinus(brs_num, mem_num);
			}
			
		}
		
		
		result.put("selectHate", selectHate);
		result.put("dataExists", dataExists);
		return result;
	}
}
