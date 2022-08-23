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
	}*/ //==>404¿¡·¯°¡ ³ª¿È
		
}