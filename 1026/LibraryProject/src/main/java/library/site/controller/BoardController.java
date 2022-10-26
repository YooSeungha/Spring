package library.site.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import antlr.debug.ParserListener;
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
			Map<String, Object> boardList = boardservice.selectPerPage(boardVo);
			
			List<Board> readL = (List<Board>)boardList.get("list");
			
			log.info("####### readL : " + readL);
			String keyword = request.getParameter("keyword");
			List<Board> readA = null;
	
			if(keyword != null) {
				String catgo = request.getParameter("catgo");
				boardVo.setCatgo(catgo);
				
				List<Board> listK = boardservice.search(boardVo); 
				readA = boardservice.catgoL(boardVo); 
				request.setAttribute("user", listK);				
				log.info("##listk: " + listK);
				HashMap<String,Object> map = new HashMap<String,Object>();
				List<String> mem_names = new ArrayList<String>(); 
				
				for(int i=0;i<listK.size();i++) {
					mem_names.add(boardservice.selectBySeq(listK.get(i).getMem_num()));
				}
				map.put("user", listK);
				map.put("mem_names", mem_names);
				
				request.setAttribute("map", map);
				int size = 0;
				int cp = boardVo.getCp();
				int ps = boardVo.getPs();
					if(readA.size()%ps != 0) {
						size = readA.size()/ps +1;
					}else {
						size = readA.size()/ps;
					}
				
				log.info("#boardVo"+ boardVo);
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
				request.setAttribute("cp", cp);
				request.setAttribute("ps", ps);
				log.info("cp: " + cp);
				
				
				
				return "others/board/contact";
			}else {
				long count = boardservice.count();
				request.setAttribute("count", count);
				readA = boardservice.readL();
				HashMap<String,Object> map = new HashMap<String,Object>();
				List<String> mem_names = new ArrayList<String>(); 
				
				for(int i=0;i<readL.size();i++) {
					mem_names.add(boardservice.selectBySeq(readL.get(i).getMem_num()));
				}
				map.put("user", readL);
				map.put("mem_names", mem_names);
				map.put("reviewCount", boardList.get("reviewCount"));
				
				request.setAttribute("map", map);
				int size = 0;
				int cp = boardVo.getCp();
				int ps = boardVo.getPs();
				if(readA.size()% ps != 0) {
					size = readA.size()/ps +1;
				}else {
					size = readA.size()/ps;
				}
				
				log.info("#boardVo"+ boardVo);
				
				log.info("#boardVo"+ boardVo);
				int end = (int)Math.ceil((double)cp/ (double)5)*5; 
				int start = end-4;			     
				if(size<end) { 
					end = size; 
				}			
				request.setAttribute("size", size);
				request.setAttribute("end", end);
				request.setAttribute("start", start);
				request.setAttribute("cp", cp);
				request.setAttribute("ps", ps);
				log.info("#readL"+map);
				log.info("cp: " + cp);
				log.info("ps: " + ps);
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
		public String selectS(HttpServletRequest request, String writer) {
			String b_num = request.getParameter("b_num");
			Long seqS = Long.parseLong(b_num);
			Board bo = boardservice.selectS(seqS);
			request.setAttribute("bo", bo);
			request.setAttribute("writer", writer);
			boardservice.readCount(seqS);
			return "others/board/update";
		}
		@PostMapping("/update.do")
		public String updateS(Board board) {
		boardservice.updateS(board);
		log.info("#!board"+board);
		return "redirect:read.do";
		}
		@GetMapping("updaterev")
		
		@PostMapping("/updaterev.do")
		public String ReviewUpdate(Review review) {
			reviewservice.ReviewUpdate(review);
			log.info("#11review" + review);
			return "redirect:view.do";
		}
		//뷰
		@GetMapping("/view.do")
		public String selectS2(HttpServletResponse response,HttpServletRequest request, long b_num, Review review) {
			String seq = request.getParameter("b_num");
			log.info("!!!!:" + seq);
			log.info(seq.getClass().getName());
			Long seqS = Long.parseLong(seq);
			log.info("#seq : " + seq);
			Board bo = boardservice.selectS(seqS);
			request.setAttribute("bo", bo);
			
			Cookie oldCookie = null;
			Cookie[] cookies = request.getCookies();
			log.info("cookies"+cookies);
			if (cookies != null) {
		        for (Cookie cookie : cookies) {
		            if (cookie.getName().equals("b_view")) {
		                oldCookie = cookie;
		            }
		        }
		    }
			if (oldCookie != null) {
		        if (!oldCookie.getValue().contains("[" + seqS.toString() + "]")) {
		        	boardservice.readCount(seqS);
		            oldCookie.setValue(oldCookie.getValue() + "_[" + seqS + "]");
		            oldCookie.setPath("/");
		            oldCookie.setMaxAge(60 * 60 * 24);
		            response.addCookie(oldCookie);
		        }
		    } else {
		    	boardservice.readCount(seqS);
		        Cookie newCookie = new Cookie("b_view","[" + seqS + "]");
		        newCookie.setPath("/");
		        newCookie.setMaxAge(60 * 60 * 24);
		        response.addCookie(newCookie);
		    }
			//request.setAttribute("writer", writer);
			//log.info("###reviewjpa : " + bo.getReviewjpa());
			//request.setAttribute("review", bo.getReviewjpa());
			boardservice.readCount(seqS);
			Board pre = boardservice.preBoard(seqS);
			request.setAttribute("pre", pre);			
			Board next = boardservice.nextBoard(seqS);			
			request.setAttribute("next", next);			
			//review단
			review.setSeq(Long.parseLong(seq));			
			List<Review> list = reviewservice.ReviewreadRow(review);			
			request.setAttribute("list", list);
			long longseq = Long.parseLong(seq);
			long count = reviewservice.CountReview(longseq);
			request.setAttribute("count", count);	
			return "others/board/view";
		}
		//댓글더보기
		
		@RequestMapping(value = "/add", produces = "application/text; charset=UTF-8")
		@ResponseBody
		public String add(@RequestBody String Data,Review review,HttpServletResponse response1) throws JsonProcessingException{
			
			JsonParser parser = new JsonParser();
		    JsonElement element = parser.parse(Data);
		    
		    JsonObject jsonObject = element.getAsJsonObject();
		    String start = jsonObject.get("startRow").getAsString();
		    String end = jsonObject.get("endRow").getAsString();
		    String seq = jsonObject.get("seq").getAsString();
		    
		    review.setStartRow(Long.parseLong(start));
		    review.setEndRow(Long.parseLong(end));
		    review.setSeq(Long.parseLong(seq));
		    
		    JSONObject response = new JSONObject();
		    
		    List<Review> list = reviewservice.ReviewreadRow(review);
		    long longseq = Long.parseLong(seq);
		    long count = reviewservice.CountReview(longseq);
		    response.put("review", list);
		    response.put("count", count);
		    log.info("#######count : "+ count);
		    
		    
		    log.info("***" + response.toString());
		    response1.setCharacterEncoding("UTF-8");
			return response.toString();
			
		}
		
		//비동기 댓글
		@PostMapping("/reupdate")
		@ResponseBody
		public String reupdate(@RequestBody String Data) throws JsonProcessingException{
			
			JsonParser parser = new JsonParser();
		    JsonElement element = parser.parse(Data);
		    JsonObject jsonObject = element.getAsJsonObject();
		    String seatnum = jsonObject.get("zzzz").getAsString();
		    
		    log.info("** : " + seatnum);
		      
			return "zzz";
		}
		//비동기 test
		@PostMapping("/recreate")
		@ResponseBody
		public String recreate(@RequestBody String Data) throws JsonProcessingException{
			
			JsonParser parser = new JsonParser();
		    JsonElement element = parser.parse(Data);
		    JsonObject jsonObject = element.getAsJsonObject();
		    String rec = jsonObject.get("review").getAsString();
		    
		    log.info("** : " + rec);
		      
			return "rev";
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
		   public String ReviewCreate(Review review, HttpServletRequest request) {		
		      reviewservice.ReviewCreate(review);
		      long seq = review.getSeq();
		      log.info("##review"+review);
		      return "redirect:view.do?b_num="+seq;
		   }
//	      String seqs = String.valueOf(seq);		
		//삭제
		@GetMapping("/del.do")
		public String deleteS(long b_num) {
			boardservice.deleteS(b_num);
			return "redirect:read.do";
		}	
		@GetMapping("/delete")
		public String ReviewDelete(long num, HttpServletRequest request, String writer) {
			Review review = reviewservice.selectReview(num);
			reviewservice.ReviewDelete(num);
			request.setAttribute("writer", writer);
			long seq = review.getSeq();
			log.info("@@:" + seq);
			return "redirect:view.do?b_num="+seq;
		}	
		
		
}
