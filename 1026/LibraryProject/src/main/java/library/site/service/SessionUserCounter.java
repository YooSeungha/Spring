package library.site.service;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@WebListener
@Service
public class SessionUserCounter implements HttpSessionListener {
	@Autowired
	private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

	public synchronized static String memberSessionCheck(String type, String mem_email) {
		String result = "";
		log.info("@@ type: "+type+", mem_email: "+mem_email);
		log.info("@@ 로그인 스레드 sessions: "+sessions);
		for(String key : sessions.keySet()) {
			HttpSession value = sessions.get(key);
			log.info("@@ 로그인 스레드 value: "+value);
			log.info("@@ 로그인 스레드 value(type): "+value.getAttribute(type));
			log.info("@@ 로그인 스레드 key: "+key.toString());
			if(value != null && value.getAttribute("mem_email") != null && value.getAttribute("mem_email").toString().equals(mem_email)) {
				result = key.toString();
				log.info("@@ 로그인 if result: "+result);
			}
			
		}
		//removeMemberSession(result);
		return result;
	}
	
	private static void removeMemberSession(String id) {
		log.info("@@ 로그인 remove id: "+id);
		if(id != null && id.length() > 0) {
			sessions.get(id).invalidate();
			sessions.remove(id);
			log.info("@@ 로그인 remove sessions: "+sessions);
		}
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		log.info("@@ 로그인 세션 생성 1. "+se);
		sessions.put(se.getSession().getId(), se.getSession());
		log.info("@@ 로그인 세션 생성 2. "+sessions);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if(sessions.get(se.getSession().getId()) != null) {
			log.info("@@ 로그인 세션 삭제 1. "+se);
			sessions.get(se.getSession().getId()).invalidate();
			sessions.remove(se.getSession().getId());
			log.info("@@ 로그인 세션 삭제 2. "+sessions);
		}
		log.info("@@ 로그인 세션 삭제 3. "+se);
		log.info("@@ 로그인 세션 삭제 4. "+sessions);
	}

}
