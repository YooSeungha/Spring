package library.site.service;

import java.util.List;

import library.site.domain.BookListResult;
import library.site.domain.LibraryBook;

public interface AdminBookManageService {
	BookListResult getBookListResult(int cp, int ps);
	BookListResult getBookListResult(int cp, int ps, String catgo, String keyword); //�˻����
	LibraryBook findBook(long book_num);
	List<String> facilityList();
	void updateBook(LibraryBook libraryBook);
}
