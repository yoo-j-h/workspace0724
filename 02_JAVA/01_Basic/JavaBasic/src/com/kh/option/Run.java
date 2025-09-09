package com.kh.option;
import java.util.*;

/*
 * pakage
 * 클래스 간의 공간적 충돌잉나 접근방법의 충돌을 막기위해
 * 저장위치를 구분한여 명확하게 접근 할 수 있도록 해주는것
 * 
 * 네이밍 방식
 * 도메인 : www.kh.com이라는 가정
 * 패키지 : vom.kh.팀명(또는 프로잭트명)
 * 
 * 
 * static
 * static변수와 static메서드는 정적메모리에 저장된다.
 * 프로그램 실행 시점에 메모리가 생성되며, 객체생성없이도 접근이 가능하다.
 * 모든 객체가 공유하여 사용한다.
 *
 * static변수
 * 클래스에 소속된 모든 인스턴스가 공유하는 변수, 한 클래스에서 공통적인 값을 유지해야할 때 사용.
 * 객체생성없이 클래스명.변수명 형태로 접근이 가능하며, 일반적으로 final과 함께 사용됨.
 * 
 * static 메서드
 * 인스턴스 변수없이 클래스 단위로 호출할 수 있는 메서드, 객체상태와 무관하게 동작하는 반복적인 기능 구현시 유용.
 * 단, 인스턴스 변수나 인트턴스 메서드에 직접접근 불가 -> this키원드 사용X
 *
 * */
public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Counter c1 = new Counter("첫번째 객체");
		Counter c2 = new Counter("두번째 객체");
		
		Counter.showCount();
		
		c1.showCount();
	}

}
