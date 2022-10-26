package library.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.Review;
import library.site.mapper.ReviewMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewmapper;
	@Override
	public List<Review> Reviewread(long seq) {
		return reviewmapper.Reviewread(seq);
	}
	@Override
	public List<Review> ReviewreadRow(Review review){
		return reviewmapper.ReviewreadRow(review);
	}
	@Override
	public long CountReview (long seq) {
		long count = reviewmapper.CountReview(seq);
		return count;
	}
	@Override
	public Review selectReview(long num) {
		return reviewmapper.selectReview(num);
	}
	@Override
	public void ReviewCreate(Review review) {
		log.info("########:" +review);
		reviewmapper.ReviewCreate(review);
		
	}
	@Override
	public void ReviewUpdate(Review review) {
		log.info("review : " + review);
		reviewmapper.ReviewUpdate(review);
	}
	@Override
	public void ReviewDelete(long num) {
		reviewmapper.ReviewDelete(num);
	}
}
