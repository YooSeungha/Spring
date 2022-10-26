package library.site.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import library.site.domain.BookRequestDAO;
import library.site.domain.DvdDAO;

public interface DvdRepository extends JpaRepository<DvdDAO, Long> {
	@Query(value = "select count(*) from DVD",
			nativeQuery = true)
	Long getTotCount();
	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from (select * from DVD order by DVD_NUM desc) aa) " + 
			"where rnum>:startRow and rnum<=:endRow order by DVD_NUM desc",
	nativeQuery = true)
	List<DvdDAO> selectPerPage(@Param("startRow") int startRow, @Param("endRow" )int endRow);
	
	@Query(value= "select * from (select ROWNUM rnum, aa.* from " + 
			"(select * from (select * from DVD where DVD_TITLE like %:keyword% or DVD_DIRECTOR like %:keyword%) " + 
			"order by DVD_NUM desc) aa) where rnum>:startRow and rnum<=:endRow",
			nativeQuery = true)
	List<DvdDAO> searchDvdPage(@Param("startRow") int startRow, @Param("endRow") int endRow, @Param("keyword") String keyword); //검색한 대출 도서
	
	@Query(value = "select nvl(MAX(ROWNUM), 0) from DVD where DVD_TITLE like %:keyword% or "
			+ "DVD_DIRECTOR like %:keyword%",
			nativeQuery = true)
	Long searchDvdCount(@Param("keyword") String keyword);
	
	@Transactional
	@Modifying
	@Query(value = "insert into DVD values(DVD_SEQ.nextval, :f_num, :dvd_title, :dvd_content, :dvd_director, :dvd_img, SYSDATE)",
			nativeQuery = true)
	void insertDvd(@Param("f_num") int f_num, @Param("dvd_title") String dvd_title, @Param("dvd_content") String dvd_content, 
			@Param("dvd_director") String dvd_director, @Param("dvd_img") String dvd_img);
	
	@Transactional
	@Modifying
	@Query(value = "update DVD set DVD_TITLE=:dvd_title, DVD_CONTENT=:dvd_content, DVD_DIRECTOR=:dvd_director, DVD_IMG=:dvd_img, F_NUM=:f_num\r\n" + 
			"where DVD_NUM=:dvd_num",
			nativeQuery = true)
	void updateDvd(@Param("dvd_num") int dvd_num, @Param("f_num") int f_num, @Param("dvd_title") String dvd_title, @Param("dvd_content") String dvd_content, 
			@Param("dvd_director") String dvd_director, @Param("dvd_img") String dvd_img);
	
	@Transactional
	@Modifying
	@Query(value = "delete from DVD where DVD_NUM=:dvd_num",
			nativeQuery = true)
	void deleteDvd(@Param("dvd_num") int dvd_num);
	
	@Query(value = "select * from DVD where DVD_NUM=:dvd_num",
			nativeQuery = true)
	DvdDAO getDvdByDvd_num(@Param("dvd_num") int dvd_num);
}
