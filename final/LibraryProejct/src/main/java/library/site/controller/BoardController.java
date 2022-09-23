package library.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.Board;
import library.site.domain.BoardListResult;
import library.site.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/others")
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/Board")
	public ModelAndView list(HttpServletRequest request, HttpSession session, 
			String catgo, String keyword, String searchModeStr) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		int ps = 3;
		if (psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		if(catgo == null) {
			Object catgoObj = session.getAttribute("catgo");
			if(catgoObj != null) {
				catgo = (String)catgoObj;
			}
		}else {
			catgo = catgo.trim();
		}
		session.setAttribute("catgo", catgo);
		
		if(keyword == null) {
			Object keywordObj = session.getAttribute("keyword");
			if(keywordObj != null) {
				keyword = (String)keywordObj;
			}
		}else {
			keyword = keyword.trim();
		}
		session.setAttribute("keyword", keyword);
		
		if(searchModeStr == null) {
			Object searchModeStrObj = session.getAttribute("searchModeStr");
			if(searchModeStrObj != null) {
				searchModeStr = (String)searchModeStrObj;
			}else {
				searchModeStr = "F";
			}
		}else {
			searchModeStr = searchModeStr.trim();
		}
		session.setAttribute("searchModeStr", searchModeStr);
		
		boolean searchMode = false;
		if(searchModeStr.equalsIgnoreCase("T")) {
			searchMode = true;
		}
		BoardListResult listResult = null;
		if(!searchMode) {
			listResult = boardService.getBoardListResult(cp, ps);
		}else {
			listResult = boardService.getBoardListResult(cp, ps, catgo, keyword);
		}
		ModelAndView mv = new ModelAndView("others/Board","listResult",listResult);
		
		if(listResult.getList().size() == 0) {
			if(cp>1)
				return new ModelAndView("redirect:Board?cp="+(cp-1));
			else
				return new ModelAndView("others/Board","listResult", null);
		}else {
			return mv;
		}
	}
	@GetMapping("/Bcontent")
	public ModelAndView content(long seq) {
		Board board = boardService.getBoard(seq);
		ModelAndView mv = new ModelAndView("others/Bcontent", "board", board);
		
		return mv;
	}
	
}
