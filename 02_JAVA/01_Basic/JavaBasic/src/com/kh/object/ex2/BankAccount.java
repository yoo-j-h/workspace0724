package com.kh.object.ex2;

public class BankAccount {
	int balance = 0;
	
	/*
	 * 기본생성자 : 매개변수가 없는 생성자
	 * -생성자를 개발자가 정의하지 않으면 컴파일러가 자동으로 생성
	 * -생성자를 하나라고 정의하면 기본생성자는 생성되지 않음.
	 * */
	public BankAccount() {
		System.out.println("생성자 실행됨");
	}
	
	//생성자 : 필들르 초기화하기 위한 특수목적의 메서드
	//		 class와 이름이 동일하며, 반환타입이 없다.
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	void deposit(int amount) {
		balance += amount;
	}
	
	void withdraw(int amount) {
		balance -= amount;
	}
	
	void checkMyBalance() {
		System.out.println("잔액 : "+balance);
	}
	
	//계좌이체
	//내 계좌에서 amount금액을 target계좌로 입금
	void transfer(BankAccount target, int amount) {
		balance += amount;
		target.balance -= amount;
	}
}
