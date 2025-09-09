package com.kh.loop;

import java.util.Scanner;

public class For {
	/*
	 * <반복문>
	 * 특정코드를 여러번 반복해서 실행하고자 할 때 사용
	 * 
	 * 대표적으로 for, while, do-while이 있다
	 * 
	 * for문
	 * 반복횟수가 명확할때 많이 사용
	 * 
	 * for(초기식; 조건식; 증감식){
	 * }
	 * 초기식 : 반복을 시작하기 전 변수를 선언, 초기값 설정, 처음 한번만 실행
	 * 조건식 : 반복을 계속 진행할지 여부를 판단, 참이면 반복, 거짓이면 종료
	 * 		  매번 반복문의 코드를 실행하기 전에 확인 보통 초기식에서 제시된 변수를 활용하여 조건식을 정함
	 * 증감식 : 매번 반복이 끝나후 변수 값을 증가/가소 시키는 부분.
	 *		  보통 초기식에서 제시된 변수를 가지고 증감을 처리
	 * */
	public static void main(String[] args) {
		/*
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		
		//10번 반복 반복문
		for(int i = 0; i<10; i++) {
			System.out.println("안녕하세요");
		}
		
		
		 * n번 반복
		 * for(int i=0; i<n ;i++){
		 * }
		 * 
		
		for(int i = 0; i<5; i++) {
			System.out.println("안녕하세요".charAt(i));
		}
		
		for(int i = 1; i<=5; i++) {
			System.out.print(i+" ");
		}
		
		
		 * 자바의 지역변수 (블록 scope)
		 * -특정 메서드나 블록({}) 내부에서 선언하고
		 * 선언된 블록 범위내에서만 접근이 가능하다
		 * 해당블록이 종료되면 블록 내부의 변수도 함께 사라진다.
		 * 
		for(int i = 5; i>0; i--) {
			System.out.println(10-i);
		}
		*/
		/*
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.printf("%d ",i);
		}
		/*
		 * 커피주문 키오스크
		 * [출력]
		 * 아메리카노를 몇잔 구매?(1100원) : n
		 * 결제 금액 ----원.
		 * 
		Scanner sc = new Scanner(System.in);
		System.out.print("아메리카노를 몇잔 구매?(1100원)");
		int num = sc.nextInt();
		int price = 0;
		for(int i = 1; i<= num; i++) {
			price += 1100;
		}
		System.out.printf("결제 금액 : %d원",price);
		
		//1. 아메리카노(1000원), 2. 카페라테(1500원) 선택(종료 0) :
		//위의 주문대로 주문을 받고 종료(0)을 입력하면
		//아메리카노 x잔, 카페라테 x잔
		
		//1~10 중에 홀수만 출력
		for(int i=1; i<=10; i++) {
			if(i%2==1) {
				System.out.println(i + " ");
			}
		}
		//1~100까지 수중 짝수의 합
		int sum = 0;
		for(int i = 1; i<=100; i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		
		for(int i = 2; i<=100; i+=2) {
			sum += i;
		}*/
		//System.out.println("1~100까지의 짝수의 합 : "+sum);
		//System.out.println(Math.random());
		/*
		 * Math.ranbom()
		 * java.lang.Math 클래스에서 기본적으로 제공하는 함수로 호출하면 매번 다른 랜덤값을 변환한다.
		 * 
		 * Math.random()호출시 ->0~0.9999999... 사이의 랜덤값을 변환
		 * int num = (int)Math.random()*10) +1 -> 1~10;
		 * 최소값~최대값 랜덤 수 : (int)(Math.random() * (최대값 +1 -최소값))+최소값; 
		 * */
		
		//ranbom(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한값을 출력
		/*
		int n =(int)(Math.random()*10)+1 ;
		int sum = 0;
		for(int i=1; i<=n;i++) {
			sum += i;
		}
		System.out.println("random 수 : "+n);
		System.out.println("1~n까지의 합 : "+sum);
		
		/*
		 * 각 인덱스별 문자 출력 : hello
		 * str.charAt(0) -> h
		 * 
		 * 문자열 길이 : 문자열.length()
		 * 
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println("문자열의 길이 : " + str.length());
		
		for(int i = 0 ; i <str.length(); i++) {
			System.out.print(str.charAt(i)+" ");
		}
		*/
		//사용자에게 문자열을 입력 받아 문자열짝수자리만 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		
		for (int i = 0 ; i<str.length(); i++) {
			if(i%2 == 1) {
				System.out.print(str.charAt(i)+" ");
			}
		}
	}

}
