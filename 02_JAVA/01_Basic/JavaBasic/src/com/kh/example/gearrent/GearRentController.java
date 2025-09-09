package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;



public class GearRentController {
	private HashMap<String, Device> catalog = new HashMap<>();
	private HashMap<String, Member> members = new HashMap<>();
	private HashMap<String, Loan> activeLoans = new HashMap<>();
	
	public boolean addDevice(Device device) {
		if(!catalog.containsKey(device.getId())) {
			catalog.put(device.getId(), device);
			return true;
		}
		return false;
	}
	
	public boolean addMember(Member member) {
		if(!members.containsKey(member.getId())) {
			members.put(member.getId(), member);
			return true;
		}
		return false;
	}
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		Device d = catalog.get(itemId);
		Loan l= new Loan(itemId, memberId, today, today.plusDays(d.getBorrowLimitDays()));
		activeLoans.put(itemId, l);
		d.increaseBorrowCount();
		return l;
	}
	public int returnItem(String itemId, LocalDate today) {
		Loan l = activeLoans.get(itemId);
		Device d = catalog.get(itemId);
		l.setReturnedDate(today);
		int lateFee = d.calcLateFee(l.overdueDays(today));
		activeLoans.remove(itemId);
		return lateFee;
	}
	public ArrayList<Device> findByTag(String tag){
		Set<Entry<String, Device>> entrySet = catalog.entrySet();
		ArrayList<Device> tagList = new ArrayList<Device>();
		if(tag == null) {
			return tagList;
		}
		for(Object entry : entrySet) {
			Entry<String, Device> e = (Entry)entry;
			if(e.getValue().hasTag(tag)) {
				tagList.add(e.getValue());
			}
		}
		return tagList;
	}
	
	public ArrayList<Device> findByKeyword(String keyword){
		//Set<Entry<String, Device>> entrySet = catalog.entrySet();
		ArrayList<Device> list = new ArrayList<Device>();
		String lowkeyword = keyword.toLowerCase();
		if(lowkeyword == null||lowkeyword=="") {
			return list;
		}
		for(Device d : catalog.values()) {
			String name = d.getName().toLowerCase();
			String cat = d.getCategory().toLowerCase();
			if(name.contains(lowkeyword) ||cat.contains(lowkeyword)) {
				list.add(d);
			}
		}
		/*
		 * for(Object entry : entrySet) { Entry<String, Device> e = (Entry)entry; Device
		 * d = e.getValue(); if(d.getName()==lowkeyword||d.getCategory()==lowkeyword) {
		 * list.add(e.getValue()); } }
		 */
		return list;
	}
	
	public Collection<Device> getAllDevices(){
		return Collections.unmodifiableCollection(catalog.values());
	}
	
	public Collection<Loan> getActiveLoans(){
		return Collections.unmodifiableCollection( activeLoans.values());
	}
}
