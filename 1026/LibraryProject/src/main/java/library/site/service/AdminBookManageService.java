package library.site.service;

import java.util.List;

import library.site.domain.BookListResult;
import library.site.domain.BookRequestListResult;
import library.site.domain.DvdDAO;
import library.site.domain.DvdListResult;
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
	
	DvdListResult getDvdList(int cp, int ps);
	DvdListResult getDvdList(int cp, int ps, String keyword);
	void insertDvd(DvdDAO dvdDAO);
	void updateDvd(DvdDAO dvdDAO);
	void deleteDvd(int dvd_num);
	DvdDAO findDvd(int dvd_num);
}
