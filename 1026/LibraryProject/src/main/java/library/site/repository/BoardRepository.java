package library.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import library.site.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {	
	@Query(value = "select * from (select ROWNUM rnum, aa.* from (select * from BOARD order by b_num desc) aa)" + 
			" where rnum>:startRow and rnum<=:endRow order by b_num desc",
	nativeQuery = true)
	List<Board> selectPerPage(@Param("startRow") int startRow, @Param("endRow" )int endRow);
	
}
