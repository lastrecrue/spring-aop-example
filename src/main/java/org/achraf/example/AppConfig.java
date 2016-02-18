package org.achraf.example;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan
public class AppConfig {

	@Bean
	public WebDriver webDriver() {

		File file = new File("C:/Dev/svn/SIGV/trunk/sigv/sigv-test-auto/selenium_standalone/windows/internetexplorer/64bit/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		return new InternetExplorerDriver();
	}

}
