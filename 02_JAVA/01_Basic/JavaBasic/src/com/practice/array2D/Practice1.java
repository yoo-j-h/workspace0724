package com.practice.array2D;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr1 = new int[n][m];
		int[][] arr2 = new int[n][m];
		
		for(int j=0; j<arr1.length; j++) {
			for(int i=0; i<arr1[j].length; i++ ) {
				arr1[j][i] = sc.nextInt();
			}
		}
		for(int j=0; j<arr2.length; j++) {
			for(int i=0; i<arr2[j].length; i++ ) {
				arr2[j][i] = sc.nextInt();
			}
		}
		
		for(int j=0; j<n; j++) {
			for(int i=0; i<m; i++ ) {
				System.out.print(arr1[j][i]+arr2[j][i]+" ");
			}
			System.out.println();
		}
		sc.close();
	}

}
