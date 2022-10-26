package library.site.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.BookListResult;
import library.site.domain.BookVo;
import library.site.domain.Facility;
import library.site.domain.LibraryBook;
import library.site.mapper.BookSearchMapper;
import library.site.mapper.FacilityMapper;
import library.site.repository.FacilityRepository;
import library.site.repository.LibraryBookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor //repository 의존성
public class AdminBookManageServiceImpl implements AdminBookManageService {
	@Autowired
	private BookSearchMapper bsMapper;
	@Autowired
	private FacilityMapper facMapper;	
	
	private final LibraryBookRepository lbrepository;
	private final FacilityRepository frepository;
	
	@Override
	public BookListResult getBookListResult(int cp, int ps) {
		BookVo bookVo = new BookVo(cp, ps);		
		long totalcount = bsMapper.selectCount();
		List<LibraryBook> list = bsMapper.selectPerPage(bookVo);
		log.info("#list: " + list);
		return new BookListResult(cp, totalcount, ps, list);
	}
	@Override
	public BookListResult getBookListResult(int cp, int ps, String catgo, String keyword) {
		//log.info("#lbrepository: " + lbrepository.findByBook_isbn());
		//log.info("#frepository: " + frepository.findBook_loc());
		return null;
	}
	@Override
	public LibraryBook findBook(long book_num) {
		LibraryBook libraryBook = lbrepository.findByBook_num(book_num);
		return libraryBook;
	}
	
	@Override
	public List<String> facilityList(){
		List<String> facNameList = frepository.findBook_loc();
		return facNameList;
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
}
