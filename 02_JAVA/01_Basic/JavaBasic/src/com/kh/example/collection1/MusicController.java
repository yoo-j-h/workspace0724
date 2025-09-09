package com.kh.example.collection1;

import java.util.ArrayList;
import java.util.List;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
		if(music ==null) return 0;
		list.add(music);
		return 1;
		
		/*
		 * int result = 0; int before = list.size(); list.add(music); int after =
		 * list.size(); if((after-before) == 1) result = 1; return result;
		 */
	}
	public int addAtZero(Music music) {
		if(music ==null) return 0;
		list.add(0, music);
		return 1;
		/*
		 * int result = 0; int before = list.size(); list.add(0,music); int after =
		 * list.size(); if((after-before) == 1) result = 1; return result;
		 */
	}
	public List<Music> printAll(){
		return list;
	}
	public Music searchMusic(String title) {
		for(Music c : list) {
			if(c.getTitle().equals(title)){
				return c;
			}
		}
		return null;
	}
	public Music removeMusic(String title) {
		Music sMusic = searchMusic(title);
		if(sMusic==null) {
			return null;
		}else {
			list.remove(sMusic);
			return sMusic;
		}
	}
	public Music setMusic(String title, Music music) {
		int index = 0;
		Music sMusic = null;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)){
				index = i;
				sMusic = list.get(i);
			}
		}
		if(sMusic==null) {
			return null;
		}else {
			list.set(index, music);
			return sMusic;
		}
	}
	
	
}
