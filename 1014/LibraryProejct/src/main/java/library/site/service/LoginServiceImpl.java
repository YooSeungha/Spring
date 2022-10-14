package library.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.site.domain.Member;
import library.site.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public int signUp(Member member) {
		return loginMapper.signUp(member);
	}

	@Override
	public Member login(Member member) {
		return loginMapper.login(member);
	}

	@Override
	public Member mypage(long mem_num) {
		return loginMapper.mypage(mem_num);
	}

	@Override
	public int emailCheck(String mem_email) {
		return loginMapper.emailCheck(mem_email);
	}

	@Override
	public int phoneCheck(String mem_phone) {
		return loginMapper.phoneCheck(mem_phone);
	}

	@Override
	public int idCheck(String mem_id) {
		return loginMapper.idCheck(mem_id);
	}

	@Override
	public String phoneAccount(String mem_phone) {
		return loginMapper.phoneAccount(mem_phone);
	}

	@Override
	public String findPass(String mem_email) {
		return loginMapper.findPass(mem_email);
	}

	@Override
	public int NaverSignUp(Member member) {
		return loginMapper.NaverSignUp(member);
	}

	@Override
	public int deleteMember(Member member) {
		return loginMapper.deleteMember(member);
	}

	@Override
	public int passCheck(Member member) {
		return loginMapper.passCheck(member);
	}

	@Override
	public Member naverLogin(String mem_email) {
		return loginMapper.naverLogin(mem_email);
	}

	@Override
	public int passUpdate(Member member) {
		return loginMapper.passUpdate(member);
	}
	

}
