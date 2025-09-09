package com.kh.example.collection2;

import java.util.HashSet;
import java.util.Scanner;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc= new LotteryController();
	
	public void mainMenu() {
		while(true) {
			System.out.print("========== KH 추첨 프로그램 ========== \r\n"
					+ "=====***** 메인 메뉴 *****===== \r\n"
					+ "1. 추첨 대상 추가 \r\n"
					+ "2. 추첨 대상 삭제 \r\n"
					+ "3. 당첨 대상 확인 \r\n"
					+ "4. 정렬된 당첨 대상 확인 \r\n"
					+ "5. 당첨 대상 검색 \r\n"
					+ "9. 종료 \r\n"
					+ "메뉴 번호 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default :
				System.out.println("잘못입력");
			}
		}

		
	}

	public void searchWinner() {
		System.out.print("검색할 대상의 이름과 핸드폰 번호를 입력하세요. \r\n"
				+ "이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		if(lc.searchWinner(new Lottery(name, phone))) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		}else {
			System.out.println("다음 기회에");
		}
		
	}

	public void sortedWinObject() {
		// TODO Auto-generated method stub
		
	}

	public void winObject() {
		HashSet<Lottery> win = lc.winObject();
		System.out.println(win);
		
	}

	public void deleteObject() {
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요. \r\n"
				+ "이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		if(lc.deleteObject(new Lottery(name, phone))) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
	}

	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int count = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<count; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호('-'빼고) : ");
			String phone = sc.nextLine();
			
			boolean isInsert = lc.insertObject(new Lottery(name, phone))
			if(!isInsert){
				
			}
			/*
			 * if(lc.insertObject(new Lottery(name,phone))) {
			 * System.out.println(count+"명 추가완료"); }else { System.out.println("추가실패"); }
			 */
		}
		
	}
}
