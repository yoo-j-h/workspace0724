package com.kh.jdbc.controller;

import java.util.ArrayList;
import java.util.Collections;


import com.kh.jdbc.model.vo.CoinGame;
import com.kh.jdbc.model.vo.DiceGame;
import com.kh.jdbc.model.vo.Game;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.model.vo.MyScore;
import com.kh.jdbc.model.vo.RPSGame;
import com.kh.jdbc.model.vo.Score;
import com.kh.jdbc.model.vo.ScoreComparator;
import com.kh.jdbc.service.GameService;
import com.kh.jdbc.view.MainMenu;

public class GameController {

	private GameService gs = new GameService();
	private Game[] gList = new Game[3];
	{
		gList[0] = new RPSGame();
		gList[1] = new CoinGame();
		gList[2] = new DiceGame();
	}

	public GameController() {
		super();
	}
	
	public Game[] getgList() {
		return gList;
	}

	public int gamePlay(int code, Member m) {
		Score score = new Score(m.getId(),m.getName(), code);
		int result = 0;
		String action = null;
		if(code == 9)return 9;
		Game game = gList[code-1];
		if(game != null) {
			while(true) {
				action = new MainMenu().gamedisplay(game);
				int gameresult = game.play(action);
				//1=승 2=무 3=패 0=오류
				switch(gameresult) {
				case 1: 
					new MainMenu().displayNoData("승리하였습니다.");
					updateScore(score, game.getPoint());
					break;
				case 2: 
					new MainMenu().displayNoData("무승부입니다"); 
					break;
				case 3:
					new MainMenu().displayNoData("패배하였습니다."); 
					updateScore(score, -game.getPoint()*0.5);
					break;
				case 0: 
					new MainMenu().displayNoData("잘못입력하셨습니다."); 
					break;
				case 9: 
					new MainMenu().displayNoData("게임을 종료합니다."); 
					return result;
				}
			}
		}
		
		return result;
	}

	private void updateScore(Score score, double point) {
		Score s = gs.updateScore(score, point);
		new MainMenu().displayNoData("점수는 : "+s.getScore());
	}

	

	
	public void getScore(Member m) {
		ArrayList<Score> list = gs.getScore(m);
		ArrayList<MyScore> mlist = new ArrayList<MyScore>();
		for(Score s : list) {
				MyScore ms = (MyScore)s;
				mlist.add(ms);
		}
		if(mlist.isEmpty()) {
			new MainMenu().displayNoData("플레이한 게임이 없습니다.");
		}else {
			new MainMenu().displayList(mlist, "키워드 검색 목록");
		}
	}



	public void getRank() {
		ArrayList<Score> list = gs.getScore();
		ArrayList<Score>[] arr = new ArrayList[gList.length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<Score>();
		}
		for(Score s : list) {
			for(int i=0; i<gList.length; i++) {
				if(s.getGameCode()-1 == i) {
					arr[i].add(s);
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			Collections.sort(arr[i],new ScoreComparator());
			if(arr[i].size()>3)arr[i] = new ArrayList<Score>(arr[i].subList(0, 3));
			if(arr[i].isEmpty()) {
				new MainMenu().displayNoData("======"+gList[i].getTitle()+"======");
				new MainMenu().displayNoData("플레이한 플레이어가 없습니다.");
			}else {
				new MainMenu().displayList(arr[i], gList[i].getTitle());
			}
		}
		
	}
	
	
	

	
}
