package library.site.mapper;

import java.util.List;
import library.site.domain.Board;
import library.site.domain.BoardVo;

public interface BoardMapper {
	List<Board> selectPerPage(BoardVo boardVo);
	Board selectBySeq(long pb_num);
	long selectCount();
	
	void insert(Board board);
	void update(Board board);
	void delete(long pb_num);
	void review(long pb_num);
	
	List<Board> selectPerPageByCatgo(BoardVo boardvo);
	long selectCountByCatgo(BoardVo boardvo);
}
