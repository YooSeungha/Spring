package library.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.site.service.LoginService;
import library.site.service.NaverSensV2Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/")
public class NaverPhoneController {
	
	private NaverSensV2Service naverSensV2Service;
	@Autowired
	private LoginService loginService;
	
	
	// 회원가입 시 핸드폰 인증
	@ResponseBody
	@PostMapping("naverphone.do")
	public String phoneCheck(@RequestParam("tel") String tel) {
		String result = naverSensV2Service.send_msg(tel);
		log.info("##네이버핸드폰 인증 컨트롤러 번호값: "+result);

		return result;
	}
	
	
	// 계정 찾기 시 핸드폰 인증
	@ResponseBody
	@PostMapping("findphone.do")
	public String findPhone(@RequestParam("tel") String tel) {
		String result = naverSensV2Service.send_msg(tel);
		log.info("##계정 찾기 핸드폰 인증 컨트롤러 번호값: "+result);
		
		return result;
	}
	
	// 계정 찾기 시 이메일 찾는 것
	@ResponseBody
	@PostMapping("findemails.do")
	public String checkPhone(@RequestParam("mem_phone") String mem_phone, Model model) {
		String mem_email = loginService.phoneAccount(mem_phone);
		log.info("##계정 찾기(핸드폰) 이메일은: "+mem_email);
		model.addAttribute("findemail", mem_email);
		return mem_email;
	}
}

