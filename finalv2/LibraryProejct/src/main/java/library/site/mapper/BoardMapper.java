package library.site.mapper;

import java.util.List;
import library.site.domain.Board;
import library.site.domain.BoardVo;

public interface BoardMapper {
	List<Board> selectPerPage(BoardVo boardVo);
	Board selectBySeq(long seq);
	long selectCount();
	
	void insert(Board board);
	void update(Board board);
	void delete(long seq);
	void review(long seq);
	
	List<Board> selectPerPageByCatgo(BoardVo boardvo);
	long selectCountByCatgo(BoardVo boardvo);
}
