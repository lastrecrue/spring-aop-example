package org.achraf.example;

import org.apache.log4j.Logger;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class MyTest extends FluentTest {
	static Logger log = Logger.getLogger(MyAspect.class);

	@Autowired
	private BingPage bingPage;

	@Test
	public void title_of_bing_should_contain_search_query_name() {
		bingPage.title_of_bing_should_contain_search_query_name();
	}

}
