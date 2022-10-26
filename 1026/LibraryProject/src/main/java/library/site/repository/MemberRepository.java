package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	@Query(value = "SELECT * FROM member order by mem_num desc",
			nativeQuery = true)
	List<Member> findAllOrderBy_MEMNUM_desc();
	
	@Query(value = "select * from MEMBER where MEM_NUM=:memnum",
			nativeQuery = true)
	Member findByMem_num(@Param("memnum") long memnum);
}
