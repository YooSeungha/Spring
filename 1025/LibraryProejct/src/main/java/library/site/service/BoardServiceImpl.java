package library.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.domain.BoardVo;
import library.site.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor //repository ÀÇÁ¸¼º
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;	
	
	@Override
	public List<Board> catgoL(BoardVo boardVo){
		return boardMapper.catgoL(boardVo);
	}
	@Override
	public List<Board> readL() {
		List<Board> readL = boardMapper.readL();	
		
		/*
		 * for(Member member: members) { log.info("##Member : " + member); }
		 */		
		return readL;
	}
	public List<Board> titleL(String keyword) {
		List<Board> titleL = boardMapper.titleL(keyword);
		return titleL;
	}
	
	@Override
	public void writeL(Board board) {
		log.info(board);
		boardMapper.writeL(board);
	}

	@Override
	public Board selectS(long seq) {
		Board select = boardMapper.selectS(seq);
		return select;
	}
	
	@Override
	public void updateS(Board board) {
		boardMapper.updateS(board);
	}
	@Override
	public void deleteS(long seq) {
		boardMapper.deleteS(seq);
	}
	@Override
	public void readCount(long seq) {
		boardMapper.readCount(seq);
	}
	@Override
	public List<Board> selectPerPage(BoardVo boardVo){
		return boardMapper.selectPerPage(boardVo);
	}
	
	//for Search
	@Override
	public BoardListResult getBoardListResult(int cp, int ps, String catgo, String keyword) { //for Search
		BoardVo boardVo = new BoardVo(cp, ps, catgo, keyword); 
		long totalCount = boardMapper.selectCountByCatgo(boardVo);
		List<Board> list = boardMapper.selectPerPageByCatgo(boardVo); 
		
		return new BoardListResult(cp, totalCount, ps,  list);
	}
	@Override
	public List<Board> search(BoardVo boardVo){
		return boardMapper.search(boardVo);
	}

}
