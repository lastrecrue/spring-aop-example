package org.achraf.example;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class AppConfig {

	@Bean
	public TestScope testScope() {
		return new TestScope();
	}

	@Bean
	public CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer scopeConfigurer = new CustomScopeConfigurer();
		Map<String, Object> scopes = new HashMap<>();
		scopes.put("test", testScope());
		scopeConfigurer.setScopes(scopes);
		return scopeConfigurer;
	}

	@Bean
	@Scope("test")
	public WebDriver webDriver() {
		return new FirefoxDriver();
	}

}
