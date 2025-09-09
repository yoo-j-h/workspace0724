package com.kh.example.gearrent;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Device {
	private String id;
	private String name;
	private String category;
	private int borrowCount;
	private Set<String> tags;
	
	public Device() {
		super();
	}

	public Device(String id, String name, String category, Set<String> tags) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.tags = tags == null? new HashSet<String>(): new HashSet<String>(tags);
	}
	
	public abstract int getBorrowLimitDays();
	public abstract int calcLateFee(int overdueDays);
	
	public void increaseBorrowCount() {
		borrowCount++;
	}
	public boolean hasTag(String tag) {
		return tags.contains(tag.toLowerCase());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBorrowCount() {
		return borrowCount;
	}

	public void setBorrowCount(int borrowCount) {
		this.borrowCount = borrowCount;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Device) {
			Device d = (Device)obj;
			if(this.id.equals(d.id)){
				return true;
			}
		}
			
		return false;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", category=" + category + ", borrowCount=" + borrowCount
				+ ", tags=" + tags + "]";
	}
	
	
}
