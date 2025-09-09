package com.kh.practice.object;

import java.util.Scanner;

public class Practice4 {
	/*
	 * 문자열.replace("찾을 문자, 바꿀 문자열");
	 * 원래문자열에서 찾을 문자열을 검색하여 바꿀 문자열로 차환한 새로운 문자열을 변환
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s =sc.next();
		
		
		int i=0, count=0;
		while(i<s.length()) {
			if(s.charAt(i) == 'd' &&
			   s.charAt(i+1) == 'z' &&
			   s.charAt(i+1) == '=') {
				count++;
				i += 3;
				continue;
			}
			String str = str.charAt(i)+""+ s.charAt(i+1);
			if(str.equals("c=")||
				str.equals("c-")||
				str.equals("d-")||
				str.equals("nj")||
				str.equals("c=")||
					) {
				
			}
			
			i++;
		}
	}
}
