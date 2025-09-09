package com.kh.jdbc.model.vo;

import java.util.Objects;

public abstract class Game {
	private int code;
	private String title;
	private int point;

	public Game(int code, String title, int point) {
		super();
		this.code = code;
		this.title = title;
		this.point = point;
	}
	
	public void setCode(int code) {
		this.code = code;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setPoint(int point) {
		this.point = point;
	}



	public int getPoint() {
		return point;
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Game) {
			Game g = (Game)obj;
			return this.code == g.code;
		}
		return false;
	}

	public abstract int play(String action);
}
