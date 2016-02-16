package org.achraf.example;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MyService {
	static Logger log = Logger.getLogger(MyService.class);

	public void service() {
		log.debug("service");
	}
}
