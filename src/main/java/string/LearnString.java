package string;

public class LearnString {

	public static void main(String[] args) {
		//	stringAddress();
			stringBasics();
		//  stringBufferAddress();
		//  checkLiteral();
	}

	public static void stringAddress(){

		/*String a = "Karim";		
		System.out.println("Memory address of a: "+ System.identityHashCode(a));
		a = a+" M";

		System.out.println("Memory address of a: "+ System.identityHashCode(a));
		 */
		String a = "Testleaf";
		String b = "Testleaf1";
		System.out.println("Memory address of a: "+ System.identityHashCode(a));
		System.out.println("Memory address of b: "+ System.identityHashCode(b));
		System.out.println(a==b);
		System.out.println(a.equals(b));

		String a1 = new String("Testleaf");
		String b1 = new String("Testleaf");
		System.out.println("Memory address of a1: "+ System.identityHashCode(a1));
		System.out.println("Memory address of b1: "+ System.identityHashCode(b1));
		System.out.println(a1==b1);
		//System.out.println(a1.equals(b1));

	}

	public static void stringBufferAddress(){

		String a = "Testleaf"; // literal
		String comp = new String("TestLeaf"); // object of class

		String a1 = "Testleaf";
		// Hashcode -> Memory address
		System.out.println("Memory address of a: "+ System.identityHashCode(a));

		System.out.println("Memory address of comp: "+ System.identityHashCode(comp));
		System.out.println("Memory address of a1: "+ System.identityHashCode(a1));
		//a = a.concat(" Company");
		//	System.out.println("Memory address of a: "+ System.identityHashCode(a));


		//	StringBuffer b = new StringBuffer("Testleaf");
		//	System.out.println("Memory address of b: "+ System.identityHashCode(b));

		//	b.append(" Company");
		//	System.out.println("Memory address of b: "+ System.identityHashCode(b));


	}

	public static void checkLiteral(){

		String a = "TestLeaf"; 
		String b = "TestLeaf";
		System.out.println(a == b);  // true

		String c = new String("TestLeaf");
		String d = new String("TestLeaf");
		System.out.println(c == d);  // false
	}


	public static void stringBasics(){
		/**
		 * String class to create and manipulate strings.
		 * 
		 * Methods
		 * 0) toCharArray() // convert string to character
		 * 1) length // find the number of characters
		 * 2) charAt(index) // The character at the index
		 * 3) concat //Concatenate two strings only  2+"Std"
		 * 4) toString() // Convert an existing data type to String
		 * 5) subString(beginIndex, endIndex) //Extracts a particular portion of String
		 * 6) trim // Removes the white space on begining and End
		 * 7) toLowerCase, toUpperCase // to convert case
		 * 8) split('char') -- split(regex, limit) //
		 * 9) indexOf(chr) , lastIndexOf(chr) // the index of the first or last match
		 * 10)startsWith(s), endsWith(s), contains(s) // match
		 * 11)replace(oldChar, newChar), replaceAll(regex, replacement) // 
		 * 12)Immutable String, StringBuffer(ThreadSafe), StringBuilder(Not ThreadSafe) 
		 */

		//String tryString = new Strin

		// Simplest way to create String
		String text = " Hexaware "; //As literals
		System.out.println(text.length());

		char[] textOfChar = text.toCharArray();
		System.out.println(" using toCharArray : "+textOfChar.length);


		// Another way to create String
		char[] another = {'t','e','s','t','l','e','a','f'};
		String newText = new String(another);//Creating object

		// The String class has thirteen constructors that allow you to provide the 
		// initial value of the string using different sources

		// Length
		System.out.println("The length of the string is :"+text.length());

		// get the last character
		System.out.println("The last character is :"+text.charAt(text.length()-1));

		// concat
		System.out.println("The concatenation can be :"+text.concat("Chennai"));

		// Another way is using + to concatenate

		// convert to String -- applies to Integer, Double, Float, Boolean
		Integer value = 10;

		System.out.println(value.toString()); 
		Integer.parseInt("10");
		Double.parseDouble("10.00");
		System.out.println(Integer.toBinaryString(555));

		// SubString
		System.out.println("The first 4 character of Hexaware is : "+text.substring(0,4));

		// trim - removes white space
		System.out.println("Without white spaces on both end :"+text.trim());

		// to lowercase
		System.out.println("The text in lowercase is : "+text.toLowerCase());

		// split the string my delimiter
		String[] data = text.split("");
		System.out.println("The array size is : "+data.length);
		System.out.println("The second character is : "+data[1]);

		String x ="testleaf";
		x= x+"Karim";



		// find the index of 'a'
		System.out.println("The first occurance of index 'a' in ' Hexaware ' is : "+text.indexOf("a"));

		// find the last index of 'a'
		System.out.println("The last occurance of index 'a' in ' Hexaware ' is : "+text.lastIndexOf("a"));


		// Confirm if the text has character 'w'
		System.out.println("Does the string has character 'w' : "+text.contains("w"));

		// Replace all (white spaces with nothing)
		System.out.println("The white spaces removed text is :"+text.replaceAll(" ", ""));

		// Check the memory address
		System.out.println("The present memory address of String is : "+Integer.toHexString(newText.hashCode()));

		// Change the text value
		newText = "TestLeaf 2.0";
		System.out.println("The changed memory address of String is : "+Integer.toHexString(newText.hashCode()));

		StringBuffer str = new StringBuffer("TestLeaf"); 
		System.out.println("The present memory address of StringBuffer is : "+Integer.toHexString(str.hashCode()));

		str.insert(0, "New ");
		System.out.println(str);
		System.out.println("The changed memory address of StringBuffer is : "+Integer.toHexString(str.hashCode()));
	}	
}
