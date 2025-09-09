package com.kh.jdbc.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.model.vo.MyScore;
import com.kh.jdbc.model.vo.Score;



public class GameDao {
private Properties prop = new Properties();

	public GameDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int updateScore(Score score, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateScore");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, score.getScore());
			pstmt.setString(2, score.getUserId());
			pstmt.setInt(3, score.getGameCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public ArrayList<Score> getScore(Member m, Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Score s = null;
		ArrayList<Score> list = new ArrayList<Score>();
		String sql = prop.getProperty("getScoreToId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			
			rset = pstmt.executeQuery(); 
				while(rset.next()) {
				s = new MyScore();
				s.setUserId(rset.getString("USER_ID"));
				s.setUserName(rset.getString("USER_NAME"));
				s.setGameCode(rset.getInt("GAME_CODE"));
				s.setScore(rset.getDouble("SCORE"));
				list.add(s);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return list;
	}
	public ArrayList<Score> getScore(Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Score s = null;
		String sql = prop.getProperty("getScore");
		ArrayList<Score> list = new ArrayList<Score>();
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				s = new Score();
				s.setUserId(rset.getString("USER_ID"));
				s.setUserName(rset.getString("USER_NAME"));
				s.setGameCode(rset.getInt("GAME_CODE"));
				s.setScore(rset.getDouble("SCORE"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return list;
	}

	public Score getScore(Score score, Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Score s = null;
		String sql = prop.getProperty("getScoreToIdCode");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, score.getUserId());
			pstmt.setInt(2, score.getGameCode());
			
			rset = pstmt.executeQuery(); 
			if(rset.isBeforeFirst()) {	
				while(rset.next()) {
				s = new Score();
				s.setUserId(rset.getString("USER_ID"));
				s.setUserName(rset.getString("USER_NAME"));
				s.setGameCode(rset.getInt("GAME_CODE"));
				s.setScore(rset.getDouble("SCORE"));
				}
			}else {
				s = new Score(score.getUserId(),score.getUserName(),score.getGameCode());
				insertScore(s,conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return s;
		
	}
	
	public int insertScore(Score s, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertScore");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUserId());
			pstmt.setString(2, s.getUserName());
			pstmt.setInt(3, s.getGameCode());
			pstmt.setDouble(4, s.getScore());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

	


	
	
	


}
