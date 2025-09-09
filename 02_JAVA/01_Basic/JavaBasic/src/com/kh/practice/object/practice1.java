package com.kh.practice.object;

import java.util.Scanner;

public class practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] check = new int[6];
		int[] correct = {1, 1, 2, 2, 2, 8};
		
		for(int i=0; i<6; i++) {
			check[i] = sc.nextInt();
		}
		
		for(int i=0; i<6; i++) {
			System.out.printf("%d ",correct[i]-check[i]);
		}
		
		sc.close();
	}

}
