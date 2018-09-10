package javacode;

import java.util.Scanner;

import org.junit.Test;

public class RemoveDigitFormNum {
	@Test
	public void Smple() {
		
		Scanner in=new Scanner(System.in);
		System.out.println("Give number :");
		Integer a=in.nextInt();
		System.out.println("Give Digit :");
		Integer b=in.nextInt();
		
		
		while (Integer.toString(a).contains(Integer.toString(b)))
		{
			a--;
			
		}
		System.out.println(a);
				
			}
			
			}


