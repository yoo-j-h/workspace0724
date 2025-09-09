package com.kh.practice.controll;

import java.util.Scanner;

public class Practice1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		char grade = '-';
		if (score >= 0 && score <60) {
			grade = 'F';
		}else if (score >= 60 && score <70) {
			grade = 'D';
		}else if (score >= 70 && score <80) {
			grade = 'C';
		}else if (score >= 80 && score <90) {
			grade = 'B';
		}else if (score >= 90 && score <=100) {
			grade = 'A';
		}
		
		System.out.printf("당신의 성적은 %s입니다.",grade);
		
		sc.close();

	}

}
