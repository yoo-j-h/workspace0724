package com.kh.operator;

import java.util.Scanner;

public class Practice1 {
	/*
	 * 키보드로 가로, 세로값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산
	 * 면적 가로*세로
	 * 둘레 : (가로+세로)*2
	 * 
	 * [출력]
	 * 가로 : (입력)
	 * 세로 : (입력)
	 * 
	 * 면적 : ~
	 * 둘레 : ~
	 * +소수점 2번째 자리까지 출력
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("가로 : ");
		float width = sc.nextFloat();
		
		System.out.print("세로 : ");
		float length = sc.nextFloat();
		
		float area = width * length;
		float round = (width + length)*2;
		System.out.printf("면적 : %.2f\n둘레 : %.2f",area,round);
	}

}
