package com.kh.example.exception3;

import java.util.Scanner;

public class MemberMenu {
	
	private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.print("========== KH 사이트 ========== \r\n"
					+ "=====***** 메인 메뉴 *****===== \r\n"
					+ "1. 회원가입 \r\n"
					+ "2. 로그인 \r\n"
					+ "3. 같은 이름 회원 찾기 \r\n"
					+ "9. 종료 \r\n"
					+ "메뉴 번호 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				joinMembership();
				break;
			case 2:
				boolean islogin = logIn();
				if(islogin) {
					memberMenu();
					break;
				}
				break;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				
			}
		}
	}

	private void sameName() {
		// TODO Auto-generated method stub
		
	}

	private boolean logIn() {
		for(int i=0; i<3; i++) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			String name = mc.logIn(id, pwd);
			if(name != null) {
				System.out.println(name+"님, 환영합니다!");
				return true;
			}else {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			}
		}
		return false;
	}

	private void joinMembership() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			Member m = new Member(pwd,name);
			if(mc.joinMembership(id, m)) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");
				return;
			}else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}
		
	}
	 public void memberMenu() {
		 while(true) {
				System.out.print("=====***** 회원 메뉴 *****===== \r\n"
						+ "1. 비밀번호 바꾸기 \r\n"
						+ "2. 이름 바꾸기 \r\n"
						+ "3. 로그아웃 ");
				int sel = sc.nextInt();
				sc.nextLine();
				switch(sel) {
				case 1:
					changePassword();
					break;
				case 2:
					changeName();
					break;
				case 3:
					System.out.println("로그아웃 되었습니다.");
					return;
				default:
					System.out.println("잘못입력하셨습니다.");
					
				}
			}
	    }

	 private void changeName() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		String name = mc.logIn(id, pwd);
		
		
	}

	 private void changePassword() {
		// TODO Auto-generated method stub
		
	 }
}
