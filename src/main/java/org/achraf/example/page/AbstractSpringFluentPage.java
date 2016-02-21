package org.achraf.example.page;

import java.lang.reflect.InvocationTargetException;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

/**
 * extends this class to auto-wire a fluent page 
 * @author achraf
 *
 */
public class AbstractSpringFluentPage extends FluentPage {
	public AbstractSpringFluentPage(WebDriver webDriver) {
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
}
