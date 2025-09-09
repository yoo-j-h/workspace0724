package com.kh.abstractclass;

public class Dog implements Animal{

	@Override
	public void speak() {
		System.out.println("멍멍!");
		
	}

	@Override
	public void move() {
		System.out.println("강아지는 뛰어다닙니다.");
		
	}
	
	public void eat() {
		System.out.println("냠냠");
	}
	
}
