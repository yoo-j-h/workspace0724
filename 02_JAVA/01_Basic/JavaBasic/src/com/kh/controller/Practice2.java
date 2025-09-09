package com.kh.controller;

import java.util.Scanner;

public class Practice2 {
	/*
	 * 성별을 (m/f)(대소문자 상관x)로 입력받아 남학색인지 여학생인지
	 * 출력하는 프로그램
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성별(m/f) : ");
		char gender = sc.next().toLowerCase().charAt(0);
		//toUpperCase() : 모든 문자열을 대문자
		//toLowerCase() : 모든 문자열을 대문자
		
		
		if (gender == 'm') {
			System.out.println("남학생입니다.");
		}else if (gender == 'f') {
			System.out.println("여학생입니다.");
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
	}

}
