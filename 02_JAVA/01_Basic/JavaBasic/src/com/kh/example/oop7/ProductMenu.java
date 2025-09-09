package com.kh.example.oop7;

import java.util.Scanner;

public class ProductMenu {
	private ProductController pc = new ProductController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {	
			System.out.println();
			System.out.println("====== 상품 관리 메뉴 ======");
			System.out.println("1. 상품 추가");
			System.out.println("2. 상품 전체 조회");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(num) {
			case 1 : 
				System.out.print("추가할 상품명 : ");
				String pName = sc.nextLine();
				System.out.print("추가할 가격 : ");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("추가할 브랜드 : ");
				String brand = sc.nextLine();
				
				pc.insertProduct(pName, price, brand);
				break;
			case 2:
				Product[] p = pc.selectProduct();
				int index = 0;
				for(int i=0; i<p.length; i++) {
					if(p[i] == null) {
						index = i;
						break;
					}
				}
				for(int i=0; i<index; i++) {
					System.out.println(p[i].inform());
				}
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
}
