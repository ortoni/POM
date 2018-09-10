package javacode;

public class FindOccurences {

	public static void main(String[] args) {
	String check = "I am the winner";
	
		int occuranceOfN = 0;
		char[] charArray = check.toCharArray();
	
		for (char c : charArray) {
		
			if(c=='a'){
				occuranceOfN ++;
			}
		}		
		System.out.println(occuranceOfN);
	}

}
