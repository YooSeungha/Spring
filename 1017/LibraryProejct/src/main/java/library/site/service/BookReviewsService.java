package library.site.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import library.site.domain.BookReviews;

public interface BookReviewsService {
	List<BookReviews> brsList(long book_num); //해당하는 북에대한 리뷰 가져오는 메소드
	List<BookReviews> reviewList(long book_num, int plusPage);
	
	int writeReviews(long book_num, long mem_num, int brs_rating, String brs_content); //리뷰 글쓰기
	int deleteReviews(long brs_num);
	int reviewTotal(long book_num); // 리뷰 총 개수
	int reviewAvg(long book_num);	// 리뷰 평균
	
	int reviewOne(long book_num);
	int reviewTwo(long book_num);
	int reviewThree(long book_num);
	int reviewFour(long book_num);
	int reviewFive(long book_num);
	
	
	int reviewUpdateLike(long brs_num); //좋아요 시 1 업데이트
	int reviewDownLike(long brs_num);	// 좋아요 한번 더 누를 시 다운
	int reviewUpdateHate(long brs_num); //싫어요 시 1 업데이트
	int reviewDownHate(long brs_num);	// 싫어요 한번 더 누를 시 다운
	
	///////////////리뷰 로그////////////////
	int selectLike(long brs_num,long mem_num); // 좋아요 확인 유무 
	int selectHate(long brs_num,long mem_num);	// 싫어요 확인 유무 
	
	int likeLog(long brs_num,long mem_num); //좋아요 시 인서트 체크
	int updateLikePlus(long brs_num, long mem_num); //좋아요 시 업데이트  + 1 체크
	int updateLikeMinus(long brs_num, long mem_num);//좋아요 시 업데이트  - 1 체크 
	
	int hateLog(long brs_num, long mem_num); //싫어요 시 인서트 체크
	int updateHatePlus(long brs_num, long mem_num);	//싫어요 시 업데이트  + 1 체크 
	int updateHateMinus(long brs_num, long mem_num);	//싫어요 시 업데이트  - 1 체크
	
	int dataExists(long brs_num, long mem_num);	//리뷰 로그 테이블에 데이터가 존재하는지 유무 
	
}
