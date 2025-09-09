package com.kh.inherit;

public class Desktop extends Product{
	private boolean allinONe;
	
	public Desktop() {
		//상속관꼐에서 부모생선자를 명시하지 않아도
		//부모의 기본생성자가 호출
	}

	public boolean isAllinONe() {
		return allinONe;
	}

	public void setAllinONe(boolean allinONe) {
		this.allinONe = allinONe;
	}
	
	
}
