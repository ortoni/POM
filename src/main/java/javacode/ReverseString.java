package javacode;

public class ReverseString {

	public static void main(String[] args) {

		String st = "Am a hero";
		System.out.println(new StringBuffer(st).reverse().toString().replaceAll(" ", ""));


	}

}
