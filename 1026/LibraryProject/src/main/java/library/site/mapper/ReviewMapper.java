package library.site.mapper;

import java.util.List;

import library.site.domain.Review;

public interface ReviewMapper {
	List<Review> Reviewread(long seq);
	Review selectReview(long num);
	List<Review> ReviewreadRow(Review review);
	Long CountReview (long seq);
	void ReviewCreate(Review review);
	void ReviewUpdate(Review review);
	void ReviewDelete(long num);
}
