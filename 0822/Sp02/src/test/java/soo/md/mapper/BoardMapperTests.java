package soo.md.mapper;

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
public class BoardMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	
	/*
	@Test
	public void testList(){
		log.info("#boardMapper: " + boardMapper);
		List<Board> list = boardMapper.list();
		log.info("#addressMapper list: " + list);
	}*/
	
	@Test
	public void testInsert(){
		Board board = new Board(-1L, "스프링2", "복잡하지2","Test","Test", null);
		boardMapper.insert(board);
		log.info("#addressMapper testInsert() 수행성공");
	}
//	@Test
//	public void testUpdate() {
//		
//		Board board = new Board();
//		board.setSeq(15);
//		board.setWriter("홍길동");
//		board.setEmail("hong@naver.com");
//		board.setSubject("Test");
//		board.setContent("Test");
//		board.setRdate(null);
//		boardMapper.update(board);
//		log.info("boardMapper testUpdate() 수행성공");
//	}
	/*
	@Test
	public void testDelete() {
		long seq = 16;
		boardMapper.delete(seq);
		log.info("#boardMapper testDelete() 수행성공");
	}*/
}
