package com.kh.basic;

import java.util.Scanner;

public class Input {
	/*
	 * 입력 : 외부에서의 데이커를 코드 내부로 가져오는 것
	 * 
	 * Scanner를 사용하면 키보드에 입력값을 가져올 수 있음.
	 * (java,util.Scanner 클래스를 이용함.)
	 * 
	 * [사용법]
	 * Scanner 이름 = new Scanner(System.in)
	 * */
	public static void main(String[] args) {
		//Scanner객체 생성
		Scanner sc = new Scanner(System.in);
		/*
		String str1, str2;
		System.out.print("입력 : ");
		str1 = sc.next();
		str2 = sc.next();
			
		System.out.println("입력 값 : "+str1);
		System.out.println("입력 값 : "+str2);
		*/
		//.next()
		//문자열을 입력받는 함수(공백 전까지)
		
		//.nextLine()
		//무자열을 입력받는 함수 (동백을 포함한 한줄, 계행문자까지)
		System.out.print("이름 : ");
		String name = sc.nextLine();
			
		System.out.print("나이 : ");
		int age = sc.nextInt(); 
		sc.nextLine(); //버퍼에 남아있는 nextInt()를 입력할 때 발생한 \n값을 비워주는 코드
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.printf("이름은 %s, 나이는 %d, 주소는 %s 입니다",name,age,address);
		//문자이외에 원시타입을 입력받을 때
		//.next타입()
		//nextInt(), nextDouble(), nextBlooean(), ...
		
		sc.close(); //Scanner자원을 다쓰고 반납 *한번 반납하면 다시 사용x
		
		//sc =new Scanner(System.in);//에러 발생
		
	}
}
