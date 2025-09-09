package com.kh.controller;

import java.util.Scanner;

public class If {
	/*
	 * 기본적으로 프로그램의 진행은 순차적으로 이루어진다.
	 * 
	 * 특정 코드를 선택적으로 실행시키도 싶을 때 -> 조건문
	 * 특정 코드를 반복해서 실행시키도 싶을 때 -> 반복문
	 * 
	 *  *조건문
	 *  "조건식"을 통해 true 또는 false를 판단하고 true일 경우 그에 해당하는 코드를 실행
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * if문을 단독으로 사용하는 경우
		 * if(조건식){
		 * 		...실행할 구문
		 * }
		 * 
		 * 조건식이 참 -> 블럭안 코드 실행
		 * 조건식이 거짓 -> 블러안 코드 무시
		 * */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수");
		}
		if(num == 0) {
			System.out.println("0");
		}
		if(num < 0) {
			System.out.println("음수");
		}
		/*
		 * if와 else를 함께 사용하는 경우
		 * if(조건식){
		 * 	실행코드
		 * }else{
		 * 	실행코드
		 * }
		 * 
		 * 조건식이 참 -> 블럭안 코드 실행
		 * 조건식이 거짓 -> else 안 코드 실행
		 * */
		
		if(num > 0) {
			System.out.println("양수");
		}else {
			if(num == 0) {
				System.out.println("0");
			}else {
				System.out.println("음수");
			}
		}
		
		if(num > 0) {
			System.out.println("양수");
		}else if(num == 0) {
			System.out.println("0");
		}else{
			System.out.println("음수");
		}
		
	}

}
