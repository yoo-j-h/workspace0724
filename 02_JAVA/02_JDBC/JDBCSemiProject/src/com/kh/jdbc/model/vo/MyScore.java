package com.kh.jdbc.model.vo;

import com.kh.jdbc.controller.GameController;

public class MyScore extends Score{

	@Override
	public String toString() {
		String title = new GameController().getgList()[super.getGameCode()-1].getTitle();
		return "[" + title + ": 점수=" + super.getScore() + "]";
	}



	
}
