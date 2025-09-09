package com.kh.operator;

public class Operator4 {
	/*
	 * 비교연산자 / 관계연산자
	 * 두값을 비교하여 조건을 판단하는 연산자
	 * 비교결과는 항상 boolean 타입을 반환
	 * 
	 * 종류
	 * <대소비교> " : <, >, <=, >=
	 * 동등비교 : ==, !=
	 * 
	 * 원시타입
	 * 정수, 실수, 문자등 기본 변순는 ==, != 등으로 비교가 가능
	 * 
	 * 참조형 비교(String)
	 * String 같은 객체는 참조형이므로 ==로 비교시 문제가 발생
	 * (참조형은 일반적으로 연산자를 사용해 비교하면 값 자체가 아닌 주소값으로 비교됨)
	 * 내부함수를 이용해서 비교해야함 ex) .equals
	 * 해당 탐조변수가 가지고 있는 변수값을 비교
	 * 
	 * */
	public static void main(String[] args) {
		int a = 10;
		int b = 25;
		System.out.println(a==b);
		System.out.println(a<=b);
		
		String str1 = "hello"; //hello는 문자형 리커널
		String str2 = "hello"; //자바에서 문자열 리터널은 string pool 이라는 메모리 영여에 저장
		//만약 위처럼 동일한 문자열 리터널에 또 참조가 되면, 기존에 기던 문자열 객체 주소를 나타냄
		System.out.println(str1==str2);
		
		String str3 = new String("hello");
		
		//특이케이스(문자와 숫자간의 대소비교)
		System.out.println('A' + 0);
		System.out.println('A' > 70);
	}

}
