package com.kh.jdbc.controller;

import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.service.MemberService;
import com.kh.jdbc.view.MainMenu;


public class MemberController {
	private MemberService ms = new MemberService();
	
	public boolean joinMembership(String id, String pwd, String name) {
		Member m = new Member(id, pwd, name);
		
		int result = ms.joinMembership(m);
		if(result>0) {
			new MainMenu().displayNoData("성공적으로 회원가입 완료하였습니다.");
			return true;
		}else {
			new MainMenu().displayNoData("중복된 아이디입니다. 다시 입력해주세요.");
			return false;
		}
	}

	public boolean logIn(String id, String pwd) {
		Member m = new Member(id,pwd);
		String name = ms.logIn(m);
		if(name != null) {
			new MainMenu().displayNoData(name + "님, 환영합니다!");
			return true;
		}else {
			new MainMenu().displayNoData("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			return false;
		}
		
	}
	public boolean checkAccount(String id, String pwd) {
		Member m = new Member(id,pwd);
		String name = ms.logIn(m);
		if(name != null) {
			new MainMenu().displayNoData("인증되었습니다.");
			return true;
		}else {
			new MainMenu().displayNoData("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			return false;
		}
		
	}

	public boolean changePassword(String id, String oldPwd, String newPwd) {
		Member m = new Member(id, newPwd);
		if(newPwd!=null && !newPwd.equals(oldPwd)){
			int result = ms.changePassword(m);
			if(result > 0) {
				new MainMenu().displayNoData("비밀번호가 변경되었습니다.");
				return true;
			} else {
				new MainMenu().displayNoData("비밀번호 변경에 실패했습니다.");
			}
		}else {
			new MainMenu().displayNoData("새로운 비밀번호는 공백이거나 기존의 비밀번호와 같을 수 없습니다.");
		}
		
		return false;
	}

	public boolean changeName(String id, String pwd, String newName) {
		
		Member m = new Member(id,pwd,newName);
		if(newName!=null){
			int result = ms.changeName(m);
			if(result > 0) {
				new MainMenu().displayNoData("닉네임이 "+newName+"로 변경되었습니다.");
				return true;
			} else {
				new MainMenu().displayNoData("닉네임 변경에 실패했습니다.");
			}
		}else {
			new MainMenu().displayNoData("닉네임은 공백일 수 없습니다.");
		}
		
		return false;
	}

}
