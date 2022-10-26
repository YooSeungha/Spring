package library.site.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;
import library.site.mapper.BookSearchMapper;
import library.site.mapper.FacilityMapper;
import library.site.mapper.RentalBookMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class RentalBookServiceImpl implements RentalBookService {

	@Autowired
	RentalBookMapper rbmapper;
	
	@Autowired
	private BookSearchMapper bookmapper;
	
	
	@Override
	public boolean insertrentalBook(RentalBook rb) {
		long book_num = rb.getBook_num();
		log.info("book_num : " + book_num);
		long mem_num = rb.getMem_num();
		log.info("mem_num : " + mem_num);
		LibraryBook book = bookmapper.select_num(book_num);
		log.info("book : " + book);
		RentalBook rbook = rbmapper.select(book_num);
		long rbook_mem_num = 0;
		if(rbook != null) {
			rbook_mem_num = rbook.getMem_num(); //예약한 회원번호
		}
		log.info("rbook : " + rbook);
		long book_count = book.getBook_count();
		log.info("book_count : " + book_count);
		long count = rbmapper.selectCount(book_num);
		log.info("count : " + count);
		if(count<=book_count) { //db도서 갯수와 예약 도서 갯수 판별
			if(mem_num!=rbook_mem_num) { //예약할 회원과 db에 예약된 회원 조회 후 예약 결정
				rbmapper.insert(rb);
				return true;
			}
			return false;			
		}
		return false;
	}
	
	@Override
	public RentalBook rentalBook(long book_num) {
		RentalBook rb = rbmapper.select(book_num);
		return rb;
	}
	
	@Override
	public long rentalBookCount(long book_num) {
		long rb = rbmapper.selectCount(book_num);
		return rb;
	}
	
	@Override
	public RentalBook rentalBookInfo(Map<String, Object> map) {
		RentalBook RentalInfo = rbmapper.selectRental(map);
		return RentalInfo;
	}
}
