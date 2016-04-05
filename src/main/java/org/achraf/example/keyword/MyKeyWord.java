package org.achraf.example.keyword;

import org.achraf.example.page.BingPage;
import org.fluentlenium.core.annotation.Page;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class MyKeyWord {
	@Page
	private BingPage bingPage;

	@RobotKeywordOverload
	public void doSearch(String strategyName, String functionDefinition) {
		bingPage.title_of_bing_should_contain_search_query_name();
	}
}
