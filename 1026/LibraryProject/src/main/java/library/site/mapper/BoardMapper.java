package library.site.mapper;

import java.util.List;

import library.site.domain.Board;
import library.site.domain.BoardVo;

public interface BoardMapper {
	List<Board> readL();
	List<Board> titleL(String keyword);
	List<Board> catgoL(BoardVo boardVo);

	void writeL(Board board);
	Board selectS(long seq);
	void updateS(Board board);
	void deleteS(long seq);
	void readCount(long seq);
	List<Board> selectPerPage(BoardVo boardVo);
	long selectCount();
	List<Board> search(BoardVo boardVo);
	long count();
	//이전글다음글
	Board preBoard(long b_num);
	Board nextBoard(long b_num);
	//
	String selectBySeq(long mem_num);
	
	//for Search
	List<Board> selectPerPageByCatgo(BoardVo boardVo);
	long selectCountByCatgo(BoardVo boardVo);
	
	
	
}
