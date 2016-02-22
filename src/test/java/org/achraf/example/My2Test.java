package org.achraf.example;

import org.achraf.example.page.BingPage;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class My2Test extends AbstractTest {
	static Logger log = Logger.getLogger(My2Test.class);

	@Autowired
	private BingPage bingPage;

	@Test
	public void title_of_bing_should_contain_search_query_name() {
		bingPage.title_of_bing_should_contain_search_query_name();
	}

}
