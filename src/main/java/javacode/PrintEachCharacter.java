package javacode;

import java.util.Scanner;

public class PrintEachCharacter {

	public static void main(String[] args) {
		String name;
		//print each character in new line
		Scanner in = new Scanner(System.in);

		System.out.println("Enter your name : ");
		name = in.nextLine();
		char[]  allChar = name.toCharArray();
		for (char eachChar : allChar) {
			System.out.println(eachChar);
		}
	}
}
