package library.site.service;

import java.util.List;

import library.site.domain.Book;
import library.site.domain.BookListResult;
import library.site.domain.LibraryBook;

public interface BookSearch {
	BookListResult getBookListResult(int cp, int ps); //인기도서 리스트
	BookListResult getBookListResult(int sorted, int cp, int ps, long catgo, String keyword); //도서검색
	BookListResult getBookCatgoListResult(int typed, int cp, int ps, int catgoId); //카테고리별 검색
	Book getBook(String isbn); //알라딘 api 책 가져오기
	LibraryBook getLibraryBook(String isbn); //db책 가져오기(isbn으로)
	LibraryBook getLibraryBookNum(long book_num); //db책 가져오기(책번호로)
	BookListResult getBookCatgoRefer(int catgoId);
	BookListResult getBookWriterRefer(String writer);
	List<LibraryBook> autoComplete(String title);
	String BookLocation(String isbn);
	long BookFloor(String isbn);
}
