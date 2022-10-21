package library.site.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.BookListResult;
import library.site.domain.BookRequestDAO;
import library.site.domain.BookRequestListResult;
import library.site.domain.BookVo;

import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;
import library.site.domain.RentalBookListResult;
import library.site.domain.RentalBookVo;
import library.site.mapper.BookSearchMapper;
import library.site.repository.BookRequestRepository;
import library.site.repository.ClassificationRepository;
import library.site.repository.FacilityRepository;
import library.site.repository.LibraryBookRepository;
import library.site.repository.MemberRepository;
import library.site.repository.RentalBookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor //repository 의존성
public class AdminBookManageServiceImpl implements AdminBookManageService {
	@Autowired
	private BookSearchMapper bsMapper;	
	
	private final LibraryBookRepository lbrepository;
	private final FacilityRepository frepository;
	private final ClassificationRepository cfrepository;
	private final MemberRepository memrepository;
	private final RentalBookRepository rbrepository;
	private final BookRequestRepository brRepository;
	
	@Override
	public BookListResult getBookListResult(int cp, int ps) {
		BookVo bookVo = new BookVo(cp, ps);		
		long totalcount = bsMapper.selectCount();
		List<LibraryBook> list = bsMapper.selectPerPage(bookVo);
		BookListResult blr = new BookListResult(cp, totalcount, ps, list);
		
		//페이징 (시작페이지, 끝페이지)
		int endpaging = ((int)Math.ceil((double)cp / (double)5)) * 5;
		int startpaging = endpaging - 4;
		int cntpg = 0;
		cntpg = (int)(totalcount/ps);
		if(totalcount % ps != 0) {
			cntpg++;
		} 	
		if (cntpg < endpaging) {
			endpaging = cntpg;
		}
		blr.setStartpaging(startpaging);
		blr.setEndpaging(endpaging);
		log.info("###blr1 : " + blr);
		return blr;
	}
	@Override
	public BookListResult getBookListResult(int cp, int ps, int catgo, String keyword) {
		List<LibraryBook> lbl = new ArrayList<LibraryBook>();
		long totalcount = 0;
		BookVo bookVo = new BookVo(cp, ps);
		int startRow = bookVo.getStartRow();
		int endRow = bookVo.getEndRow();		
		String book_title = keyword;
		if(book_title == null) {
			book_title = "";
		}
		if(catgo==0) { //전체장르에서 검색						
			lbl = lbrepository.searchBook(startRow, endRow, book_title);
			totalcount = lbrepository.searchTot(book_title);
		}else {
			lbl = lbrepository.searchCatgoBook(startRow, endRow, book_title, catgo);
			totalcount = lbrepository.searchCatgoTot(book_title, catgo);
			
		}
		BookListResult blr = new BookListResult(cp, totalcount, ps, lbl);		
		//페이징 (시작페이지, 끝페이지)
		int endpaging = ((int)Math.ceil((double)cp / (double)5)) * 5;
		int startpaging = endpaging - 4;
		int cntpg = 0;
		cntpg = (int)(totalcount/ps);
		if(totalcount % ps != 0) {
			cntpg++;
		} 	
		if (cntpg < endpaging) {
			endpaging = cntpg;
		}
		blr.setStartpaging(startpaging);
		blr.setEndpaging(endpaging);		
		return blr;
	}
	@Override
	@Transactional
	public RentalBookListResult getRentalBookListReuslt(int cp, int ps) {
		RentalBookVo rbv = new RentalBookVo(cp, ps);		
		long tot = rbrepository.countTot();		
		int startRow = rbv.getStartRow();
		int endRow = rbv.getEndRow();
		List<RentalBook> list = rbrepository.selectPerPage(startRow, endRow);
		//RentalBook rb = rbrepository.findById(2L).orElseThrow(()->new IllegalArgumentException("해당 row가 없습니다."));		
		RentalBookListResult rblr = new RentalBookListResult(cp, tot, ps, list);	
		int endpaging = ((int)Math.ceil((double)cp / (double)5)) * 5;
		int startpaging = endpaging - 4;
		int cntpg = 0;
		cntpg = (int)(tot/ps);
		if(tot % ps != 0) {
			cntpg++;
		} 	
		if (cntpg < endpaging) {
			endpaging = cntpg;
		}
		rblr.setStartpaging(startpaging);
		rblr.setEndpaging(endpaging);
		return rblr;
	}	
	@Override
	@Transactional
	public RentalBookListResult getRentalBookListReuslt(int cp, int ps, int catgo, String keyword) {		
		List<RentalBook> rlbl = new ArrayList<RentalBook>();
		long totalcount = 0;
		RentalBookVo rbv = new RentalBookVo(cp, ps);
		int startRow = rbv.getStartRow();
		int endRow = rbv.getEndRow();		
		String book_title = keyword;
		if(book_title == null) {
			book_title = "";
		}
		if(catgo==-1) { //전체장르에서 검색					
			rlbl = rbrepository.searchRentalBook(startRow, endRow, book_title);			
			totalcount = rbrepository.search_rentalCount(book_title);			
		}else {			
			rlbl = rbrepository.searchRentalBook(startRow, endRow, book_title, catgo);
			totalcount = rbrepository.search_rentalCount(book_title, catgo);			
		}
		RentalBookListResult rlbr = new RentalBookListResult(cp, totalcount, ps, rlbl);		
		//페이징 (시작페이지, 끝페이지)
		int endpaging = ((int)Math.ceil((double)cp / (double)5)) * 5;
		int startpaging = endpaging - 4;
		int cntpg = 0;
		cntpg = (int)(totalcount/ps);
		if(totalcount % ps != 0) {
			cntpg++;
		} 	
		if (cntpg < endpaging) {
			endpaging = cntpg;
		}
		rlbr.setStartpaging(startpaging);
		rlbr.setEndpaging(endpaging);
		return rlbr;		
	}
	
