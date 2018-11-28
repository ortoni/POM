package javacode;

public class FibonacciSeries {

	public static void main(String[] args) {

		int a = 0, b = 0, c = 1;
        System.out.print("Fibonacci Series:");
        for(int i = 0; i<100; i++)
        {
            a = b;
            b = c;
            c = a + b;  
            if(a >= 35) {
            	break;
            }
            System.out.print(a+" ");
        }
	}
}
