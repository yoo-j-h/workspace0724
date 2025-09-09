package com.kh.example.collection1;

import java.util.Objects;

public class Music implements Comparable<Music>{
	private String title;
	private String singer;
	public Music() {
		super();
	}
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(title, singer);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) {
			Music m = (Music)obj;
			return this.title.equals(m.title)&& this.singer.equals(m.singer);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return title + " - " + singer;
	}
	@Override
	public int compareTo(Music o) {
		return this.title.compareTo(o.title);
	}
	
	
}
