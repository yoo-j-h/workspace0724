package com.kh.jdbc.model.vo;

import com.kh.jdbc.view.MainMenu;

public class DiceGame extends Game{

	public DiceGame() {
		super(3, "주사위 게임", 20);
	}

	@Override
	public int play(String action) {
		int dice = 0;
		int result = 0;
		switch(action) {
		case "1": dice = 1; break;
		case "2": dice = 2; break;
		case "3": dice = 3; break;
		case "4": dice = 4; break;
		case "5": dice = 5; break;
		case "6": dice = 6; break;
		case "끝": dice = 9; break;
		}
		int opp = (int)(Math.random()*6)+1;
		
		if(dice == 0) result=0;
		else if(dice == 9) result = 9;
		else if(dice == opp)result = 1;
		else result = 3;
		new MainMenu().oppResult(opp, this);
		return result;
	}
}
