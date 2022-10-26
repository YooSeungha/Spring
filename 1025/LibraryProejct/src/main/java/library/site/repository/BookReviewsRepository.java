package library.site.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.BookReviews;

@Repository
public interface BookReviewsRepository extends JpaRepository<BookReviews, Long> {
	
	@Query(value = "select * from book b left outer join book_reviews br on br.book_num=b.book_num left outer join member m on br.mem_num=m.mem_num where b.book_num = :book_num order by br.brs_num desc", nativeQuery = true)
	List<BookReviews> brsList(@Param("book_num") long book_num);
	
	@Query(value = "SELECT * FROM (	SELECT ROWNUM RN, A.* FROM ( select * from book b left outer join book_reviews br on br.book_num=b.book_num left outer join member m on br.mem_num=m.mem_num where b.book_num = :book_num order by br.brs_num desc ) A ) WHERE RN BETWEEN 1 AND :plusPage", nativeQuery = true)
	List<BookReviews> reviewList(@Param("book_num") long book_num, @Param("plusPage") int plusPage);
	
	@Transactional
	@Modifying
	@Query(value = "insert into BOOK_REVIEWS values(BOOK_REVIEWS_SEQ.nextval, :book_num, :mem_num, :brs_content, :brs_rating, 0, 0, SYSDATE, SYSDATE)", nativeQuery = true)
	int writeReviews(@Param("book_num") long book_num, @Param("mem_num") long mem_num, @Param("brs_rating") int brs_rating, @Param("brs_content") String brs_content);
	
	@Transactional
	@Modifying
	@Query(value = "delete from BOOK_REVIEWS where brs_num = :brs_num", nativeQuery = true)
	int deleteReviews(@Param("brs_num") long brs_num);
	
	//총 리뷰 개수
	@Query(value = "select count(*) from BOOK_REVIEWS where book_num = :book_num", nativeQuery = true)
	int reviewTotal(@Param("book_num") long book_num);
	
	//총 리뷰 평균
	@Query(value = "select NVL(sum(brs_rating),0) from BOOK_REVIEWS where book_num = :book_num", nativeQuery = true)
	int reviewAvg(@Param("book_num") long book_num);
	
	// 리뷰 1개짜리 총 개수 
	@Query(value = "select count(*) from BOOK_REVIEWS where book_num = :book_num and brs_rating = 1", nativeQuery = true)
	int reviewOne(@Param("book_num") long book_num);
	
	// 리뷰 2개짜리 총 개수 
	@Query(value = "select count(*) from BOOK_REVIEWS where book_num = :book_num and brs_rating = 2", nativeQuery = true)
	int reviewTwo(@Param("book_num") long book_num);
	
	// 리뷰 3개짜리 총 개수 
	@Query(value = "select count(*) from BOOK_REVIEWS where book_num = :book_num and brs_rating = 3", nativeQuery = true)
	int reviewThree(@Param("book_num") long book_num);
	
	// 리뷰 4개짜리 총 개수 
	@Query(value = "select count(*) from BOOK_REVIEWS where book_num = :book_num and brs_rating = 4", nativeQuery = true)
	int reviewFour(@Param("book_num") long book_num);
	
	// 리뷰 5개짜리 총 개수 
	@Query(value = "select count(*) from BOOK_REVIEWS where book_num = :book_num and brs_rating = 5", nativeQuery = true)
	int reviewFive(@Param("book_num") long book_num);
	
	@Transactional
	@Modifying
	@Query(value = "update book_reviews set brs_like=brs_like+1 where brs_num = :brs_num", nativeQuery = true)
	int reviewUpdateLike(@Param("brs_num") long brs_num);
	
	@Transactional
	@Modifying
	@Query(value = "update book_reviews set brs_like=brs_like-1 where brs_num = :brs_num", nativeQuery = true)
	int reviewDownLike(@Param("brs_num") long brs_num);
	
	@Transactional
	@Modifying
	@Query(value = "update book_reviews set brs_hate=brs_hate+1 where brs_num = :brs_num", nativeQuery = true)
	int reviewUpdateHate(@Param("brs_num") long brs_num);
	
	@Transactional
	@Modifying
	@Query(value = "update book_reviews set brs_hate=brs_hate-1 where brs_num = :brs_num", nativeQuery = true)
	int reviewDownHate(@Param("brs_num") long brs_num);
	
	///////////////////////////////////////////
	// 좋아요 확인 유무 
	@Query(value ="select brl_likecheck from book_reviews_log where mem_num = :mem_num and brs_num = :brs_num", nativeQuery = true)
	int selectLike(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	// 싫어요 확인 유무 
	@Query(value ="select brl_hatecheck from book_reviews_log where mem_num = :mem_num and brs_num = :brs_num", nativeQuery = true)
	int selectHate(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	
	//좋아요 시 인서트 체크
	@Transactional
	@Modifying
	@Query(value = "insert into book_reviews_log VALUES(BOOK_REVIEWS_LOG_SEQ.nextval, :brs_num, :mem_num, 0, 0, SYSDATE, SYSDATE)", nativeQuery = true)
	int likeLog(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	//좋아요 시 업데이트  + 1 체크 
	@Transactional
	@Modifying
	@Query(value ="update book_reviews_log set brl_likecheck=brl_likecheck+1 where brs_num = :brs_num and mem_num = :mem_num", nativeQuery = true)
	int updateLikePlus(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	//좋아요 시 업데이트  - 1 체크 
	@Transactional
	@Modifying
	@Query(value ="update book_reviews_log set brl_likecheck=brl_likecheck-1 where brs_num = :brs_num and mem_num = :mem_num", nativeQuery = true)
	int updateLikeMinus(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	
	//싫어요 시 인서트 체크
	@Transactional
	@Modifying
	@Query(value = "insert into book_reviews_log VALUES(BOOK_REVIEWS_LOG_SEQ.nextval, :brs_num, :mem_num, 0, 0, SYSDATE, SYSDATE)", nativeQuery = true)
	int hateLog(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	//싫어요 시 업데이트  + 1 체크 
	@Transactional
	@Modifying
	@Query(value ="update book_reviews_log set brl_hatecheck=brl_hatecheck+1 where brs_num = :brs_num and mem_num = :mem_num", nativeQuery = true)
	int updateHatePlus(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	//싫어요 시 업데이트  - 1 체크 
	@Transactional
	@Modifying
	@Query(value ="update book_reviews_log set brl_hatecheck=brl_hatecheck-1 where brs_num = :brs_num and mem_num = :mem_num", nativeQuery = true)
	int updateHateMinus(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
	
	//리뷰 로그 테이블에 데이터가 존재하는지 유무 
	@Query(value = "select count(brl_num) from book_reviews_log where brs_num = :brs_num and mem_num = :mem_num", nativeQuery = true)
	int dataExists(@Param("brs_num") long brs_num, @Param("mem_num") long mem_num);
}
