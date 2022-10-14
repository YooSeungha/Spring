package library.site.mapper;

import java.util.List;

import library.site.domain.Review;

public interface ReviewMapper {
	List<Review> Reviewread(long seq);
	void ReviewCreate(Review review);
}
