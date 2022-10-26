package library.site.mapper;

import java.util.List;

public interface FacilityMapper {
	String book_loc(long book_fnum);	
	long book_floor(long book_fnum);
	List<String> nameList();
}
