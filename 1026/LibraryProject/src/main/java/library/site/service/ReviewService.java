package library.site.service;

import java.util.List;

import library.site.domain.Review;

public interface ReviewService {
	List<Review> Reviewread(long seq);
	Review selectReview(long num);
	List<Review> ReviewreadRow(Review review);
	long CountReview (long seq);
	void ReviewCreate(Review review);
	void ReviewUpdate(Review review);
	void ReviewDelete(long num);
}
