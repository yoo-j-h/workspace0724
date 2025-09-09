package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {
	Scanner sc = new Scanner(System.in);
	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();
	
	
	public void inputMenu() {
		System.out.println("=====도형 프로그램====");
		System.out.println("3. 삼각형");
		System.out.println("4. 사각형");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
			switch(num) {
			case 3 :
				triangleMenu();
				break;
			case 4 :
				triangleMenu();
				break;
			case 9 :
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}

		
	}
	
	public void triangleMenu() {
		while(true) {
			System.out.println("=====삼각형====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1 :
				inputSize(3,2);
				break;
			case 2 :
				inputSize(3,3);
				break;
			case 3 :
				printInformation(3);
				break;
			case 9 :
				return;
			}
		}
	}
	public void squareMenu() {
		System.out.println();
		System.out.println("=====사각형====");
		System.out.println("1. 사각형 면적");
		System.out.println("2. 사각형 색칠");
		System.out.println("3. 사각형 정보");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
			switch(num) {
				case 1 :
					System.out.print("높이 : ");
					double h = sc.nextDouble();
					System.out.print("넓이 : ");
					double w = sc.nextDouble();
					System.out.println("사각형 면적 : " + scr.calcArea(h, w));
					break;
				case 2 :
					System.out.print("색깔은 입력하세요 : ");
					String col = sc.next();
					scr.paintColor(col);
					break;
				case 3 :
					System.out.println(scr.print());
					break;
				case 9 : 
			}
		
	}
	
	public void inputSize(int type, int menuNum) {
		//type -> 3: 삼각형/ 4: 사각형
		//menuNum -> 1: 높이너비 입력 2:색상
		
		
		switch(menuNum) {
		case 1:
			System.out.print("높이 : ");
			double h = sc.nextDouble();
			System.out.print("너비 : ");
			double w = sc.nextDouble();
			double perimeter = scr.calcPerimeter(h, w);
			System.out.println("사각형 둘레의 길이 : " + perimeter);
			break;
		case 2:
			System.out.print("높이 : ");
			double h = sc.nextDouble();
			System.out.print("너비 : ");
			double w = sc.nextDouble();
			if(type == 3)
				System.out.println(tc.calcArea(h, w));
			else
				System.out.println(scr.calcArea(h, w));
		case 3:
			
		}
			
	}
	
	public void printInformation(int type) {
		System.out.println(type == 3 ? tc.print() : scr.print());
	}
}
