package org.achraf.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan
public class AppConfig {

	@Bean(destroyMethod = "quit")
	public WebDriver webDriver() {
		return new FirefoxDriver();
	}

}
