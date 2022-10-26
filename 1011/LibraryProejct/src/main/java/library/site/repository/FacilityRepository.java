package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.Facility;
@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {
	@Query(value = "SELECT f_name FROM facility order by F_NUM asc",
			nativeQuery = true)
	List<String> findBook_loc();
}
