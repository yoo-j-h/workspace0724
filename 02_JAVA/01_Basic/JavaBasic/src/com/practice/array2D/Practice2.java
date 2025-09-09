package com.practice.array2D;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[][] = new int[n][m];
		
		int max = arr[0][0];
		int x = 0;
		int y = 0;
		
		for(int i=0 ; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0 ; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] >max) {
					max = arr[i][j];
					x=i+1;
					y=j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(x+" "+y);
		sc.close();
		/*
		for(int i=0 ; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == max) {
					System.out.printf("%d %d",i+1,j+1);
					return;
				}
			}
		}*/
			
	}
	

}
