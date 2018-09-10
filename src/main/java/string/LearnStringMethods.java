package string;

import org.testng.annotations.Test;

public class LearnStringMethods {
	
	String txt ="Focus on Interview";
	String txt1 = "More focus";
	int z =10;
	String x = "";
	
	int b = 10;
	
	int[]  a = {789,123,4};
	@Test
	public void sample() {	
		
		String[] split = txt.split(" ");
		System.out.println(split.length);
		for (String eachWord : split) {
			if(eachWord.startsWith("o")) {
				System.out.println(eachWord);
			}			
		}
		
		
		
		
		System.out.println(""+b);
		
		System.out.println(txt+z);
		System.out.println(txt.concat(txt1));
		
		
		int count = txt.length();
		System.out.println(count);
		
		System.out.println(a.length);
		
		
		
		char[] ch = txt.toCharArray();		
		for (char c : ch) {
			System.out.println(c);
		}
		
		
	}
	
	
	

}
