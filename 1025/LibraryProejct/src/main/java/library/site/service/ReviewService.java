package library.site.service;

import java.util.List;

import library.site.domain.Review;

public interface ReviewService {
	List<Review> Reviewread(long seq);
	void ReviewCreate(Review review);
}
