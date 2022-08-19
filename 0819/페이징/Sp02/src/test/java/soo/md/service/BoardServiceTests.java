package soo.md.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")



public class BoardServiceTests {
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testListS() {
		log.info("#boardService: " + boardService);
		List<Board> list = boardService.listS();
		log.info("#boardMapper list: " + list);
	}
	
	@Test
	public void testInsertS() {
		Board board = new Board(-1L, "testW", "testE", "testS", "testC", null);
		boardService.insertS(board);
		log.info("#boardService testInsert() 성공");
	}
	
	@Test
	public void testUpdateS() {
		Board board = new Board(-1L,  null,  null, "testS1", "testC1", null);
		boardService.updateS(board);
		log.info("#boardService testDelete() 성공");
	}
	
	@Test
	public void testDeleteS() {
		long seq = 16;
		boardService.deleteS(seq);
		log.info("#boardService testDelete() 성공");
	}
}