package library.site.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class MailSendService {
	
	@Autowired
	private JavaMailSenderImpl mailSender;	//스프링 프레임 워크에 있음
	private int authNumber;
	
	public void makeRandomNumber() {
		// 6자리 난수 
		Random r = new Random();
		int checkNum = r.nextInt(888888)+111111;
		log.info("##메일인증 난수생성: "+checkNum);
		authNumber = checkNum;		
	}
	
	//이메일 보낼 양식
	public String joinEmail(String mem_email) {
		makeRandomNumber();
		String setFrom = ".com";
		String toMail = mem_email;
		String title = "[도서관사조]의 비밀번호 찾기 인증메일입니다"; //이메일 제목
		String content = "홈페이지를 방문해주셔서 감사합니다."+
					"<br/><br/>"+"인증번호는 ["+ authNumber +"] 입니다."+
				"<br/>"+
					"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNumber);
	}
	
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
			
		}catch(MessagingException me) {
			log.info("##메일 전송 오류401: "+me);
		}
	}
}
