package soo.md.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Board;
import soo.md.service.BoardService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	// @Autowired
	private BoardService boardService;
	
	@GetMapping("/list.do")
	public ModelAndView list(@RequestParam(value="ps", required=false, defaultValue="3") int ps,
	         @RequestParam(value="cp", required=false, defaultValue="1") int cp) {
		List<Board> list = boardService.listS();
		List<Board> list_cp = boardService.listS();
		int page_max = (int)Math.ceil(((list.size()+0.0)/ps));
		System.out.println("#"+list.size()+", "+ps+","+(list.size()/ps)+"="+page_max);
		for(int i = 1 ; i <= page_max ; i++) {
			if (i < page_max) {
				if (i == cp) {
					list_cp =  list.subList((i-1)*ps, i*ps);
				}
			}else if (i == page_max) {
				if (i == cp) {
					list_cp =  list.subList((i-1)*ps, list.size());
				}
			}
		}
		ModelAndView mv = new ModelAndView();	 
        mv.addObject("list", list);
        mv.addObject("list_cp", list_cp);
        mv.addObject("page_max", page_max);
        mv.addObject("ps", ps);
        mv.setViewName("board/list");
		return mv;	
	}
	
	@GetMapping("/content.do")
	public ModelAndView content(){
		List<Board> list = boardService.listS();
		ModelAndView mv = new ModelAndView("board/content", "list", list);
		return mv;	
	}
	
	@GetMapping("/write.do")
	public String write(){
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public String write(Board board){
		log.info("Address: " + board);
		boardService.insertS(board);
		return "redirect:list.do";
	}
	@RequestMapping("/del.do")
	public String delete(int seq){
		boardService.deleteS(seq);
		return "redirect:list.do";
	}
	
	@GetMapping("/update.do")
	public ModelAndView update(int seq){
		List<Board> list = boardService.listS();
		ModelAndView mv = new ModelAndView("board/update", "list", list);
		return mv;
	}
	
	@RequestMapping("/update.do")
	public String update(Board board){
		log.info("Board: " + board);
		boardService.updateS(board);
		return "redirect:list.do";
	}
}
