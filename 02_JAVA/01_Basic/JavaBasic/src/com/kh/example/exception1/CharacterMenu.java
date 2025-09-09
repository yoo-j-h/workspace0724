package com.kh.example.exception1;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		CharacterController cc = new CharacterController();
		
		System.out.print("문자열 : ");
		String st = sc.nextLine();
		try {
			System.out.printf("%s에 포함된 영문자 개수 : %d",st,cc.countAlpha(st)); 
		} catch (CharCheckException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
