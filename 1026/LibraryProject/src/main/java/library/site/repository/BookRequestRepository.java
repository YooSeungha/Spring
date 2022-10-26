package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.BookRequestDAO;
import library.site.domain.RentalBook;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequestDAO, Long> {
	@Query(value = "select count(*) from BOOK_REQUEST where MEM_NUM=:mem_num "
			+ "and BR_ISBN=:isbn",
			nativeQuery = true)
	Long findRequestInfo(@Param("mem_num") long mem_num, @Param("isbn") String isbn);
	
	@Query(value = "select count(*) from BOOK_REQUEST where BR_ISBN=:isbn",
			nativeQuery = true)
	Long findRequestBook(@Param("isbn") String isbn);
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from "
			+ "(select * from BOOK_REQUEST order by BR_NUM desc) aa) "
			+ "where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<BookRequestDAO> findBookRequestList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	
	@Query(value= "select * from (select ROWNUM rnum, aa.* from " + 
			"(select * from (select * from BOOK_REQUEST where BR_TITLE like %:keyword% or BR_WRITER like %:keyword%) " + 
			"order by BR_NUM desc) aa) where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<BookRequestDAO> searchfindBookRequestList(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("keyword") String keyword); //검색한 대출 도서
	
	@Query(value= "select * from (select ROWNUM rnum, aa.* from " + 
			"(select * from (select * from BOOK_REQUEST where BR_TITLE like %:keyword% or BR_WRITER like %:keyword%) " + 
			"where BR_STAT=:cat order by BR_NUM desc) aa) where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<BookRequestDAO> searchfindBookRequestList(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("keyword") String keyword, @Param("cat") long cat); //검색한 대출 도서
	
	@Query(value = "select nvl(MAX(ROWNUM), 0) from BOOK_REQUEST",
			nativeQuery = true)
	Long getTotCount();
	
	@Query(value = "select nvl(MAX(ROWNUM), 0) from BOOK_REQUEST where BR_TITLE like %:keyword% or "
			+ "BR_WRITER like %:keyword%",
			nativeQuery = true)
	Long getSearchTotCount(@Param("keyword") String keyword);
	
	@Query(value = "select nvl(MAX(ROWNUM), 0) from BOOK_REQUEST where BR_TITLE like %:keyword% or "
			+ "BR_WRITER like %:keyword% and BR_STAT=:catgo",
			nativeQuery = true)
	Long getSearchTotCount(@Param("keyword") String keyword, @Param("catgo") int catgo);
	
	@Query(value = "select * from BOOK_REQUEST where BR_ISBN=:isbn",
			nativeQuery = true)
	BookRequestDAO findByIsbn(@Param("isbn") String isbn);
	
	@Query(value = "select * from BOOK_REQUEST where MEM_NUM=:mem_num",
			nativeQuery = true)
	List<BookRequestDAO> getMem_requestBook(@Param("mem_num") long mem_num);
}
