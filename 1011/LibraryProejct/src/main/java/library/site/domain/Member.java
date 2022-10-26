package library.site.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mem_num;		//ȸ�� ������
	@Column
	private String mem_email;		//ȸ�� �̸���
	@Column
	private String mem_pass;	// ȸ�� ��й�ȣ
	@Column
	private String mem_phone;	// ȸ�� ����ȣ
	@Column
	private String mem_id;		// ȸ�� ���̵�
	@Column
	private String mem_name;	// ȸ�� �̸�
	@Column
	private String mem_grade;	// ȸ�� (���������� ���й��)
	@Column
	private String mem_sns;		// ȸ�� ( �Ҽ� ���� ���� ����)
	@Column
	private Date mem_rdate;		// ȸ�� ������
	@Column
	private Date mem_udate;		// ȸ�� ������
}
