package com.kh.example.poly2;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);

	public void mianMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		Member m = new Member(name, age, gender);
		lc.insertMember(m);
		
		while(true) {
			System.out.println();
			System.out.print("==== 메뉴 ==== \r\n"
					+ "1. 마이페이지 \r\n"
					+ "2. 도서 전체 조회 \r\n"
					+ "3. 도서 검색 \r\n"
					+ "4. 도서 대여하기 \r\n"
					+ "9. 프로그램 종료하기 \r\n"
					+ "메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1:
				System.out.println(lc.myInfo().toString());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
	
	public void selectAll() {
		Book[] b = lc.selectAll();
		for(int i=0; i<b.length; i++) {
			System.out.printf("%d번 도서 : %s\n",i,b[i].toString());
		}
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.nextLine();
		Book[] search = lc.searchBook(keyword);
		for(int i=0; i<search.length; i++) {
			if(search[i] != null)
			System.out.println(search[i].toString());
		}
	}
	
	public void rentBook() {
		selectAll();
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		sc.nextLine();
		int result = lc.rentBook(index);
		switch(result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
			break;
		}
	}
}
