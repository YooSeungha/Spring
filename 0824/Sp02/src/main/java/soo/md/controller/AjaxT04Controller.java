package soo.md.controller;


import java.io.*;
import java.util.List;

import javax.print.attribute.standard.MediaName;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Log4j
@AllArgsConstructor
@RestController
/**
 리턴값에 자동으로 @ResponseBody가 붙게되어 별도 어노테이션을 명시해주지 않아도
 HTTP 응답데이터(body)에 자바 객체가 매핑되어 전달
 @RestController는 단순히 객체만을 반환하고 객체 데이터는 JSON 또는 XML 형식으로 HTTP 응답에 담아서 전송
 */
@RequestMapping("ajax04")
public class AjaxT04Controller {
	private AddressAjaxService service;
	
	@GetMapping(value="search01", produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Address search01(long seq) {
		Address address = service.selectBySeqS(seq);
		return address;
	}
	@PostMapping(value="search02", produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Address> search02(String name) {
		List<Address> list = service.selectByNameS(name);
		return list;
	}
	/*
	@GetMapping("txt")
	public String getText() {
		return "It_was_a_lot_of_work!!";
	}
	*/ // ==> RestController는 일반 jsp문서를 참조하지 않음
}