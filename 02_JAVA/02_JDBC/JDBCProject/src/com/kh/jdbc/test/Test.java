package com.kh.jdbc.test;

import java.time.LocalDate;
import java.util.Objects;

public class Test {
	private int tno;
	private String tname;
	private LocalDate tDate;
	public Test(int tno, String tname, LocalDate tDate) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tDate = tDate;
	}
	public Test() {
		super();
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public LocalDate gettDate() {
		return tDate;
	}
	public void settDate(LocalDate tDate) {
		this.tDate = tDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(tno);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Test) {
			return ((Test)obj).getTno() == tno;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Test [tno=" + tno + ", tname=" + tname + ", tDate=" + tDate + "]";
	}
	
	
}
