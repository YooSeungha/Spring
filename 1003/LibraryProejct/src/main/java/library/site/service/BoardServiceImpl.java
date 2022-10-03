package library.site.service;

import java.io.*;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.domain.BoardVo;
import library.site.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

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
	public Board getBoard(long pb_num) {
		Board board = boardMapper.selectBySeq(pb_num);
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
	public void remove(long pb_num) {
		boardMapper.delete(pb_num);

	}
	@Override
	public void review(long pb_num) {
		boardMapper.review(pb_num);
	}
	
}
