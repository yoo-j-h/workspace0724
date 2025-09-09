package com.kh.operator;

public class Operator3 {
	/*
	 * 산술연산자
	 * + - * / %
	 * 
	 * 복합대입 연산자
	 * 산술연산자와 대입연산자를 결합해서 사용
	 * 
	 * += /= -= %= *=
	 * 
	 * a= a%3; -> a %= 3
	 * */
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		int c = (++a) +b;
		int d = 16/6;
		int e = c%a;
		int f = e++;
		int g = (--b) + (d--);
		int h =2;
		
		int i = (a++)+b/(--c/f)*(g-- - d)%(++e+h);
		
		System.out.println(i);

	}

}
