// File name: MyArray.java
// Author: Faizan Ahmed
// CSC 300 - Homework #2

import java.util.Random;

public class MyArray {

	public static void main(String[] args){
		
		//setting up 5 random integers
    	final int LEN = 5;
		int[] arr = new int[LEN];
		Random rgen = new Random();

		for (int i=0; i < LEN; i++){
			int randInt = rgen.nextInt(100);
			arr[i] = randInt;
		} 
		
		// calling methods
		printArray(arr);
		
		int max = findMax(arr);
		System.out.println("\nThe maximum is " + max + ".");
		
		int minIndex = findMinIndex(arr);
		System.out.println("The INDEX to the MINIMUM is " + minIndex + ".");
		
		revArray(arr);
		printArray(arr);
		
	}
		
	// methods
	public static void printArray(int[] ar){
		System.out.print("Random array: ");
		for (int i=0; i < ar.length; i++)
			System.out.print(ar[i] + " ");
	}
	
	public static int findMax(int[] ar){
		int max_2 = ar[0];
		for (int i=0; i < ar.length; i++){
			if (ar[i] > max_2)
				max_2 = ar[i];
		} return max_2;
	}

	public static int findMinIndex(int[] ar){
		int min = 0;
		for (int i=0; i < ar.length; i++){
			if (ar[min] > ar[i])
				min = i;
			if (ar[i] == min) //leftmost index
				break;
		} return min;
	}
	
	public static void revArray(int[] ar){
		for(int i=0, j = ar.length - 1; i < j; i++, j--){
			int swap = ar[i];
			ar[i] = ar[j];
			ar[j] = swap;
		}
	}
}
