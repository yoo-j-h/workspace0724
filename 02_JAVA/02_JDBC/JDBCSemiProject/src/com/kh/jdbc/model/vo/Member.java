package com.kh.jdbc.model.vo;

import java.util.Objects;

public class Member {
	private String id;
	private String pwd;
	private String name;
	
	
	
	public Member() {
		super();
	}
	
	public Member(String id) {
		super();
		this.id = id;
	}

	public Member(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public Member(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return this.id.equals(m.getId());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
