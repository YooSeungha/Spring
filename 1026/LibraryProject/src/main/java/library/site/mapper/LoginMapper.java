package library.site.mapper;

import library.site.domain.Member;

public interface LoginMapper {
	int signUp(Member member);		// 회원가입
	Member login(Member member);	// 로그인
	Member mypage(long mem_num);	// 마이페이지
	int emailCheck(String mem_email);	// 이메일 중복체크
	int phoneCheck(String mem_phone);	//폰 중복체크
	int idCheck(String mem_id);		//아이디 중복체크
	String phoneAccount(String mem_phone);	//계정찾기(아이디)
	String findPass(String mem_email);	//계정찾기(패스워드)
	
	int NaverSignUp(Member member);	//네이버 회원가입(전용)
	int deleteMember(Member member);	// 회원 탈퇴
	int deleteNaverMember(String mem_email);	//네이버 회원탈퇴
	int passCheck(Member member);	// 회원 탈퇴시 패스워드 체크
	Member naverLogin(String mem_email);	// 네이버 로그인시 자기의 초기패스워드 말고 회원가입때 가져온 패스워드 값 가져오기
	int passUpdate(Member member);	// 회원 정보 수정
}
