package com.kh.operator;

import java.util.Scanner;

public class Operator {
	/*
	 * 논리연산자
	 * 두개의 논리값을 연산해주는 연산자
	 * 논리연산자의 결과도 논리값.
	 * 
	 * 논리값 && 논리값 : 왼쪽, 오른쪽의 조건이 모두 true일 경우 결과는 true. and
	 * 논리값 || 논리값 : 왼쪽, 오른쪽의 조건중 하나라고 true일 경우 결과는 true. or
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		System.out.print("숫자 입력 : ");
		num = sc.nextInt();
		boolean result = num >=1 && num <= 100;
		System.out.println("사용자가 입력한 값은 1이상 100이하이다 : "+result);
		
		char ch;
		System.out.print("문자 하나 입력 : ");
		ch = sc.next().charAt(0); //문자열에서 문자하나를 추출하는 함수
		//charAt(index)
		
		System.out.println((int)'A' + " " +(int)'Z');
		boolean res1 = (ch >= 'A' && ch <='Z'); //true는 대문자
		boolean res2 = (ch >= 'a' && ch <='z'); //true는 소문자
		//둘다 거짓이면 알파펫이 아닌 다른 문자
		System.out.println("사용자가 입력한 값은 알파벳이다. " + (res1 || res2));
		System.out.println("사용자가 입력한 값은 소문자이다. " + (res2));
		System.out.println("사용자가 입력한 값은 대문자이다. " + (res1));
	}

}
