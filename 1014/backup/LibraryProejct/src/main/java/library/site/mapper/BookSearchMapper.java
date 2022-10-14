package library.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import library.site.domain.BookVo;
import library.site.domain.LibraryBook;

public interface BookSearchMapper {
	List<LibraryBook> list();
	LibraryBook select(@Param("isbn") String isbn);	
	LibraryBook select_num(@Param("book_num") long book_num);
	List<LibraryBook> selectByName(@Param("title" )String title);
	List<LibraryBook> selectPerPage(BookVo bookVo);
	long selectCount();
}
