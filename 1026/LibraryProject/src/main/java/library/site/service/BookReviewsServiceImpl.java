package library.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import library.site.domain.BookReviews;
import library.site.repository.BookReviewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor //을 사용하지 않으면 따로 생성자를 주입해야 함 아래는 final
public class BookReviewsServiceImpl implements BookReviewsService {

	@Autowired
	private final BookReviewsRepository brr;
	
	@Override
	public List<BookReviews> brsList(long book_num) {
		//BookReviews list = brr.findById(3L).orElseThrow(()->new IllegalArgumentException("오류 발생 !!"));
		log.info("## 1번째: +list");
		return brr.brsList(book_num);
	}

	@Override
	public int writeReviews(long book_num, long mem_num, int brs_rating, String brs_content) {
		log.info("@@ bookReviews 북번호 : "+book_num+"멤버 번호: "+mem_num+"평점: "+brs_rating+"내용: "+brs_content);
		return brr.writeReviews(book_num, mem_num, brs_rating, brs_content);
	}

	@Override
	public int deleteReviews(long brs_num) {
		return brr.deleteReviews(brs_num);
	}

	@Override
	public int reviewTotal(long book_num) {
		return brr.reviewTotal(book_num);
	}

	@Override
	public int reviewAvg(long book_num) {
		return brr.reviewAvg(book_num);
	}

	@Override
	public int reviewOne(long book_num) {
		return brr.reviewOne(book_num);
	}

	@Override
	public int reviewTwo(long book_num) {
		return brr.reviewTwo(book_num);
	}

	@Override
	public int reviewThree(long book_num) {
		return brr.reviewThree(book_num);
	}

	@Override
	public int reviewFour(long book_num) {
		return brr.reviewFour(book_num);
	}

	@Override
	public int reviewFive(long book_num) {
		return brr.reviewFive(book_num);
	}

	@Override
	public List<BookReviews> reviewList(long book_num, int plusPage) {
		log.info("@@ 서비스단 plusPage: "+plusPage);
		return brr.reviewList(book_num, plusPage);
	}

	@Override
	public int reviewUpdateLike(long brs_num) {
		return brr.reviewUpdateLike(brs_num);
	}

	@Override
	public int reviewUpdateHate(long brs_num) {
		return brr.reviewUpdateHate(brs_num);
	}

	@Override
	public int reviewDownLike(long brs_num) {
		return brr.reviewDownLike(brs_num);
	}

	@Override
	public int reviewDownHate(long brs_num) {
		return brr.reviewDownHate(brs_num);
	}

	@Override
	public int likeLog(long brs_num, long mem_num) {
		return brr.likeLog(brs_num, mem_num);
	}

	@Override
	public int updateLikePlus(long brs_num, long mem_num) {
		return brr.updateLikePlus(brs_num, mem_num);
	}

	@Override
	public int updateLikeMinus(long brs_num, long mem_num) {
		return brr.updateLikeMinus(brs_num, mem_num);
	}

	@Override
	public int hateLog(long brs_num, long mem_num) {
		return brr.hateLog(brs_num, mem_num);
	}

	@Override
	public int updateHatePlus(long brs_num, long mem_num) {
		return brr.updateHatePlus(brs_num, mem_num);
	}

	@Override
	public int updateHateMinus(long brs_num, long mem_num) {
		return brr.updateHateMinus(brs_num, mem_num);
	}

	@Override
	public int selectLike(long brs_num, long mem_num) {
		return brr.selectLike(brs_num, mem_num);
	}

	@Override
	public int selectHate(long brs_num, long mem_num) {
		return brr.selectHate(brs_num, mem_num);
	}

	@Override
	public int dataExists(long brs_num, long mem_num) {
		return brr.dataExists(brs_num, mem_num);
	}

}
