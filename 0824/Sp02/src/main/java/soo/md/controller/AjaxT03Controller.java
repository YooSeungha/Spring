package soo.md.controller;

import java.io.*;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("ajax03")
public class AjaxT03Controller {
	private AddressAjaxService service;
	
	// 화면전환(새로고침)없이 이루어지는 동작 -> 비동기 통신으로 이루어짐
	/*
	 클라이언트에서 서버로 요청 메시지를 보낼 때, 본문에 데이터를 담아서 보내야 하고, 서버에서 클라이언트로
	 응답을 보낼때에도 본문에 데이터를 담아서 보내야 한다. 
	 본문 == body
	 **/
	@GetMapping("search01")
	public @ResponseBody Address search01(long seq) { 
		Address address = service.selectBySeqS(seq);
		log.info("#address: " + address); 
		return address;
	}
	@PostMapping("search02")
	public @ResponseBody List<Address> search02(String name) {
		List<Address> list = service.selectByNameS(name);
		log.info("#list: " + list);
		return list;
	}
	/*
	@GetMapping("txt")
	public String getText() {
		return "It_was_a_lot_of_work!!";
	}*/ //==>404에러가 나옴
		
}