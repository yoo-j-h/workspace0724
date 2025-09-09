package com.kh.example.api;

import java.util.Scanner;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	
	public void mianMenu() {
		while(true) {
			System.out.print("1. 지정 문자열\r\n"
					+ "2. 입력 문자열\r\n"
					+ "9. 프로그램 끝내기\r\n"
					+ "메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1: 
				tokenMenu();
				break;
			case 2:
				inputMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				System.out.println();
				break;
			}
		}
	}
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		String stn = tc.afterToken(str);
		System.out.println("토큰 처리 전 글자 : "+str);
		System.out.println("토큰 처리 전 개수 : "+str.length());
		System.out.println("토큰 처리 후 글자 : "+stn);
		System.out.println("토큰 처리 후 개수 : "+stn.length());
		System.out.println("모두 대문자로 변환 : "+stn.toUpperCase());
		System.out.println();
	}
	
	public void inputMenu() {
		System.out.print("문자열을 입력하세요 : ");
		String st = sc.nextLine();
		System.out.println("첫 글자 대문자 : "+tc.firstCap(st));
		System.out.print("찾을 문자 하나를 입력하세요 : ");
		char c = sc.nextLine().charAt(0);
		System.out.println(c+" 문자가 들어간 개수 : "+tc.findChar(st, c));
		System.out.println();
	}
		
}
