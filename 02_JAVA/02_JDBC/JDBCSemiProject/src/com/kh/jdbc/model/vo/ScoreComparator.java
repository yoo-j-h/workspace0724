package com.kh.jdbc.model.vo;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score>{

	@Override
	public int compare(Score o1, Score o2) {
		 if(o1.getScore()==o2.getScore()) {
			if(o1.getUserName().equals(o2.getUserName())) {
				return o1.getUserId().compareTo(o2.getUserId());
			}else {
				return o1.getUserName().compareTo(o2.getUserName());
			}
		}else{
			return Double.compare(o2.getScore(), o1.getScore());
		}
	}

}
