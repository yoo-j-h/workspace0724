package com.kh.polymorphism;

public class Avante extends Car{
	public Avante(String color, String fuel, int year) {
		super(color, fuel, year);
	}
	public void moveAvante() {
		System.out.println("빵빵~ Avante");
	}
	public void drive() {
		System.out.println("슈웅 슈웅~");
	}
	
}
