package com.kh.practice.object;

import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int isOk = 1;
		
		for(int i=0, j=str.length()-1; i<j; i++, j--) {
			if(str.charAt(i)!=str.charAt(j)) {
				isOk = 0;
				break;
			}
		}
		System.out.println(isOk);
		
		/*내가 푼거
		char[] ch1 = new char[str.length()];
		char[] ch2 = new char[str.length()];
		for(int i=0; i<str.length(); i++) {
			ch1[i] = str.charAt(i);
		}
		for(int i=0; i<str.length(); i++) {
			ch2[str.length()-i-1] = str.charAt(i);
		}
		System.out.println(ch1);
		
		if(Arrays.equals(ch1, ch2)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		*/
		sc.close();
	}

}
