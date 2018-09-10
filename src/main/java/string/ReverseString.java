package string;

import org.testng.annotations.Test;

public class ReverseString {
	
	String txt = "I'm the Winner";	
	//Way1
	//@Test
	public void reverseString() {
		char[] ch = txt.toCharArray();
		for (int i = ch.length-1; i >= 0; i--) {
			System.out.print(ch[i]);			
		}		
	}	
	//Way2
	@Test
	public void way2() {
		for (int i = txt.length()-1; i >=0 ; i--) {
			System.out.print(txt.charAt(i));
		}
	}
	

}
