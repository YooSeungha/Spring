package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.ReviewJPA;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewJPA, Long> {
	@Query(value = "select * from REVIEW where seq=:seq",
			nativeQuery = true)
	List<ReviewJPA> listBySeq(@Param("seq") long seq);
	
	@Query(value = "select count(*) from REVIEW where seq=:seq",
			nativeQuery = true)
	int reviewCount(@Param("seq") long seq);
}
