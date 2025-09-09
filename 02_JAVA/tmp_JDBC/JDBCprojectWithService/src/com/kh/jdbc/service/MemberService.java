package com.kh.jdbc.service;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.util.List;

import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.dao.MemberDao;
/*
 * Service
 * 트래잭션 관리와 같은 비즈니스 로직을 처리하는 계층, Dao와 Contoller 중간역
 * */
public class MemberService{
	private MemberDao md;
	
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = md.insertMember(m,conn);
		
		if(result>0) {
			commit(conn);
		}
		return 0;
	}
	public List<Member> selectMemberList(){
		Connection conn = getConnection();
		md.selectMemberList(conn);
		return null;
	}
	public int updateMember(Member m) {
		return 0;
	}
	public int deleteMember(Member m) {
		return 0;
	}
	public MemberService() {
		super();
		this.md = new MemberDao();
	}
}