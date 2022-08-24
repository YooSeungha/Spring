package soo.md.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	@Autowired
	private BoardService boardService;
	
	
//	@Test
//	public void testList(){
//		log.info("#boardService: " + boardService);
//		List<Board> list = boardService.listS();
//		log.info("#boardService list: " + list);
//	}
//	@Test
//	public void testInsert(){
//		Board board = new Board(-1L, "스프링2", "복잡하지2","Test","Test", null);
//		boardService.insertS(board);
//		log.info("#boardService testInsert() 수행성공");
//	}
//	@Test
//	public void testUpdate() {
//		Board board = new Board();
//		board.setSeq(17);
//		board.setWriter("홍길동");
//		board.setEmail("hong@naver.com");
//		board.setSubject("Test");
//		board.setContent("Test");
//		board.setRdate(null);
//		boardService.updateS(board);
//		log.info("boardService testUpdate() 수행성공");
//	}
//	
	@Test
	public void testDelete() {
		long seq = 17;
		boardService.deleteS(seq);
		log.info("#boardService testDelete() 수행성공");
	}
}
