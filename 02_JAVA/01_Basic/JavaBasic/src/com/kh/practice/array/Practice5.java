package com.kh.practice.array;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int m =sc.nextInt();
		
		int[] basket = new int[n];
		int[] tmp = null;
		for(int i=0; i<basket.length; i++) {
			basket[i] = i+1;
		}
		for(int k=0; k<m; k++) {
			int i = sc.nextInt()-1; //-1은 인덱스로 변환
			int j = sc.nextInt()-1;
			tmp = new int[j-i+1];
			for(int h=i; h<=j; h++) {
				tmp[h-i] = basket[j]; 
			}
		}
		for(int i=tmp.length-1; i>=0; i--) {
			System.out.print(tmp[i]+" ");
		}
		/*
		for(int k=0; k<m; k++) {
			int i = sc.nextInt()-1; //-1은 인덱스로 변환
			int j = sc.nextInt()-1;
			
			while(i<j) {
				int tmp = basket[i];
				basket[i] = basket[j];
				basket[j] = tmp;
				i++;
				j--;
			}
		}
		
		
		for(int num : basket) {
			System.out.print(num +" ");
		}
		*/
		sc.close();
	}

}
