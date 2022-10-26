package library.site.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.domain.BoardVo;
import library.site.domain.ReviewJPA;
import library.site.mapper.BoardMapper;
import library.site.repository.BoardRepository;
import library.site.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	private final ReviewRepository rvRepository;
	private final BoardRepository bRepository;
	@Override
	public List<Board> catgoL(BoardVo boardVo){
		return boardMapper.catgoL(boardVo);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Board> readL() {
		List<Board> readL = boardMapper.readL();
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
	@Transactional(readOnly = true)
	public Board selectS(long seq) {
		Board select = boardMapper.selectS(seq);
		//ReviewJPA review = rvRepository.findById(3L).orElseThrow(()-> new IllegalArgumentException("에러"));
		Board board = bRepository.findById(seq).orElseThrow(()-> new IllegalArgumentException("에러"));
		log.info("###board : " + board);

		return board;
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
	@Transactional(readOnly = true)
	public Map<String, Object> selectPerPage(BoardVo boardVo){
		int startRow = boardVo.getStartRow();
		int endRow = boardVo.getEndRow();
		boardMapper.selectPerPage(boardVo);
		
		List<Board> list = bRepository.selectPerPage(startRow, endRow);	
		List<Integer> reviewnums = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			long num = list.get(i).getB_num();
			int reviewcount = rvRepository.reviewCount(num);
			log.info("######reviewcount : " + reviewcount);
			reviewnums.add(reviewcount);
		}
		Map<String, Object> Map = new HashMap<String, Object>();
		Map.put("list", list);
		Map.put("reviewCount", reviewnums);
		return Map;
	}
	
	@Override
	public String selectBySeq(long mem_num) {
		return boardMapper.selectBySeq(mem_num);
	}
	//이전글다음글
	@Override
	public Board preBoard(long b_num) {
		return boardMapper.preBoard(b_num);
	}
	@Override
	public Board nextBoard(long b_num) {
		return boardMapper.nextBoard(b_num);
	}
	
	//총게시물수
	@Override
	public long count() {
		return boardMapper.count();
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
