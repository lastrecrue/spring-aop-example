package org.achraf.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class BingPage extends FluentPage {
	@Autowired
	public BingPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void title_of_bing_should_contain_search_query_name() {

		goTo("http://www.bing.com");
		fill("#sb_form_q").with("FluentLenium");
		submit("#sb_form_go");
		assertThat(title()).contains("FluentLenium");
	}

}
