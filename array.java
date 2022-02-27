//Program For JAVA Array Demo

import java.util.Scanner;

public class array {
	public static void main (String []  args ){
	Scanner sc = new Scanner(System.in);
	int a[] = new int[20];
	int temp , element;
	String ch;
	
	System.out.println("Enter elements in the array :");
	for (int i =0 ; i<15; i++)
	a[i] = sc.nextInt();
	
	for(int i =0; i<15; i++){
	   for(int j=i+1; j<15; j++){
	      if(a[i] < a[j] ){
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
}
}
}	
	System.out.println("Elements in the array are :");
	for (int i =0 ; i<15; i++)
	System.out.print(a[i]+"   ");

	
	System.out.println("\n Enter the element to search :");
	element = sc.nextInt();

	for(int i =0; i<15; i++){
	if(element == a[i]){
	System.out.println(" Element found at  :" + (i+1));
	 break;
}}
	
}

}