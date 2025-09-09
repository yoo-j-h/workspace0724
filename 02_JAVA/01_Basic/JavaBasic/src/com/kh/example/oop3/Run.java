package com.kh.example.oop3;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.imform();
		System.out.println("------------------------------------------");
		
		Book b2 = new Book("신나는 자바", "kh", "최지원");
		b2.imform();
		System.out.println("------------------------------------------");
		
		Book b3 = new Book("스프링 기초", "한빛", "김수민",50000, 0.4);
		b3.imform();
		

	}

}
