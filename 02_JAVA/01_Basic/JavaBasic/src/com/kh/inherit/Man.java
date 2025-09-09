package com.kh.inherit;

public class Man extends Object{
	private String name;

	public Man() {
		super();
		System.out.println("man 기본 생성자`");
	}
	
	public Man(String name) {
		super(); //Object의 생성자
		this.name = name;
		System.out.println("Man의 이름이 포함된 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void tellYourName() {
		System.out.println("my name is "+name);
	}
}
