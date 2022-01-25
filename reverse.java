import java.util.Scanner;

public class reverse {
	public static void main(String[] args)
{ 
String str, rev_str = "";

 Scanner sc = new Scanner(System.in);
 System.out.println("Enter any string ");

 str = sc.nextLine();
 int length = str.length();

for (int i = length-1 ; i>=0; i--)
	rev_str = rev_str + str.charAt(i);

 System.out.println("Reverse string : " + rev_str);

if(rev_str.equals(str))
System.out.println("Palindrome");
else
System.out.println("Not a palindrome.");

}

}