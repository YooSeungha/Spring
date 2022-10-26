package library.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import library.site.domain.Member;
import library.site.service.LoginService;
import library.site.service.NaverSensV2Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
@RequestMapping("/")
public class LoginController {
	
	private LoginService loginService;

	// 로그인
	@PostMapping("login.do")
	public String login(HttpServletRequest request, HttpSession session, Member member, RedirectAttributes ratb) {
		Member memberCheck = loginService.login(member);
		
		log.info("##로그인 정보: "+memberCheck);
		if(memberCheck == null) {
			session.setAttribute("member", null);
			ratb.addFlashAttribute("loginFail", false);
		}else {
			session.setAttribute("member", memberCheck);
			ratb.addFlashAttribute("loginOk", true);
		}
		return "redirect:/";
	}
	
	// 회원가입
	@PostMapping("signup.do")
	public String signUp(Member member, RedirectAttributes ratb) {
		int i = loginService.signUp(member);
		log.info("## 회원가입 확인용 "+i);
		if(i == 1) {
			ratb.addFlashAttribute("singup", true);
		}
		return "redirect:/";
	}
	
	//이메일 중복 체크
	@ResponseBody
	@PostMapping("emailcheck.do")
	public int emailCheck(@RequestParam("mem_email") String mem_email) {
		int ec = loginService.emailCheck(mem_email);
		log.info("##이메일 중복: "+ec);
		return ec;
	}
	
	//핸드폰 중복 체크
	@ResponseBody
	@PostMapping("phonecheck.do")
	public int phoneCheck(@RequestParam("mem_phone") String mem_phone) {
		int pc = loginService.phoneCheck(mem_phone);
		log.info("##폰번호 중복: "+pc);
		return pc;
	}
	
	//아이디 중복 체크
	@ResponseBody
	@PostMapping("idcheck.do")
	public int idCheck(@RequestParam("mem_id") String mem_id) {
		int ic = loginService.idCheck(mem_id);
		log.info("##아이디 중복: "+ic);
		return ic;
	}
	
	// 로그아웃
	@GetMapping("logout.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//마이페이지
	@GetMapping("mypage.do")
	public ModelAndView moveMypage(long mem_num) {
		Member member = loginService.mypage(mem_num);
		ModelAndView mav = new ModelAndView("login/mypage", "member", member);
		return mav;
	}
	
	// 핸드폰 중복 체크(계정 찾기용)
	@ResponseBody
	@PostMapping("findphonecheck.do")
	public int findPhoneCheck(@RequestParam("mem_phone") String mem_phone) {
		int fpc = loginService.phoneCheck(mem_phone);
		log.info("##계정찾기 폰번호 중복: "+fpc);
		return fpc;
	}
	
	// 이메일 중복 체크(패스워드 찾기용)
	@ResponseBody
	@PostMapping("findpasswordcheck.do")
	public int findPasswordCheck(@RequestParam("mem_email") String mem_email) {
		int fec = loginService.emailCheck(mem_email);
		log.info("##패스워드 찾기 이메일 중복: "+fec);
		return fec;
	}
	
	
	// 회원 탈퇴 (홈페이지 전용)
	@PostMapping("deletenormal.do")
	public String deleteMemberNormal(Member member, HttpSession session) {
		int deleteResult = loginService.deleteMember(member);
		session.invalidate();
		log.info("##Normal계정 삭제 완료!!: "+deleteResult);
		
		return "redirect:/";
	}
	
	// 회원 탈퇴 시 해당이메일에 대한 비밀번호가 맞는지 확인용
	@ResponseBody
	@PostMapping("deletepasswordcheck")
	public int deletePasswordCheck(Member member) {
		int passCheck = loginService.passCheck(member);
		log.info("## 회원탈퇴시 패스워드 체크 1이면 맞음: "+passCheck);
		return passCheck;
	}
	
	// 회원 정보 수정
	@PostMapping("updatemember.do")
	public String updatePassword(Member member, RedirectAttributes ratb) {
		int result = loginService.passUpdate(member);
		log.info("## 회원 수정시 확인 여부: "+result);
		if(result == 1) {
			ratb.addFlashAttribute("updateOK", true);
		}else {
			ratb.addFlashAttribute("updateFAIL", false);
		}
		return "redirect:/";
	}
}
