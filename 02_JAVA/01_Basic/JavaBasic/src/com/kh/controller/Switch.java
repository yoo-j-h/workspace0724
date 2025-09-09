package com.kh.controller;

import java.util.Scanner;

public class Switch {
	/*
	 * switch문도 if문과 동일하게 조건문
	 * 
	 * 다만, switch문은 값이 정확하게 일치(동등비교)하는 경우에만 사용
	 * switch(비교대상(정수,문자,문자열)){
	 * case 값1 : 실행코드;
	 * case 값2 : 실행코드;
	 * case 값3 : 실행코드;
	 * ...
	 * default : 전부 일치하지 않았을 때 실행
	 * 
	 * break;
	 * }
	 * */
	public static void main(String[] args) {
		/*
		 * 정수를 입력받아서
		 * 1일경우 빨간색입니다.
		 * 2일경우 파란색
		 * 3일경우 초록색
		 * 모두 잘못 입력
		 * 
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		switch(num) {
		case 1 : 
			System.out.println("빨간색");
			break;
		case 2 : 
			System.out.println("파란색");
			break;
		case 3 : 
			System.out.println("초록색");
			break;
		default : 
			System.out.println("잘못입력");
			break;
		}
		
		 * 과일을 구매하는 프로그램
		 * 구매하고자 하는 과일 입력
		 * 그 가격이 출력
		 * 
		 * 
		String fruit;
		System.out.print("구매하고자 하는 과일 입력(사과:2000원, 바나나:3000원, 딸기:5000원): ");
		fruit = sc.next();
		switch(fruit) {
		case "사과" :
			System.out.println("사과의 가격은 2000원");
			break;
		case "바나나" :
			System.out.println("바나나의 가격은 3000원");
			break;
		case "딸기" :
			System.out.println("딸기의 가격은 5000원");
			break;
		default :
			System.out.println("잘못입력");
		}
		*/
		/*월을 입력받아서 해당월에 마지막일이 몇일인지를 출력하는 프로그램 작성
		 * [출력]
		 * 월을 입력하세요
		 * 
		 * 
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		int day = 0;
		if( month == 1 ||month == 3||month == 5||month == 7
				||month == 8||month == 10||month == 12){
			day = 31;
		}else if(month == 4||month == 6||month == 9||month == 11) {
			day = 30;
		}else if(month == 2){
			day = 28;
		}else {
			System.out.println("잘못입력");
		}
		
		System.out.printf("%d월은 %d일까지 있습니다.", month, day);
		*/
		
	}

}
