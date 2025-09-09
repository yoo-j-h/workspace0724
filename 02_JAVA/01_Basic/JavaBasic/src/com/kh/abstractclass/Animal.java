package com.kh.abstractclass;

public abstract class Animal{
	//일반
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	//추상
	public abstract void speak();
	public abstract void move();
}
