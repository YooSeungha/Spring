package soo.md.mapper;

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



public class BoardMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testList() {
		log.info("#boardMapper: " + boardMapper);
		List<Board> list = boardMapper.list();
		log.info("#boardMapper list: " + list);
	}
	
	@Test
	public void testInsert() {
		Board board = new Board(-1L, "testW", "testE", "testS", "testC", null);
		boardMapper.insert(board);
		log.info("#boardMapper testInsert() 성공");
	}
	
	@Test
	public void testUpdateS() {
		Board board = new Board(-1L,  null,  null, "testS1", "testC1", null);
		boardMapper.update(board);
		log.info("#boardService testDelete() 성공");
	}
	
	@Test
	public void testDelete() {
		long seq = 16;
		boardMapper.delete(seq);
		log.info("#boardMapper testDelete() 성공");
	}
	
	
	
}