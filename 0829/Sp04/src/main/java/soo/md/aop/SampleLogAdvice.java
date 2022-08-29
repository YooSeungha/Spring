package soo.md.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Aspect
@Component
public class SampleLogAdvice {
	@Before("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logBefore() {
		log.info("#(3) logBefore() ����");
		}
	@Around("execution(* soo.md.service.SampleLogService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		log.info("#(1) target class: " + pjp.getTarget().getClass());
		log.info("#(2) args: " + Arrays.deepToString(pjp.getArgs()));
		Object result = null;
		try {
			result = pjp.proceed(); // ����Ͻ� �޼ҵ�� �����ϵ��� �ϴ� �޼ҵ�
		}catch(Throwable t){
			log.info("# ���� �߻� t :"+ t);
		}
		long end = System.currentTimeMillis();
		log.info("#(4) ����ð� :" + (end-start)); 
		return result;
	}
	@After("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logAfter() { 
		log.info("#(5) logAfter() ���� ");
	}
	@AfterThrowing(pointcut = "execution(* soo.md.service.SampleLogService*.*(..))", throwing = "e")
	public void logAfterThrowing(Exception e) {
		log.info("#(6) logAfterThrowing() ����"+ e); 
	}
}
