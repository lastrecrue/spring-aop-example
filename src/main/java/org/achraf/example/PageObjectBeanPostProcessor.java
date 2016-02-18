package org.achraf.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.fluentlenium.core.Fluent;
import org.fluentlenium.core.FluentAdapter;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PageObjectBeanPostProcessor extends FluentAdapter implements BeanPostProcessor {

	@Autowired
	private WebDriver driver;
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(PageObject.class)) {
			
			bean = createPage(bean.getClass().asSubclass(FluentPage.class));
			reWiring(bean);
			// PageFactory.initElements(driver, bean);
			
//			PageInitializer pageInitializer = new PageInitializer(this);

		}
		return bean;
	}

	private void reWiring(Object bean) {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Autowired.class)) {
				field.setAccessible(true);
				try {
					Class<?> declaringClass = field.getType();
					Object component = applicationContext.getBean(declaringClass);
					field.set(bean, component);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
