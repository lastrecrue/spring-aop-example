package org.achraf.example;

import org.aopalliance.aop.Advice;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect implements Advice {
	static Logger log = Logger.getLogger(MyAspect.class);

//	@Around("execution(* org.achraf.example.page.*.*(..))")
	public void beforeAdvice(ProceedingJoinPoint pjp) {
		String packageName = pjp.getSignature().getDeclaringTypeName();
		log.debug(packageName);
		log.debug("beforeAdvice");
	}
}
