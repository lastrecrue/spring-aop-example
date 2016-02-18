package org.achraf.example.page;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.AjaxElement;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BingPage extends FluentPage {

	@FindBy(id = "sb_form_go")
	@AjaxElement(timeOutInSeconds = 10)
	private FluentWebElement submit;

	@FindBy(id = "sb_form_q")
	@AjaxElement(timeOutInSeconds = 10)
	private FluentWebElement form;

	@Autowired
	public BingPage(WebDriver webDriver) {
		super(webDriver);
		createPage(this.getClass());
	}

	/**
	 * to delegat instantiation to spring only
	 */
	@SuppressWarnings("unchecked")
	protected <T extends FluentPage> T constructPageWithParams(Class<T> cls,
			Object[] params) throws NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		return (T) this;
	}

	public void title_of_bing_should_contain_search_query_name() {

		getDriver().get("http://www.bing.com");
		form.text("FluentLenium");
		submit.submit();
		assertThat(getDriver().getTitle()).contains("FluentLenium");
	}

}
