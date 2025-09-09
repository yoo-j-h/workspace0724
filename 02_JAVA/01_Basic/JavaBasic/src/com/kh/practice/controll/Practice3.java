package com.kh.practice.controll;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("요일을 입력하세요 : ");
		String week = sc.next();
		String grade = "성인"; 
		String weekend = " ";
		double discount = 1; 
		int price = 0;
		
		if (age >= 0 && age <13 ) {
			grade = "어린이";
			price = 5000;
		}else if (age >= 13 && age <19 ) {
			grade = "청소년";
			price = 7000;
		}else if (age >= 19) {
			grade = "성인";
			price = 10000;
		}
		
		switch(week) {
		case "토":
		case "일":
			discount = 0.8;
			weekend = "(주말 할인 적용)";
			break;
		}
		
		System.out.printf("%s 요금입니다. %s\n최종 요금은 %.0f원입니다.",grade ,weekend,price*discount);
	}

}
