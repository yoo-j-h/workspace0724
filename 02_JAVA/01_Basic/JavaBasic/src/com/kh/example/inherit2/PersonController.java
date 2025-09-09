package com.kh.example.inherit2;

public class PersonController {
	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int scount = 0;
	    int ecount = 0;
	    //int[] count = new int[2];
		for(int i=0; i<s.length; i++) {
			if(s[i] != null) {
				scount += 1;
			}
		}
		for(int i=0; i<e.length; i++) {
			if(e[i] != null) {
				ecount += 1;
			}
		}
		//int[] count = {scount, ecount};
		/*
		 * count[0] = scount; count[1] = ecount;
		 */
		return new int[]{scount, ecount};
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for(int i=0; i<s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade,  major);
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		return s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for(int i=0; i<e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary,  dept);
				break;
			}
		}
	}
	public Employee[] printEmployee() {
		return e;
	}
	
}
