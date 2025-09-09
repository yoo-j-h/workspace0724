package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);}
		/*
	 * if(!lottery.contains(l)) { lottery.add(l); return true; } return false; }
	 */
	
	public boolean deleteObject(Lottery l) {
		boolean isremove = lottery.remove(l);
		if(win !=null && isremove) {
			win.remove(l);
		}
		return isremove;
		/*
		 * if(lottery.contains(l)) { lottery.remove(l); if(win != null) { win.remove(l);
		 * return true; } return true; } return false;
		 */
	}
	public HashSet<Lottery> winObject(){
		
		if (win.size()<4){
			Random rand =new Random();
			ArrayList<Lottery> list = new ArrayList<>();
			list.addAll(lottery);
			while(win.size()< 4&& win.size() != lottery.size()) {
				int index = rand.nextInt(list.size());
				win.add(list.get(index));
			}
		}
		return win;
		/*
		 * List<Lottery> list = new ArrayList<>(); list.addAll(lottery);
		 * while(win.size()==4) { int index = (int)(Math.random()*(list.size()+1));
		 * if(!win.contains(list.get(index))) { win.add(list.get(index)); } } return
		 * win;
		 */
 	}
	public boolean  searchWinner(Lottery l) {
		
		return win.contains(l);
		/*
		 * if(win.contains(l)) { return true; }else { return false; }
		 */
	}
	
}
