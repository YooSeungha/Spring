package soo.md.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import soo.md.domain.BoardListResult;
import soo.md.service.BoardService;

@Log4j
@RestController
@RequestMapping("rest_board")
public class BoardRestController { //CRUD 
	@Autowired
	private BoardService service;
	
	//(1) Create( insert )
	@PostMapping("create1")
	public void create(Board board) { //�Ķ���͸� jsObj�� ���� �� 
		log.info("#BoardRestController create1() board: " + board);
		service.write(board);
	}
	//@GetMapping("create1")�� ��� �׽���
	//http://127.0.0.1:8080/rest_board/create1?writer=��1&email=��1&subject=��1&content=��1
	//http://127.0.0.1:8080/rest_board/create1.json?writer=��1&email=��1&subject=��1&content=��1
	//http://127.0.0.1:8080/rest_board/create1.xml?writer=��1&email=��1&subject=��1&content=��1
	
	@PostMapping("create2")
	public void create2(@RequestBody Board board) { //�Ķ���͸� JSON���� �� 
		log.info("##BoardRestController create2() board: " + board);
		service.write(board);
	}
	//http://127.0.0.1:8080/rest_board/create2  �Ǵ� create2.json �Ǵ� create2.xml
	//{"seq":-1, "writer":"��2", "email":"��2" , "subject":"��2" , "content":"��2"}
	//{"writer":"��3", "email":"��3" , "subject":"��3" , "content":"��3"}
	
	
	//(2) Read( select )
	@GetMapping("read1")
	public List<Board> read(int cp, int ps){
		BoardListResult listResult = service.getBoardListResult(cp, ps);
		return listResult.getList();
	}
	//http://127.0.0.1:8080/rest_board/read1?cp=2&ps=3 
	//http://127.0.0.1:8080/rest_board/read1.xml?cp=2&ps=3 
	//http://127.0.0.1:8080/rest_board/read1.json?cp=2&ps=3
	
	@GetMapping("read2")
	public List<Board> read(int cp, int ps, String catgo, String keyword){
		BoardListResult listResult = service.getBoardListResult(cp, ps, catgo, keyword);
		return listResult.getList();
	}
	//http://127.0.0.1:8080/rest_board/read2?cp=2&ps=3&catgo=writer&keyword=�� 
	//http://127.0.0.1:8080/rest_board/read2.xml?cp=2&ps=3&catgo=writer&keyword=��
	//http://127.0.0.1:8080/rest_board/read2.json?cp=2&ps=3&catgo=writer&keyword=��
	
	@GetMapping("read/{seq}")
	public Board read(@PathVariable long seq) {
		Board board = service.getBoard(seq);
		return board;
	}
	//http://127.0.0.1:8080/rest_board/read/2
	//http://127.0.0.1:8080/rest_board/read/2.xml
	//http://127.0.0.1:8080/rest_board/read/2.json
	
	
	//(3) Update 
	@PutMapping("update/{seq}")
	public void update(@PathVariable long seq, @RequestBody Board board) {
		board.setSeq(seq);
		service.edit(board);
	}
	//http://127.0.0.1:8080/rest_board/update/3
	//{"email":"����2-��" , "subject":"����2-��" , "content":"����2-��"}
	
	
	//(3) Delete ( delete )
	@DeleteMapping("delete/{seq}")
	public void delete(@PathVariable long seq) {
		service.remove(seq);
	}
	//http://127.0.0.1:8080/rest_board/delete/4
	//http://127.0.0.1:8080/rest_board/delete/5.json
}


