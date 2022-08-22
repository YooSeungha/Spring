package soo.md.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import soo.md.domain.Address;
import soo.md.domain.Board;
import soo.md.service.BoardService;


@AllArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/list.do")
	public ModelAndView list(){
		List<Board> list = boardService.listS();
		
		ModelAndView mv = new ModelAndView("board/list", "list", list);
		return mv;
	}
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(String writer, String email, String content, String subject){
		Board board = new Board(-1L, writer, email, content, subject, null);
		boardService.insertS(board);
		return "redirect:list.do";
	}
	@GetMapping("/content.do")
	public ModelAndView content(long seq) {
		Board content = boardService.contentS(seq);
		ModelAndView mv = new ModelAndView("board/content", "board", content);
		return mv;
	}
	@GetMapping("/update.do")
	public ModelAndView update(long seq) {
		Board content = boardService.contentS(seq);
		ModelAndView mv = new ModelAndView("board/update", "board", content);
		return mv;
	}
	@PostMapping("/update.do")
	public String update(Board board) {
		boardService.updateS(board);
		return "redirect:list.do";
	}
	@RequestMapping(value="/del.do", method=RequestMethod.GET)
	public String delete(long seq){
		boardService.deleteS(seq);
		return "redirect:list.do";
	}
	
}
