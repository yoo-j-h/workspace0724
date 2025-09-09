package com.kh.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunException {
	//1. try~catch
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("a/b...a : ");
			int a = sc.nextInt();
			
			System.out.print("a/b...b : ");
			int b = sc.nextInt();
			
			System.out.printf("%d / %d = %d",a,b,a/b);
			System.out.println("계산완료");
		}catch(ArithmeticException e) {
			System.out.println("수학적 에러 발생"+e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("입력 오류 발생");
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
	//2. throws : 여기서 에외를 처리하지 않고 현재 이 메서드를 호출한 곳으로 예외처릴르 위임한다.
	public void method2() {
		//checked Exception : 반드시 예외처리를 해야하는 예외들 (강제되어 안할 수 없음)
		//-> 조건문을 미리 제시할 수 없음(왜? 예측이 불가한 문제가 많음)
		//-> 외부 매개체와 입출력이 일어날 때 발생할 수 있음
		
		//Scanner와 같이 키보드로 입력받은 값을 코드로 가져와주는 객체(단, 문자열로만 읽어들인다.) 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		String str = null;
		try {
			//이 시점에 바로 예외를 처리하거나 예외를 동일하게 위임하면 됨
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(str);
	}
	public void methodA() throws IOException,CustomExeption {
		 methodB();
	}
	public void methodB() throws IOException,CustomExeption {
		 //methodC();
		 methodD();
	}
	public void methodC() throws IOException{
		 throw new IOException();
	}
	public void methodD() throws CustomExeption{
		 throw new CustomExeption("커스텀 에러");
	}
}
