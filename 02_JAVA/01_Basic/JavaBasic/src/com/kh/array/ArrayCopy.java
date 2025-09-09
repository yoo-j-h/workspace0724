package com.kh.array;

import java.util.Scanner;

public class ArrayCopy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] origin = {1,2,3,4,5};
		System.out.println("==원본==");
		for(int n : origin) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		int[] copy = origin;
		System.out.println("==복사본==");
		for(int n : copy) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		copy[2] = 99;
		System.out.println("복사본 값 변경");
		
		System.out.println("==원본==");
		for(int n : origin) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		//copy배열의 값을 수정해도 원본의 값이 변경됨.
		//왜? origin과 copy는 참조변수이고, 같은 메모리를 참조하고 있기 때문에(주소값이 동일)
		//얕은 복사 : 주소값 복사
		
		/*배열의 복사 방법
		 * 
		 * 1. for문을 활용 방법
		 * 새로운 배열을 만들어서 반복문을 통해 원본배열의 각 요소를 복사함.
		 * 완벽한 깊은 복사 : 서로 독립적인 배열 생성
		 * */
		int[] origin2 = {1,2,3,4,5};
		int[] copy2 = new int[origin.length];
		
		for(int i=0; i<copy2.length; i++) {
			copy2[i] = origin[i];
		}

		copy2[2] = 99;
		
		System.out.println("==복사본2==");
		for(int n : copy2) {
			System.out.print(n+" ");
		}
		System.out.println();
	
		
		System.out.println("==원본2==");
		for(int n : origin2) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		/*
		 * clone()
		 * java에서 제공하는 메서드
		 * 배열의 모든 요소를 새로운 배열로 복사
		 * 기본적으로 얕은복사를 진행함. 단, 기본형배열은 깊은복사로 동작.
		 * */
		
		int[] origin3 = {1,2,3,4,5};
		int[] copy3 = origin3.clone();
		copy3[2] = 99;
				
		System.out.println("==복사본3==");
		for(int n : copy3) {
			System.out.print(n+" ");
		}
		System.out.println();
	
		
		System.out.println("==원본3==");
		for(int n : origin3) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
}
