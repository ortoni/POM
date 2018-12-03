package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class ListenersUtils implements IAnnotationTransformer, IRetryAnalyzer{

	@Override
	public void transform(ITestAnnotation annotation,
			Class testClass, Constructor testConstructor, 
			Method testMethod) {
		testMethod.getName().equals("createLead");
//		annotation.setEnabled(true);
		int count = annotation.getInvocationCount();
		System.out.println(count);
		annotation.setRetryAnalyzer(this.getClass());
		//annotation.setInvocationCount(2);
	}
    int maxTry= 1;
	@Override
	public boolean retry(ITestResult result) {
		if (maxTry<2) {
			maxTry++;
			return true;
		}
		return false;
	}

	
}
