package library.site.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import library.site.domain.LibraryBook;
import library.site.domain.RentalBook;

public interface RentalBookMapper {
	void insert(RentalBook rb);
	RentalBook select(long book_num);
	RentalBook selectRental(Map<String, Object> map);	
	long selectCount(long book_num); //대출한 책 갯수
}
