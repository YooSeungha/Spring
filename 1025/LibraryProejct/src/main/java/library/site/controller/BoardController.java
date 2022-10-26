package library.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import library.site.domain.*;

import library.site.service.BoardService;
import library.site.service.ReviewService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/others")
public class BoardController {
		@Autowired
		private BoardService boardservice;
		
		@Autowired
		private ReviewService reviewservice;
		//읽기
		@RequestMapping("/read.do")
		public String readL(HttpServletRequest request,BoardVo boardVo) {
			List<Board> readL = boardservice.selectPerPage(boardVo);
			String keyword = request.getParameter("keyword");
			List<Board> readA = null;
	
			if(keyword != null) {
				String catgo = request.getParameter("catgo");
				boardVo.setCatgo(catgo);
				
				List<Board> listK = boardservice.search(boardVo); 
				readA = boardservice.catgoL(boardVo); 
				request.setAttribute("user", listK);				
				log.info("##listk: " + listK);
				int size = 0;
				if(readA.size()%5 != 0) {
					size = readA.size()/5 +1;
				}else {
					size = readA.size()/5;
				}
				
				log.info("#boardVo"+ boardVo);
				int cp = boardVo.getCp();
				int end = (int)Math.ceil((double)cp/ (double)5)*5; 
				int start = end-4;			     
				if(size<end) { 
					end = size; 
				}	
				request.setAttribute("size", size);
				request.setAttribute("end", end);
				request.setAttribute("start", start);
				request.setAttribute("keyword", keyword);
				request.setAttribute("catgo", catgo);
				
				log.info("cp: " + cp);
				
				
				
				return "others/board/contact";
			}else {
				readA = boardservice.readL();
				request.setAttribute("user", readL);
				int size = 0;
				if(readA.size()%5 != 0) {
					size = readA.size()/5 +1;
				}else {
					size = readA.size()/5;
				}
				
				log.info("#boardVo"+ boardVo);
				int cp = boardVo.getCp();
				int end = (int)Math.ceil((double)cp/ (double)5)*5; 
				int start = end-4;			     
				if(size<end) { 
					end = size; 
				}	
				request.setAttribute("size", size);
				request.setAttribute("end", end);
				request.setAttribute("start", start);
				
				log.info("cp: " + cp);
				
				
				
				return "others/board/contact";
			}
			
		}
		
	

		//쓰기
		@PostMapping("/write.do") 
		public String writeL(Board board) { 
		log.info(board);
		boardservice.writeL(board);
		return "redirect:read.do";
	}
		//업데이트
		@GetMapping("/update")
		public String selectS(HttpServletRequest request) {
			String seq = request.getParameter("seq");
			Long seqS = Long.parseLong(seq);
			Board bo = boardservice.selectS(seqS);
			request.setAttribute("bo", bo);
			boardservice.readCount(seqS);
			return "others/board/update";
		}
		@PostMapping("/update.do")
		public String updateS(Board board) {
		boardservice.updateS(board);
		log.info("#!board"+board);
		return "redirect:read.do";
	}
		
		//뷰
		@GetMapping("/view.do")
		public String selectS2(HttpServletRequest request, Review review ) {
			String seq = request.getParameter("b_num");
			Long seqS = Long.parseLong(seq);
			log.info("#seq : " + seq);
			Board bo = boardservice.selectS(seqS);
			request.setAttribute("bo", bo);
			boardservice.readCount(seqS);
			//review단
			List<Review> list = reviewservice.Reviewread(seqS);
			request.setAttribute("list", list);
			return "others/board/view";
		}
		//댓글쓰기
//		@PostMapping("/create.do")
//		public String ReviewCreate(HttpServletRequest request) {
//			Review review = new Review();
//			String content = request.getParameter("content");
//			String writer = request.getParameter("writer");
//			long seq = Long.parseLong(request.getParameter("seq"));
//			review.setContent(content);
//			review.setWriter(writer);
//			review.setSeq(seq);
//			reviewservice.ReviewCreate(review);
//			log.info("#지: "+review);
//			return "redirect:view.do?seq="+seq;
//		}
		@PostMapping("/create.do")
		   public String ReviewCreate(Review review) {
		      reviewservice.ReviewCreate(review);
		      long seq = review.getSeq();
		      log.info("##review"+review);
		      return "redirect:view.do?seq="+seq;
		   }
		
		//삭제
		@GetMapping("/del.do")
		public String deleteS(long seq) {
			boardservice.deleteS(seq);
			return "redirect:read.do";
		}	
		
		
}
