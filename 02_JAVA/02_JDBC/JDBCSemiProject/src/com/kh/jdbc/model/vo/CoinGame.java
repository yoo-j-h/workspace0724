package com.kh.jdbc.model.vo;

import com.kh.jdbc.view.MainMenu;

public class CoinGame extends Game{
	public CoinGame() {
		super(2, "동전 던지기", 5);
	}

	@Override
	public int play(String action) {
		int coin = 0;
		int result = 0;
		switch(action) {
		case "앞": coin = 1; break;
		case "뒤": coin = 2; break;
		case "끝": coin = 9; break;
		}
		int opp = (int)(Math.random()*2)+1;
		
		if(coin == 0) result=0;
		else if(coin == 9) result = 9;
		else if(coin == opp)result = 1;
		else result = 3;
		new MainMenu().oppResult(opp, this);
		return result;
	}
	
}
