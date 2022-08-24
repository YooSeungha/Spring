package soo.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/address")
public class AddressController {
	//@Autowired
	private AddressService addressService;//Spring 4.3~: AutoInjection ( with @AllArgsConstructor )  
	
	//@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@GetMapping("/list.do")
	public ModelAndView list(){
		List<Address> list = addressService.listS();
		
	    /*
		ModelAndView mv = new ModelAndView();
		mv.setViewName("address/list"); //V
		mv.addObject("list", list); //M
		*/
		ModelAndView mv = new ModelAndView("address/list", "list", list);
		return mv;
	}
	@GetMapping("/write.do")
	public String write() {
		return "address/write";
	}
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(String name, String addr){
		Address address = new Address(-1L, name, addr, null);
		addressService.insertS(address);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="/del", method=RequestMethod.GET)
	public String delete(long seq){
		addressService.deleteS(seq);
		return "redirect:list.do";
	}
}
