package com.kh.example.exception3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member m) {
		if(!map.containsKey(id)) {
			map.put(id, m);
			return true;
		}
		return false;
	}
	
	public String logIn(String id, String password) {
		if(map.containsKey(id)) {
			Member m = map.get(id);
			if (m.getPassword().equals(password)) {
				return m.getName();
			}
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		Member m = map.get(id);
		if(m!=null&&m.getPassword().equals(oldPw)) {
			m.setPassword(newPw);
			return true;
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
		Member m = map.get(id);
		if(map.containsKey(id) && m != null) {
			m.setName(newName);
		}
	}
	
	 public TreeMap<String, String> sameName(String name) {
		 Set entryset = map.entrySet();
		 TreeMap<String, String> tmap = new TreeMap<String, String>();
		 for(Object entry : entryset) {
				Entry e = (Entry)entry;
				Member m = (Member) e.getValue();
				if(m.getName().equals(name)) {
					tmap.put((String) e.getKey(), name);
				}
			}
		 return tmap;
	 }

}
