package javacode;

public class FibonacciSeries {

	public static void main(String[] args) {

		int a = 0, b = 0, c = 1;
        System.out.print("Fibonacci Series:");
        for(int i = 1; a <100; i++)
        {
            a = b;
            b = c;
            c = a + b;         
            System.out.print(a+" ");
        }
	}
}
