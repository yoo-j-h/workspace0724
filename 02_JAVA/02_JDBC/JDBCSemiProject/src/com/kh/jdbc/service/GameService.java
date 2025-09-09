package com.kh.jdbc.service;

import static com.kh.jdbc.common.JDBCTemplate.close;
import static com.kh.jdbc.common.JDBCTemplate.commit;
import static com.kh.jdbc.common.JDBCTemplate.getConnection;
import static com.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jdbc.model.dao.GameDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.model.vo.Score;

public class GameService {

	public void gamePlay(int gameresult) {
	
	}

	public Score updateScore(Score score, double point) {
		Connection conn = getConnection();
		Score s  = new GameDao().getScore(score,conn);
		double d = s.getScore();
		d += point;
		s.setScore(d);
		int result = new GameDao().updateScore(s,conn);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return s;
		
	}

	public ArrayList<Score> getScore(Member m) {
		Connection conn = getConnection();
		ArrayList<Score> list = new GameDao().getScore(m,conn);
		close(conn);
		return list;
	}

	public ArrayList<Score> getScore() {
		Connection conn = getConnection();
		ArrayList<Score> list = new GameDao().getScore(conn);
		close(conn);
		return list;
	}
	
}