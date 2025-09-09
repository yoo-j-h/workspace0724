package com.kh.controller;

import java.util.Scanner;

public class Practice3 {
	/*
	 * 정수(양수)를 입력받아
	 * 짝수인지 홀수인지 출력
	 * 
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num <= 0) {
			System.out.println("양수가 아니다");
		}else if(num % 2 == 0) {
			System.out.println("짝수다");
		}else {
			System.out.println("홀수다");
		}

	}

}
