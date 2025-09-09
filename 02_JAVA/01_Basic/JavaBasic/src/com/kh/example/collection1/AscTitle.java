package com.kh.example.collection1;

import java.util.Comparator;

public class AscTitle implements Comparator<Music>{

	@Override
	public int compare(Music o1, Music o2) {
		int result = 0;
		if(o1.getTitle().compareTo(o2.getTitle())>0) {
			result = 1;
		}else if(o1.getTitle().compareTo(o2.getTitle())==0) {
			if(o1.getSinger().compareTo(o2.getSinger())>0) {
				result = 1;
			}else if(o1.getSinger().compareTo(o2.getSinger())<0){
				result = -1;
			}else {
				result = 0;
			}
		}else {
			result = -1;
		}
		return result;
	}
	
}
