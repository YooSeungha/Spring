package library.site.service;

import java.util.Map;

import library.site.domain.RentalBook;

public interface RentalBookService {
	boolean insertrentalBook(RentalBook rb); //대출예약
	RentalBook rentalBook(long book_num);
	long rentalBookCount(long book_num); //대출한 책 갯수
	RentalBook rentalBookInfo(Map<String, Object> map); //회원이 예약한 도서 정보
}
