package com.kh.jdbc.view;

import java.util.Scanner;

import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.vo.Member;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void MainMenu(){
		while(true) {
			System.out.println("======메인 메뉴======");
			System.out.println("1) 로그인");
			System.out.println("2) 회원가입");
			System.out.println("3) 게임별 top3");
			System.out.println("9) 종료");
			System.out.print("번호를 선택해 주세요 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1: 
				boolean isLogin = logIn();
				if(isLogin) {
					loginMenu();
				}
				break;
			case 2: joinMembership(); break;
			case 3: break;
			case 9: 
				System.out.println("프로그램을 종료합니다");
				return;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	public void loginMenu() {
		while(true) {
			System.out.println("======회원 메뉴======");
			System.out.println("1) 게임 선택");
			System.out.println("2) 내 점수");
			System.out.println("3) 랭킹 검색");
			System.out.println("4) 회원정보 수정");
			System.out.println("9) 로그아웃");
			System.out.print("번호를 선택해 주세요 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: memberMenu(); break;
			case 9:
				System.out.println("로그아웃 합니다.");
				return;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}
	public void memberMenu() {
		while(true) {
			System.out.println("======회원 메뉴======");
			System.out.println("1) 비밀번호 변경");
			System.out.println("2) 닉네임 변경");
			System.out.println("9) 회원메뉴로 돌아가기");
			System.out.print("번호를 선택해 주세요 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1: changePassword(); break;
			case 2: changeName(); break;
			case 9:
				System.out.println("회원메뉴로 돌아갑니다.");
				return;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}
	public void changePassword() {
		for(int i=0; i<3; i++) {
			System.out.println("======비밀번호 변경======");
			System.out.println("본인확인을 위해 아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
	    	String id = sc.nextLine();
	     	System.out.print("비밀번호 : ");
	    	String oldPwd = sc.nextLine();
	    	if(mc.checkAccount(id, oldPwd)) {
	    		System.out.println("변경할 비밀번호를 입력해주세요.");
	    		System.out.print("변경할 비밀번호 : ");
	    		String newPwd = sc.nextLine();
	    		boolean isChange = mc.changePassword(id,oldPwd,newPwd);
	    		if(isChange) return;
	    	}
		}		
	}
	public void changeName() {
		for(int i=0; i<3; i++) {
			System.out.println("======닉네임 변경======");
			System.out.println("본인확인을 위해 아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
	    	String id = sc.nextLine();
	     	System.out.print("비밀번호 : ");
	    	String pwd = sc.nextLine();
	    	if(mc.checkAccount(id, pwd)) {
	    		System.out.println("변경할 닉네임를 입력해주세요.");
	    		System.out.print("변경할 닉네임 : ");
	    		String newName = sc.nextLine();
	    		boolean isChange = mc.changeName(id,pwd,newName);
	    		if(isChange) return;
	    	}
		}		
	}
	public boolean logIn() {
		for(int i=0; i<3; i++) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			boolean result = mc.logIn(id, pwd);
			if(result)return true;
			
    	}	
    	return false;
	}

	public void joinMembership() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			System.out.print("닉네임 : ");
			String name = sc.nextLine();
			boolean isOk = mc.joinMembership(id, pwd, name);
			if(isOk) return;
		}
		
	}
	
	public void displayNoData(String msg) {
		System.out.println("\n" + msg);
	}
	
}
