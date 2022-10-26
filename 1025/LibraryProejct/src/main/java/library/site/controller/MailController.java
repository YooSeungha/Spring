package library.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.site.service.LoginService;
import library.site.service.MailSendService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/")
public class MailController {
	
	@Autowired
	private MailSendService mailService;
	@Autowired
	private LoginService loginService;
	
	@GetMapping("mailCheck")
	@ResponseBody
	public String mailCheck(String mem_email) {
		log.info("##이메일 인증 체크"+mem_email);
		String authNumber = mailService.joinEmail(mem_email);
		String pass = loginService.findPass(mem_email);
		log.info("##이메일 인증 후 패스워드: "+pass);
		log.info("##이메일 인증 체크2: "+authNumber);

		return authNumber;
	}
	
	@PostMapping("passCheck.do")
	@ResponseBody
	public String passCheck(@RequestParam("mem_email") String mem_email, Model model) {
		String pass = loginService.findPass(mem_email);
		log.info("##이메일 인증 후 패스워드: "+pass);
		model.addAttribute("findpass", pass);
		return pass;
	}
}
