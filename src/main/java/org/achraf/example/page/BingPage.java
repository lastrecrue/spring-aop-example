package org.achraf.example.page;

import static org.assertj.core.api.Assertions.assertThat;

import org.achraf.example.PageObject;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.AjaxElement;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@PageObject
public class BingPage extends FluentPage {

	@Autowired
	private WebDriver webDriver;

	@FindBy(id = "sb_form_go")
	@AjaxElement(timeOutInSeconds = 10)
	private FluentWebElement submit;

	@FindBy(id = "sb_form_q")
	@AjaxElement(timeOutInSeconds = 10)
	private FluentWebElement form;

	public void title_of_bing_should_contain_search_query_name() {
		webDriver.get("http://www.bing.com");
		form.text("FluentLenium");
		submit.submit();
		assertThat(webDriver.getTitle()).contains("FluentLenium");
	}

}
