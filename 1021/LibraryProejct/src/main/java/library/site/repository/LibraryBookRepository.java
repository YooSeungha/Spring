package library.site.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.LibraryBook;
@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {
	@Query(value = "SELECT * FROM book WHERE book_num = :book_num",
			nativeQuery = true)
	LibraryBook findByBook_num(@Param("book_num") long book_num);
	
	@Query(value = "SELECT MAX(book_num) FROM book",
			nativeQuery = true)
	long findMaxNum();
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from "
			+ "(select * from BOOK where BOOK_TITLE like %:book_title% "
			+ "order by book_num desc) aa) where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<LibraryBook> searchBook(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("book_title") String book_title);
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from "
			+ "(select * from BOOK where BOOK_TITLE like %:book_title% and BOOK_CODE=:catgo "
			+ "order by book_num desc) aa) where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<LibraryBook> searchCatgoBook(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("book_title") String book_title, @Param("catgo") int catgo);
	
	@Query(value = "select nvl(max(ROWNUM), 0) from BOOK where BOOK_TITLE like %:book_title%",
			nativeQuery = true)
	long searchTot(@Param("book_title") String book_title);
	
	@Query(value = "select nvl(max(ROWNUM), 0) from BOOK where BOOK_TITLE like %:book_title% and BOOK_CODE=:catgo",
			nativeQuery = true)
	long searchCatgoTot(@Param("book_title") String book_title, @Param("catgo") int catgo);
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from " + 
			"(select * from BOOK where BOOK_RECOMEND=1 order by BOOK_NUM desc) aa) " + 
			"where rnum>0 and rnum<=10",
			nativeQuery = true)
	List<LibraryBook> searchRecomendBook();
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from " + 
			"(select * from BOOK where BOOK_RECOMEND=1 order by BOOK_NUM desc) aa) " + 
			"where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<LibraryBook> searchRecomendBook(@Param("startRow") int startRow, @Param("endRow") int endRow);
	
	@Query(value = "select nvl(max(ROWNUM), 0) from BOOK where BOOK_RECOMEND=1",
			nativeQuery = true)
	long RecomendTot();	
}
