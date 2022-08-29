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
	public void create(Board board) { 
		log.info("#BoardRestController create1() board: " + board);
		service.write(board);
	}
	
	@PostMapping("create2")
	public void create2(@RequestBody Board board) { 
		log.info("#BoardRestController create2() board: " + board);
		service.write(board);
	}

	
	//(2) Read( select )
	@GetMapping("read1")
	public List<Board> read(int cp, int ps){
		BoardListResult listResult = service.getBoardListResult(cp, ps);
		return listResult.getList();
	}

	
	@GetMapping("read2")
	public List<Board> read(int cp, int ps, String catgo, String keyword){
		BoardListResult listResult = service.getBoardListResult(cp, ps, catgo, keyword);
		return listResult.getList();
	}

	
	@GetMapping("read/{seq}")
	public Board read(@PathVariable long seq) {
		Board board = service.getBoard(seq);
		return board;
	}

	
	//(3) Update 
	@PutMapping("update/{seq}")
	public void update(@PathVariable long seq, @RequestBody Board board) {
		board.setSeq(seq);
		service.edit(board);
	}

	
	//(3) Delete ( delete )
	@DeleteMapping("delete/{seq}")
	public void delete(@PathVariable long seq) {
		service.remove(seq);
	}

}


