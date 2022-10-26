package library.site.service;

import java.util.List;
import java.util.Map;

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
	Map<String, Object> selectPerPage(BoardVo boardVo);
	List<Board> search(BoardVo boardVo);
	List<Board> catgoL(BoardVo boardVo);
	
	String selectBySeq(long mem_num);
	long count();
	//이전글다음글
	Board preBoard(long b_num);
	Board nextBoard(long b_num);
	
	//for Serach
	BoardListResult getBoardListResult(int cp, int ps, String catgo, String keyword);
}
