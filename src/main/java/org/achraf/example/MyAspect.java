package org.achraf.example;

import org.aopalliance.aop.Advice;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect implements Advice {
	static Logger log = Logger.getLogger(MyAspect.class);

	@Before("execution(* org.achraf.example.page.*.*(..))")
	public void beforeAdvice() {
		log.debug("beforeAdvice");
	}
}
