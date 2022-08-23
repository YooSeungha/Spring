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