package library.site.service;

import java.util.List;

import org.springframework.stereotype.Service;

import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.domain.BoardVo;
import library.site.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;
	
	
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		BoardVo boardVO = new BoardVo(cp, ps);
		long totalCount = boardMapper.selectCount();
		List<Board> list = boardMapper.selectPerPage(boardVO);
		
		return new BoardListResult(cp, totalCount, ps, list);
	}

	@Override
	public BoardListResult getBoardListResult(int cp, int ps, String catgo, String keyword) {
		BoardVo boardVo = new BoardVo(cp,ps,catgo,keyword);
		long totalCount = boardMapper.selectCountByCatgo(boardVo);
		List<Board> list = boardMapper.selectPerPageByCatgo(boardVo);
		
		return new BoardListResult(cp, totalCount, ps, list);
	}

	@Override
	public Board getBoard(long seq) {
		Board board = boardMapper.selectBySeq(seq);
		return board;
	}

	@Override
	public void write(Board board) {
		boardMapper.insert(board);

	}

	@Override
	public void edit(Board board) {
		boardMapper.update(board);

	}

	@Override
	public void remove(long seq) {
		boardMapper.delete(seq);

	}

}
