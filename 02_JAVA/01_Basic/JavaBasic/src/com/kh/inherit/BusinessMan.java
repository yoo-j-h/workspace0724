package com.kh.inherit;

public class BusinessMan extends Man{
	private String company;
	private String position;
	public BusinessMan(String company, String position) {
		super(); //자식 클래스의 생성자에는 무조건 부모생성자가 필요함.
		//맨 첫번째 줄에, 생략시 부모의 기본생성자를 호출(없으면 에러)
		this.company = company;
		this.position = position;
	}
	public void tellYourFinfo() {
		System.out.println("my company is "+company);
		System.out.println("my position os"+position);
		super.tellYourName();//super.-> 부모의 메모리
	}
	

}
