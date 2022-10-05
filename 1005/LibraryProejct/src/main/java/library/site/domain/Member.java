package library.site.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private long mem_num;		//회원 시퀀스
	private String mem_email;		//회원 이메일
	private String mem_pass;	// 회원 비밀번호
	private String mem_phone;	// 회원 폰번호
	private String mem_id;		// 회원 아이디
	private String mem_name;	// 회원 이름
	private String mem_grade;	// 회원 (관리자인지 구분방법)
	private String mem_sns;		// 회원 ( 소셜 가입 구분 여부)
	private Date mem_rdate;		// 회원 가입일
	private Date mem_udate;		// 회원 수정일
}
