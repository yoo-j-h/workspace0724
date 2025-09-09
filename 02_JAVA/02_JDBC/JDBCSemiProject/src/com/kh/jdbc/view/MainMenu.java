package com.kh.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.controller.GameController;
import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.vo.CoinGame;
import com.kh.jdbc.model.vo.DiceGame;
import com.kh.jdbc.model.vo.Game;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.model.vo.RPSGame;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private GameController gc = new GameController();
	
	
	public void mainMenu(){
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
				Member m = logIn();
				if(m != null) {
					loginMenu(m);
				}
				break;
			case 2: joinMembership(); break;
			case 3: getRank(); break;
			case 9: 
				System.out.println("프로그램을 종료합니다");
				return;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	private void getRank() {
		System.out.println();
		System.out.println("======게임별 TOP3유저======");
		gc.getRank();
	}
	public void loginMenu(Member m) {
		while(true) {
			System.out.println();
			System.out.println("======회원 메뉴======");
			System.out.println("1) 게임 선택");
			System.out.println("2) 내 점수");
			System.out.println("3) 회원정보 수정");
			System.out.println("9) 로그아웃");
			System.out.print("번호를 선택해 주세요 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1: gamePlay(m); break;
			case 2: getScore(m); break;
			case 3: if(memberMenu(m)) break;  return;
			case 9:
				System.out.println("로그아웃 합니다.");
				return;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}
	private void getScore(Member m) {
		System.out.println();
		gc.getScore(m);
		
	}
	private void gamePlay(Member m) {
		while(true) {
			System.out.println();
			System.out.println("======게임 메뉴======");
			System.out.println("1) 가위,바위,보");
			System.out.println("2) 동전던지기");
			System.out.println("3) 주사위 게임");
			System.out.println("9) 메인메뉴로 돌아가기");
			System.out.print("번호를 선택해 주세요 : ");
			int code = sc.nextInt();
			sc.nextLine();
			int result = gc.gamePlay(code,m);
			switch(result) {
			case 9:
				System.out.println("메인메뉴로 돌아갑니다.");
				return;
			}
		}
	}

	public boolean memberMenu(Member m) {
		while(true) {
			System.out.println();
			System.out.println("======회원 메뉴======");
			System.out.println("1) 비밀번호 변경");
			System.out.println("2) 닉네임 변경");
			System.out.println("3) 회원 탈퇴");
			System.out.println("9) 회원메뉴로 돌아가기");
			System.out.print("번호를 선택해 주세요 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1: changePassword(m); break;
			case 2: changeName(m); break;
			case 3: deleteMember(m); return false;
			case 9:
				System.out.println("회원메뉴로 돌아갑니다.");
				return true;
			default : 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}
	public void deleteMember(Member m) {
		for(int i=0; i<3; i++) {
			System.out.println();
			System.out.println("======회원 탈퇴======");
	     	System.out.print("비밀번호 확인: ");
	    	String pwd = sc.nextLine();
	    	if(mc.checkAccount(m, pwd)) {
	    		boolean isTrue = mc.deleteMember(m.getId(), pwd);
	    		if(isTrue) return;
	    	}
		}		
	}
	public void changePassword(Member m) {
		for(int i=0; i<3; i++) {
			System.out.println();
			System.out.println("======비밀번호 변경======");
	     	System.out.print("비밀번호 확인: ");
	    	String oldPwd = sc.nextLine();
	    	if(mc.checkAccount(m, oldPwd)) {
	    		System.out.println("변경할 비밀번호를 입력해주세요.");
	    		System.out.print("변경할 비밀번호 : ");
	    		String newPwd = sc.nextLine();
	    		boolean isChange = mc.changePassword(m.getId(),oldPwd,newPwd);
	    		if(isChange) return;
	    	}
		}		
	}
	public void changeName(Member m) {
		for(int i=0; i<3; i++) {
			System.out.println();
			System.out.println("======닉네임 변경======");
	     	System.out.print("비밀번호 확인: ");
	    	String pwd = sc.nextLine();
	    	if(mc.checkAccount(m, pwd)) {
	    		System.out.println("변경할 닉네임를 입력해주세요.");
	    		System.out.print("변경할 닉네임 : ");
	    		String newName = sc.nextLine();
	    		boolean isChange = mc.changeName(m.getId(),pwd,newName);
	    		if(isChange) return;
	    	}
		}		
	}
	public Member logIn() {
		for(int i=0; i<3; i++) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			Member result = (Member)mc.logIn(id, pwd);
			return result;
			
    	}	
    	return null;
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
		System.out.println(msg);
	}
	
	public String RSPdisplay() {
		System.out.println();
		System.out.println("======가위,바위,보======");
		System.out.println("가위,바위,보 중에 하나를 입력해주세요.");
		System.out.print("(그만하려면 '끝'을 입력해주세요) : ");
		String rps = sc.nextLine();
		return rps;
	}
	public void oppResult(int opp, Game g) {
		if(g instanceof RPSGame) {
			switch(opp) {
			case 1 : 
				System.out.println("상대방 : 가위"); break;
			case 2 : 
				System.out.println("상대방 : 바위"); break;
			case 3 : 
				System.out.println("상대방 : 보"); break;
			}
		}
		else if(g instanceof CoinGame) {
			switch(opp) {
			case 1 : 
				System.out.println("동전 : 앞"); break;
			case 2 : 
				System.out.println("동전 : 뒤"); break;
			}
		}
		else if(g instanceof DiceGame) {
			switch(opp) {
			case 1 : 
				System.out.println("주사위 : 1"); break;
			case 2 : 
				System.out.println("주사위 : 2"); break;
			case 3 : 
				System.out.println("주사위 : 3"); break;
			case 4 : 
				System.out.println("주사위 : 4"); break;
			case 5 : 
				System.out.println("주사위 : 5"); break;
			case 6 : 
				System.out.println("주사위 : 6"); break;
			}
		}
	}
	public String gamedisplay(Game game) {
		if(game instanceof RPSGame) {
			System.out.println();
			System.out.println("======가위,바위,보======");
			System.out.println("가위,바위,보 중에 하나를 입력해주세요.");
			System.out.print("(그만하려면 '끝'을 입력해주세요) : ");
			String action = sc.nextLine();
			return action;
		}else if(game instanceof CoinGame) {
			System.out.println();
			System.out.println("======동전 던지기======");
			System.out.println("앞,뒤 중에 하나를 입력해주세요.");
			System.out.print("(그만하려면 '끝'을 입력해주세요) : ");
			String action = sc.nextLine();
			return action;
		}else if(game instanceof DiceGame) {
			System.out.println();
			System.out.println("======주사위 게임======");
			System.out.println("1~6 중에 하나를 입력해주세요.");
			System.out.print("(그만하려면 '끝'을 입력해주세요) : ");
			String action = sc.nextLine();
			return action;
		}
		return null;
	}
	
	public void displayList(List list, String title) {
		System.out.println("\n======"+title+"======");
		for(Object o : list) {
			System.out.println(o);
		}
	}
	
}
