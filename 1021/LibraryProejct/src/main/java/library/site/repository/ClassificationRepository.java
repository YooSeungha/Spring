package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import library.site.domain.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {
	@Query(value = "SELECT cf_name from CLASSIFICATION order by cf_code asc",
			nativeQuery = true)
	List<String> findClass_name();
	
	@Query(value = "select count(book_code) from book b inner join "
			+ "classification c on b.book_code = c.cf_code group by book_code order by c.cf_code asc",
			nativeQuery = true)
	List<Long> countClass_num();	
}
