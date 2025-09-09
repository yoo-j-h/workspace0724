package com.kh.controller;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 나이를 입력
		 * 13세 이하면 :어린아
		 * 13초과 19세 이하 : 청소년
		 * 19세초과 :성인
		 * */
		System.out.print("나이를 입력 : ");
		int age = sc.nextInt();
		
		if(age <= 13) {
			System.out.print(age + "세는 어린이에 속합니다.");
		}else if(age > 13 && age <= 19) {
			System.out.print(age + "세는 청소년에 속합니다.");
		}else if(age > 19) {
			System.out.print(age + "세는 성인에 속합니다.");
		}else {
			System.out.print("잘못입력");
		}
	}

}
