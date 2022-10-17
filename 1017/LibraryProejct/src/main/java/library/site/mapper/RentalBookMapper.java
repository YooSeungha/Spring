package library.site.mapper;

import java.util.Map;

import library.site.domain.RentalBookDAO;

public interface RentalBookMapper {
	void insert(RentalBookDAO rb);
	RentalBookDAO select(long book_num);
	RentalBookDAO selectRental(Map<String, Object> map);	
	long selectCount(long book_num); //대출한 책 갯수
}
