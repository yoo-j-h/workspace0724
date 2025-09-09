package com.kh.method;

public class MethodLocalVariable {
	/*
	 * 지역변수
	 * - 블록{}내브에서 선언된 변수
	 * - 해당 블록을 벗어나면 메모리에서 제거됨
	 * - 선언시 반드시 초기화 후 사용햐야됨
	 * 
	 * 매개변수
	 * - 메서드 호풀시 외부에서 전달받는 값을 저장하는 지역변수
	 * - 메서드 선언부에 정의됨
	 * - 메서드 실행시 생성되고, 메서드 종료시 사라짐.
	 * */
	public static void main(String[] args) {
		/*
			String name = "철수";
			int age = 20;
			
			say(name,age);
		}
		public static void say(String[] name, int age) {
			//name, age는 매개변수이자 이 메서드의 지역변수
		}*/
			
		//Call by Value(값에 의한 호출) -> 자바는 무조건 이 방식으로 호출
		//메모리에 담긴 값 자체를 전달
		//기본형 -> 값(데이터)자체가 복사됨
		//참조형 -> 참조값(주소)이 복사됨
		//		  주소값을 복사해서 같은 객체를 가르키게 되므로 내부데이터를 변경하면 원본에도 영향을 줌
		int num = 10;
		changeValue(num);
		System.out.println("main에서 changeValue 종료후 : " + num);
		int[] arr = {1,2,3};
		changeReference(arr);
		System.out.println("main문의 arr---------------");
		for(int n : arr) {
			System.out.print(n+" ");
		}
		//참조형을 전달하면 실제 값자체를 전달하는게 아니라
		//참조형에 답긴 주소값을 전달하기 때문에
		//해당 주소로 접근해서 원본데이터를 변경할 수 있다.
		
	}
	public static void changeValue(int value) {
		System.out.println("전달받은 value : " + value);
		value =100;
		System.out.println("변경된 value : " + value);
	}
	public static void changeReference(int[] array) {
		System.out.println("전달받은 array-----------");
		for(int n : array) {
			System.out.print(n+" ");
		}
		System.out.println();
		array[0] = 100;
		System.out.println("전달받은 arrat 0번째 변경");
	}
}
