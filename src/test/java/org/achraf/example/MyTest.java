package org.achraf.example;

import org.achraf.example.page.BingPage;
import org.apache.log4j.Logger;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class MyTest extends FluentTest {
	static Logger log = Logger.getLogger(MyAspect.class);

	@Autowired
	private WebDriver webDriver;

	@Override
	public WebDriver getDefaultDriver() {

		return webDriver;
	}

	@Override
	public WebDriver getDriver() {
		return webDriver;
	}

	@Autowired
	private BingPage bingPage;

	@Test
	public void title_of_bing_should_contain_search_query_name() {

		bingPage.title_of_bing_should_contain_search_query_name();
	}

}
