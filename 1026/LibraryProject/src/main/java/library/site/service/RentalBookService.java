package library.site.service;

import java.util.List;
import java.util.Map;

import library.site.domain.LibraryBook;
import library.site.domain.RentalBookDAO;

public interface RentalBookService {
	int insertrentalBook(RentalBookDAO rb); //대출예약
	RentalBookDAO rentalBook(long book_num);
	long rentalBookCount(long book_num); //대출한 책 갯수
	RentalBookDAO rentalBookInfo(Map<String, Object> map); //회원이 예약한 도서 정보
	long mem_rentalCount(long mem_num); // 회원이 예약한 도서 갯수
	List<LibraryBook> getMonthRentalBook(); //한달간 많이 빌린 책
}
