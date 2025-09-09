package com.kh.jdbc.model.vo;

import java.util.Objects;


public class Score {
	private String userId;
	private String userName;
	private Integer gameCode;
	private Double score;
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public void setGameCode(int gameCode) {
		this.gameCode = gameCode;
	}



	public void setScore(double score) {
		this.score = score;
	}



	public Score() {
		super();
	}



	public Score(String userId, String userName, int gameCode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gameCode = gameCode;
		this.score =  0.0;
	}
	
	

	public Score(String userId, String userName, int gameCode, double score) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gameCode = gameCode;
		this.score = score;
	}

	



	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public int getGameCode() {
		return gameCode;
	}
	public double getScore() {
		return score;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userId,gameCode);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Score) {
			Score s = (Score)obj;
			return this.userId.equals(s.userId)&&this.gameCode==s.gameCode;
		}
		return false;
	}



	@Override
	public String toString() {
		return userName +"(" + userId + ") " +  ": 점수=" + score;
	}




	
	
	


	
	





	
	
}
