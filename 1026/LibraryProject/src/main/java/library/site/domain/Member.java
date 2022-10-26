package library.site.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="MEMBER")

public class Member {
	@Id @Column(name="MEM_NUM")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mem_num;		//회원 시퀀스
	@Column
	private String mem_email;		//회원 이메일
	@Column
	private String mem_pass;	// 회원 비밀번호
	@Column
	private String mem_phone;	// 회원 폰번호
	@Column
	private String mem_id;		// 회원 아이디
	@Column
	private String mem_name;	// 회원 이름
	@Column
	private String mem_grade;	// 회원 (관리자인지 구분방법)
	@Column
	private String mem_sns;		// 회원 ( 소셜 가입 구분 여부)
	@Column
	private Date mem_rdate;		// 회원 가입일
	@Column
	private Date mem_udate;		// 회원 수정일	

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="MEM_NUM")
	List<BookFavorite> bookFavorite = new ArrayList<BookFavorite>();
		
}
