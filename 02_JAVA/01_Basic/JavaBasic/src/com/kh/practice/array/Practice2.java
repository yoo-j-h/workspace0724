package com.kh.practice.array;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		int[] iArr = new int[n];
		
		for(int i=0; i<n; i++) {
			iArr[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;//int로 표현할수있는 수 중에 가장 큰수
		int max = Integer.MIN_VALUE;//int로 표현할 수 있는 수 중에 가장 작은 수
		
		for(int num : iArr) {
			if(num < min) min = num;
			if(num > max) max = num;
		}
		System.out.print(min + " " + max);
		sc.close();
	}
	
}
