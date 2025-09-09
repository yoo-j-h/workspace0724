package com.kh.example.oop3;

public class Book {
	private String title;
	private String piblisher;
	private String author;
	private int price;
	private double discountRate;
	
	public Book() {
		super();
	}
	
	public Book(String title, String piblisher, String author) {
		this(title, piblisher, author, 0, 0);
	}
	
	public Book(String title, String piblisher, String author, int price, double discountRate) {
		super();
		this.title = title;
		this.piblisher = piblisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}
	
	public void imform() {
		System.out.println("제목 : " + title);
		System.out.println("출판사 : " + piblisher);
		System.out.println("저자 : " + author);
		System.out.println("가격 : " + price);
		System.out.println("할인율 : " + discountRate);
	}
	
}

