package com.kh.jdbc.service;

import java.sql.Connection;
import java.util.List;

//static으로 import시 static메서드를 직접 가져와서 사용할 수 있음.
import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

/*
 * Service
 * 트랜잭션 관리와같은 비즈니스 로직을 처리하는 계층, Dao와 Contoller의 중간역할
 */
public class MemberService {
	private MemberDao md;
	

	public MemberService() {
		super();
		this.md = new MemberDao();
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = md.insertMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public List<Member> selectMemberList(){
		Connection conn = getConnection();
		
		List<Member> list = md.selectMemberList(conn);
		close(conn);
		
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = md.updateMember(m, conn);
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
		
		int result = md.deleteMember(m,conn);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public List<Member> searchMember(Member m) {
		Connection conn = getConnection();
		List<Member> list = md.searchMemberList(m,conn);
		close(conn);
		
		return list;
	}
}
