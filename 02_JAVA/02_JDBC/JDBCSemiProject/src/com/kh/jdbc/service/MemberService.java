package com.kh.jdbc.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

public class MemberService {
	public MemberService() {
		super();
	}

	public int joinMembership(Member m) {
		Connection conn = getConnection();
		List<Member> list = new MemberDao().selectIdList(conn);
		if(!list.contains(m)) {
			int result = new MemberDao().insertMember(m, conn);
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			return result;
		}
		return 0;
	}

	public String logIn(Member m) {
		Connection conn  = getConnection();
		List<Member> list = new MemberDao().selectMemberList(conn);
		for(Member mem : list) {
			if(mem.equals(m)&&mem.getPwd().equals(m.getPwd())) {
				return mem.getName();
			}
		}
		return null;
	}

	public int changePassword(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().changePassword(m, conn);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int changeName(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().changeName(m, conn);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteMember(Member m) {
		Connection conn = getConnection();
		deleteScore(m);
		int result = new MemberDao().deleteMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public void deleteScore(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteScore(m.getId(), conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}
	
	
}