	@Override
	public LibraryBook findBook(long book_num) {
		LibraryBook libraryBook = lbrepository.findByBook_num(book_num);		
		log.info("##count : " + memrepository.count());
		return libraryBook;
	}
	
	
	
	@Override
	public List<String> facilityList(){
		List<String> facNameList = frepository.findBook_loc();
		return facNameList;
	}
	@Override
	public List<String> ClassList(){
		List<String> ClassNameList = cfrepository.findClass_name();
		return ClassNameList;
	}
	
	@Transactional
	@Override
	public void updateBook(LibraryBook libraryBook) {
		long id = libraryBook.getBook_num();
		LibraryBook updateBook = lbrepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 row가 없습니다. id="+id));
		String book_title = libraryBook.getBook_title();
		String book_writer = libraryBook.getBook_writer();
		String book_publisher = libraryBook.getBook_publisher();
		String book_isbn = libraryBook.getBook_isbn();
		String book_recomend = libraryBook.getBook_recomend();
		String book_img = libraryBook.getBook_img();
		long book_code = libraryBook.getBook_code();
		long f_num = libraryBook.getF_num();
		int book_count = libraryBook.getBook_count();
		log.info("#update : " + libraryBook);
		log.info("#updateBook : " + updateBook);
		updateBook.update(book_title, book_writer, book_publisher, book_isbn, book_recomend, book_img, book_code, f_num, book_count);
		lbrepository.save(updateBook); //commit;
	} 
	
	@Override
	public List<Long> clsCount(){
		List<Long> clsCount = cfrepository.countClass_num();
		return clsCount;
	}
	
	@Transactional
	@Override
	public void insertBook(LibraryBook libraryBook) {
		long maxnum = lbrepository.findMaxNum();
		libraryBook.setBook_num(maxnum+1);
		log.info("##service libraryBook : " + libraryBook);
		lbrepository.save(libraryBook);
	}
	
	@Transactional
	@Override
	public void deleteBook(long book_num) {
		LibraryBook deleteBook = lbrepository.findById(book_num).orElseThrow(()->new IllegalArgumentException("해당 row가 없습니다. id="+book_num));
		lbrepository.delete(deleteBook);
	}
	@Transactional
	@Override
	public void updateRental(long state, long ren_num) {				
		RentalBook rb = rbrepository.findById(ren_num).orElseThrow(()->new IllegalArgumentException("해당 row가 없습니다."));		
		rb.setRen_stat(state);		
		rbrepository.save(rb);
		
	}
	@Transactional
	@Override
	public void deleteRental(long ren_num) {
		rbrepository.deleteById(ren_num);
	}
	@Override
	public BookRequestListResult getBookRequestList(int cp, int ps) {
		BookVo bookVo = new BookVo(cp, ps);		
		long totalcount = brRepository.getTotCount();
		int startRow = bookVo.getStartRow();
		int endRow = bookVo.getEndRow();
		List<BookRequestDAO> list = brRepository.findBookRequestList(startRow, endRow);		
		BookRequestListResult brlr = new BookRequestListResult(cp, totalcount, ps, list);
		
		//페이징 (시작페이지, 끝페이지)
		int endpaging = ((int)Math.ceil((double)cp / (double)5)) * 5;
		int startpaging = endpaging - 4;
		int cntpg = 0;
		cntpg = (int)(totalcount/ps);
		if(totalcount % ps != 0) {
			cntpg++;
		} 	
		if (cntpg < endpaging) {
			endpaging = cntpg;
		}
		brlr.setStartpaging(startpaging);
		brlr.setEndpaging(endpaging);
		log.info("###blr1 : " + brlr);
		return brlr;		
	}
	@Override
	public BookRequestListResult getBookRequestList(int cp, int ps, int catgo, String keyword) {
		List<BookRequestDAO> brDAO = new ArrayList<BookRequestDAO>();
		long totalcount = 0;
		RentalBookVo rbv = new RentalBookVo(cp, ps);
		int startRow = rbv.getStartRow();
		int endRow = rbv.getEndRow();				
		if(keyword == null) {
			keyword = "";
		}
		if(catgo==-1) { //전체장르에서 검색	
			log.info("@@@@1");
			log.info("@@@@cp : " + cp);
			log.info("@@@@ps : " + ps);
			log.info("@@@@catgo : " + catgo);
			log.info("@@@@keyword: " + keyword);
			brDAO = brRepository.searchfindBookRequestList(startRow, endRow, keyword);				 			
			 totalcount = brRepository.getSearchTotCount(keyword);
		}else {
			log.info("@@@@2");
			log.info("@@@@cp : " + cp);
			log.info("@@@@ps : " + ps);
			log.info("@@@@catgo : " + catgo);
			log.info("@@@@keyword: " + keyword);
			brDAO = brRepository.searchfindBookRequestList(startRow, endRow, keyword, catgo);			
			totalcount = brRepository.getSearchTotCount(keyword, catgo);
			
		}		
		BookRequestListResult brlr = new BookRequestListResult(cp, totalcount, ps, brDAO);
		//페이징 (시작페이지, 끝페이지)
		int endpaging = ((int)Math.ceil((double)cp / (double)5)) * 5;
		int startpaging = endpaging - 4;
		int cntpg = 0;
		cntpg = (int)(totalcount/ps);
		if(totalcount % ps != 0) {
			cntpg++;
		} 	
		if (cntpg < endpaging) {
			endpaging = cntpg;
		}
		brlr.setStartpaging(startpaging);
		brlr.setEndpaging(endpaging);
		return brlr;	
	}
}
