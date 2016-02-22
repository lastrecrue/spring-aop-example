package org.achraf.example;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.adapter.util.SharedDriver;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@SharedDriver
public abstract class AbstractTest extends FluentTest {
	@Autowired
	private WebDriver webDriver;

	/**
	 * avoid instantiation of default driver
	 */
	@Override
	public WebDriver getDefaultDriver() {
		return webDriver;
	}

	/**
	 * avoid instantiation of default driver
	 */
	@Override
	public WebDriver getDriver() {
		return webDriver;
	}

}
