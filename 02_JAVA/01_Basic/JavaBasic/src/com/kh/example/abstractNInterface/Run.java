package com.kh.example.abstractNInterface;

public class Run {

	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] result = pc.method();
		
		for(String st: result) {
			System.out.println(st);
		}

	}

}
