package org.achraf.example.library;

import org.achraf.example.keyword.MyKeyWord;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.library.AnnotationLibrary;

public class MyLibrary  extends AnnotationLibrary{
	
	@Autowired
	protected MyKeyWord myKeyWord;
	public MyLibrary() {
	    super("org/achraf/example/keyword/**/*.class");
	  }
}
