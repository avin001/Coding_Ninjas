package arrays;

import java.util.Scanner;

public class Pair2ArrayElementsForASum {
	
	public static int[] takeInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the size of the array you want to initialize and print: ");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		System.out.print("Please enter the elements of the array separated by space or return: ");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}
		return arr;
	}
	
	public static void pairArrayElementsForASum(int arr[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a number x to pair the array elements whose sum is x: ");
		int x = scanner.nextInt();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (x == arr[i] + arr[j]) {
						if (arr[i] < arr[j]) {
							System.out.println(arr[i] + " " + arr[j]);
						} else {
							System.out.println(arr[j] + " " + arr[i]);
						} 
					}
					if (j == arr.length - 1) {
						arr[i] = Integer.MIN_VALUE;
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		/*
		 Given a random integer array A and a number x. Find and print the pair of elements in the array which sum to x. 
		 Array A can contain duplicate elements. While printing a pair, print the smaller element first. 
		 That is, if a valid pair is (6, 5) print "5 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. 
		 You can print pairs in any order, just be careful about the order of elements in a pair.
		 
		 Input Format:
		 Line 1 : Integer N (Array size) 
		 Line 2 : Array elements (separated by space) 
		 Line 3 : Integer x
		 
		 Output Format:
		 Line 1 : Pair 1 elements (separated by space) 
		 Line 2 : Pair 2 elements (separated by space) 
		 Line 3 : and so on
		 
		 Constraints:
		 1 <= N <= 1000
		 1 <= x <= 100
		 
		 Sample Input:
		 9
		 1 3 6 2 5 4 3 2 4
		 7
		 
		 Sample Output:
		 1 6
		 3 4
		 3 4
		 2 5
		 2 5
		 3 4
		 3 4
		 
		 */
		
		int[] arr = takeInput();
		pairArrayElementsForASum(arr);
		
	}

}
