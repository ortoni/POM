package javacode;

public class SumOfOddNumbers {
	public static void main(String[] args) {
		int odd = 12345;
		int sum= 0;
		while(odd >0) {
			int mod = odd % 10;
			sum+=mod;
			/*if(mod %2 != 0) {
				sum+=mod;
			}*/
			odd/=10;
		}
		System.out.println(sum);
	}

}
