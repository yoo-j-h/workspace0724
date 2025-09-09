package com.kh.example.inherit;

import java.util.Scanner;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1: circleMenu();
				break;
			case 2 : rectangleMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
	
	public void circleMenu() {
		System.out.println();
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		sc.nextLine();
		
		switch(select) {
		case 1: calcCircum();
			break;
		case 2 : calcCircleArea();
			break;
		case 9:
			return;
		default:
			System.out.println("잘못입력하셨습니다.");
			circleMenu();
			break;
		}
	}
	
	public void rectangleMenu() {
		System.out.println();
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		sc.nextLine();
		
		switch(select) {
		case 1: calcPerimeter();
			break;
		case 2 : calcRectArea();
			break;
		case 9:
			return;
		default:
			System.out.println("잘못입력하셨습니다.");
			rectangleMenu();
			break;
		}
	}
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		System.out.print("반지름 : ");
		int r = sc.nextInt();
		sc.nextLine();
		System.out.println("둘레 : "+cc.calcCircum(x, y, r));
	}
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		System.out.print("반지름 : ");
		int r = sc.nextInt();
		sc.nextLine();
		System.out.println("면적 : "+cc.calcArea(x, y, r));
	}
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		System.out.print("높이 : ");
		int h = sc.nextInt();
		sc.nextLine();
		System.out.print("너비 : ");
		int w = sc.nextInt();
		sc.nextLine();
		System.out.println("둘레 : "+rc.calcPerimeter(x, y, h, w));
	}
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		sc.nextLine();
		System.out.print("높이 : ");
		int h = sc.nextInt();
		sc.nextLine();
		System.out.print("너비 : ");
		int w = sc.nextInt();
		sc.nextLine();
		System.out.println("면적 : "+rc.calcArea(x, y, h, w));
	}
}
