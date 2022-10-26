package library.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.site.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	@Query(value = "SELECT MEM_NAME FROM MEMBER WHERE MEM_NUM = :mem_num",
			nativeQuery = true)
	String findName(@Param("mem_num") long mem_num);
}
