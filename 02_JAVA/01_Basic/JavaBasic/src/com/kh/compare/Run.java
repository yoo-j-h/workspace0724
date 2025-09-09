package com.kh.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * -Comparable : 객체 스스로 기본 정렬 기준을 제공
 * -Comparator : 필요할 때 외부에서 정렬 기준 주입 
 * */
public class Run {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("철수", 80, 18));
		list.add(new Student("민수", 90, 15));
		list.add(new Student("지수", 75, 17));
		list.add(new Student("지수", 75, 16));
		list.add(new Student("영수", 100, 19));

		System.out.println("최초값");
		System.out.println(list);
		
		//Comparable : 학생에 정의된 기준으로 정렬(Student클래스의 compareTo 기준)
		Collections.sort(list);
		System.out.println("정렬후");
		System.out.println(list);
		
		//Comparator : 이름만 오름차순
		Collections.sort(list, new NameAscComparator());
		System.out.println("Comparator : 이름만 오름차순");
		System.out.println(list);
		
		//Comparator : 점수만 내림차순
		Collections.sort(list, new ScoreDescComparator());
		System.out.println("Comparator : 점수만 내림차순");
		System.out.println(list);
		
		//Comparator : 복합기준
		Collections.sort(list, new ScoreDescAndNameAscComparator());
		System.out.println("Comparator : 복합기준");
		System.out.println(list);
	}

}
