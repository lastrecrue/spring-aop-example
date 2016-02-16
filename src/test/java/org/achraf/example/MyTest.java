package org.achraf.example;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class MyTest {
	static Logger log = Logger.getLogger(MyAspect.class);

	@Autowired
	ApplicationContext context;

	@Autowired
	private MyService myService;

	private MyService myService2 = new MyService();

	@Test
	public void aspectTest() {
		log.debug("test with spring bean");
		myService.service();
	}

	@Test
	public void aspect2Test() {

		log.debug("test with programatique bean");
		AspectJProxyFactory factory = new AspectJProxyFactory(myService2);

		// add an aspect, the class must be an @AspectJ aspect
		// you can call this as many times as you need with different aspects
		factory.addAspect(MyAspect.class);
		myService2 = factory.getProxy();
		myService2.service();

	}

}
