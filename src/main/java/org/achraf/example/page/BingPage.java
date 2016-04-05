package org.achraf.example.page;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.AjaxElement;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class BingPage extends FluentPage {
	private static final String url = "http://www.bing.com";

	

	@FindBy(id = "sb_form_go")
	@AjaxElement(timeOutInSeconds = 10)
	private FluentWebElement submit;

	@FindBy(id = "sb_form_q")
	@AjaxElement(timeOutInSeconds = 10)
	private FluentWebElement form;

	public String getUrl() {
		return url;
	}
	@RobotKeywordOverload
	public void title_of_bing_should_contain_search_query_name() {
		go();
		getDriver().get(url);
		form.text("FluentLenium");
		submit.submit();
		assertThat(getDriver().getTitle()).contains("FluentLenium");
	}

}
