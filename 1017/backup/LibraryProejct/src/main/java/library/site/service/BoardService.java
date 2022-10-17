package library.site.service;

import java.util.List;

import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.domain.BoardVo;

public interface BoardService {
	List<Board> readL();
	List<Board> titleL(String keyword);
	void writeL(Board board);
	Board selectS(long seq);
	void updateS(Board board);
	void deleteS(long seq);
	void readCount(long seq);
	List<Board> selectPerPage(BoardVo boardVo);
	List<Board> search(BoardVo boardVo);
	List<Board> catgoL(BoardVo boardVo);
	//for Serach
	BoardListResult getBoardListResult(int cp, int ps, String catgo, String keyword);
}
