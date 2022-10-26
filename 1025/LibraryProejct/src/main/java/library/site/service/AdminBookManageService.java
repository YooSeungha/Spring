package library.site.service;

import java.util.List;

import library.site.domain.BookListResult;
import library.site.domain.BookRequestListResult;
import library.site.domain.LibraryBook;
import library.site.domain.RentalBookListResult;

public interface AdminBookManageService {
	BookListResult getBookListResult(int cp, int ps);
	BookListResult getBookListResult(int cp, int ps, int catgo, String keyword); //검색기능
	RentalBookListResult getRentalBookListReuslt(int cp, int ps);
	RentalBookListResult getRentalBookListReuslt(int cp, int ps, int catgo, String keyword);
	LibraryBook findBook(long book_num);
	List<String> facilityList(); //시설
	List<String> ClassList(); //장르
	List<Long> clsCount(); //장르별 도서 갯수
	void insertBook(LibraryBook libraryBook);
	void updateBook(LibraryBook libraryBook);
	void deleteBook(long book_num);	
	
	void updateRental(long state, long ren_num);
	void deleteRental(long ren_num);
		
	BookRequestListResult getBookRequestList(int cp, int ps);
	BookRequestListResult getBookRequestList(int cp, int ps, int catgo, String keyword);
}
