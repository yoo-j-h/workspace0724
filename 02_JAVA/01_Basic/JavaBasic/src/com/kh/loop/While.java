package com.kh.loop;

import java.util.Scanner;

public class While {
	/*
	 * while문
	 * 
	 * [표현법]
	 * 
	 * while(조건식){
	 * 		반복할 코드
	 * 		[탈출이 가능한 구조]
	 * }
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		for(int i=0; i<10;i++) {
			System.out.println("hi");
		}
		int i = 0; //조건식에 사용할 값을 선언
		while(i<10) {
			System.out.println("hi");
			i++;//조건에 영향을 주는 증감
		}
		*/
		//사용자가 0을 입력할 때까지 반복해서 입력받아 출력 ->for
		//for(int n = sc.nextInt(); n != 0 ;n=sc.nextInt()) {
		//	System.out.println(n);
		//}
		//사용자가 0을 입력할때까지 랜던값(1~100)을 하나씩 생성해서
		//모두 더한값
		/*int choice = sc.nextInt();
		int sum = 0;
		while(choice != 0) {
			int random = (int)(Math.random()*100)+1;
			sum += random;
			choice = sc.nextInt();
		}
		System.out.println("지금까지의 총 합 : "+sum);
		
		*/
		int num;
		System.out.println("서비스 번호 입력");
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 종료");
		num =sc.nextInt();
		while(num != 3) {
			switch(num) {
			case 1:
				System.out.println("추가됨");
				break;
			case 2:
				System.out.println("삭제됨");
				break;
			case 3:
				System.out.println("종료됨");
				return;
				
			}
		}
	}

}
