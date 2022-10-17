package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;

@Repository
public interface RentalBookRepository extends JpaRepository<RentalBook, Long> {
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from "
			+ "(select * from RENTAL order by REN_STAT asc, BOOK_NUM desc) aa)"
			+ " where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<RentalBook> selectPerPage(@Param("startRow") int startRow, @Param("endRow") int endRow);
	
	@Query(value = "select nvl(max(ROWNUM), 0) from RENTAL",
			nativeQuery = true)
	long countTot();	
	
	@Query(value = "select nvl(max(ROWNUM), 0) from RENTAL where MEM_NUM=:mem_num and REN_STAT<2",
			nativeQuery = true)
	long mem_rentalCount(@Param("mem_num") long mem_num); //회원이 대출중인 책 갯수	
	
	@Query(value= "select * from (select ROWNUM rnum, aa.* from (select * from RENTAL where BOOK_NUM in" + 
			"(select BOOK_NUM from BOOK where BOOK_TITLE like %:book_title%) order by REN_STAT asc, BOOK_NUM desc) aa) " + 
			"where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<RentalBook> searchRentalBook(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("book_title") String book_title);
	
	@Query(value = "select nvl(max(ROWNUM), 0) from (select ROWNUM rnum from RENTAL where BOOK_NUM in " + 
			"(select BOOK_NUM from BOOK where BOOK_TITLE like %:book_title%) order by BOOK_NUM desc)",
			nativeQuery = true)
	long search_rentalCount(@Param("book_title") String book_title); // 검색한 책 갯수	
	
	@Query(value= "select * from (select ROWNUM rnum, aa.* from (select * from RENTAL where BOOK_NUM in " + 
			"(select BOOK_NUM from BOOK where BOOK_TITLE like %:book_title%) and REN_STAT=:ren_stat order by BOOK_NUM desc) aa) " + 
			"where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<RentalBook> searchRentalBook(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("book_title") String book_title, @Param("ren_stat") long ren_stat); //검색한 대출 도서
	
	@Query(value = "select nvl(max(ROWNUM), 0) from (select ROWNUM rnum from RENTAL where BOOK_NUM in " + 
			"(select BOOK_NUM from BOOK where BOOK_TITLE like %:book_title%) and REN_STAT=:ren_stat order by BOOK_NUM desc)",
			nativeQuery = true)
	long search_rentalCount(@Param("book_title") String book_title, @Param("ren_stat") long ren_stat); // 검색한 책 갯수
	
	@Query(value = "select * from RENTAL where MEM_NUM=:mem_num order by ren_num desc",
			nativeQuery = true)
	List<RentalBook> getMem_rentalBook(@Param("mem_num") long mem_num);
	
	@Query(value = "select nvl(count(REN_BORROW),0) from RENTAL where "
			+ "REN_BORROW=:date group by REN_BORROW",
			nativeQuery = true)
	Long getLastWeekRentalCount(@Param("date") String date); //지난주 전체 책 대출 수
	
	@Query(value = "select NVL(COUNT(REN_BORROW), 0) from RENTAL where BOOK_NUM in " + 
			"(select BOOK_NUM from BOOK where BOOK_CODE= (select CF_CODE from CLASSIFICATION " + 
			"where CF_NAME=:catgo)) and REN_BORROW>=:fDay and REN_BORROW<=:eDay",
			nativeQuery = true)
	Long getLastMonthCatgoRentalCount(@Param("catgo") String catgo, @Param("fDay") String fDay, @Param("eDay") String eDay);
	
	@Query(value = "select count(BOOK_NUM) from RENTAL " + 
			"where REN_BORROW>=:fDay and REN_BORROW<=:eDay " + 
			"group by BOOK_NUM order by count(BOOK_NUM) desc",
			nativeQuery = true)
	List<Long> getLastMonthPopRentalCount(@Param("fDay") String fDay, @Param("eDay") String eDay);
	
	@Query(value = "select BOOK_NUM from " + 
			"(select BOOK_NUM, count(BOOK_NUM) " + 
			"from RENTAL where REN_BORROW>=:fDay and REN_BORROW<=:eDay " + 
			"group by BOOK_NUM order by " + 
			"count(BOOK_NUM) desc) where ROWNUM<=10",
			nativeQuery = true)
	List<Long> getLastMonthPopRentalBook(@Param("fDay") String fDay, @Param("eDay") String eDay);
	
	@Query(value = "select COUNT(*) from RENTAL where REN_BORROW=:date " + 
			"and BOOK_NUM = (select BOOK_NUM from BOOK where book_isbn=:isbn)",
			nativeQuery = true)
	Long getLastWeekBookRentalCount(@Param("date") String date, @Param("isbn") String isbn); // 지난주 지정 책 대출 수
}
