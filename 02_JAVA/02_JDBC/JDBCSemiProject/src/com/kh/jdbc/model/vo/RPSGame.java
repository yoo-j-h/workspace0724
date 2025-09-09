package com.kh.jdbc.model.vo;

import com.kh.jdbc.view.MainMenu;

public class RPSGame extends Game{
	public RPSGame() {
		super(1, "가위,바위,보", 10);
	}


	@Override
	public int play(String action) {
		int rps = 0;
		int result = 0;
		switch(action) {
		case "가위": rps = 1; break;
		case "바위": rps = 2; break;
		case "보": rps = 3; break;
		case "끝": rps = 9; break;
		}
		int opp = (int)(Math.random()*3)+1;
		
		//1=승 2=무 3=패 0=오류 9=end
		if(rps == 0) result=0;
		else if(rps == 9) result = 9;
		else if(rps == opp)result = 2;
		else if(rps==1 && opp==3 || rps==2 && opp==1 || rps==3 && opp==2) result=1;
		else result = 3;
		new MainMenu().oppResult(opp,this);
		return result;
	}

	
}
