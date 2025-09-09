package com.kh.practice.array;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //바구니 수
		int m = sc.nextInt(); //반복 회수
		
		int[] basket = new int[n];
		
		for(int h=0; h<n; h++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			for(int idx=i; idx <= j; idx++) {
				basket[idx - 1] = k;
			}
		}
		
		for(int num : basket) {
			System.out.print(num + " ");
		}
		sc.close();
	}

}
