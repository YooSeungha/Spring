package library.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.Review;
import library.site.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewmapper;
	@Override
	public List<Review> Reviewread(long seq) {
		return reviewmapper.Reviewread(seq);
	}
	@Override
	public void ReviewCreate(Review review) {
		reviewmapper.ReviewCreate(review);
	}
}
