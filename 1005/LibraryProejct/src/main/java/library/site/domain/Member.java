package library.site.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private long mem_num;		//ȸ�� ������
	private String mem_email;		//ȸ�� �̸���
	private String mem_pass;	// ȸ�� ��й�ȣ
	private String mem_phone;	// ȸ�� ����ȣ
	private String mem_id;		// ȸ�� ���̵�
	private String mem_name;	// ȸ�� �̸�
	private String mem_grade;	// ȸ�� (���������� ���й��)
	private String mem_sns;		// ȸ�� ( �Ҽ� ���� ���� ����)
	private Date mem_rdate;		// ȸ�� ������
	private Date mem_udate;		// ȸ�� ������
}
