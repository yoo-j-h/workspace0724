package com.kh.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Run {
	/*
	 * set
	 * 순서가 없고, 중복을 허용하지 않는 자료구조
	 * index 개념이 없어서 위치기반 접근(get(index))이 불가
	 * - HashSet : 일반적인 해시알고리즘이 적용된 set
	 * -LinkedHashSet : HashSet + 순서유지
	 * - TreeSet : 자동 정렬 기능 제공
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		//생성
		Set<Human> set = new HashSet<>();
		Set<Human> set1 = new HashSet<>();
		System.out.println(set);
		//데이터 추가
		set.add(new Human("최지원", 20));
		set.add(new Human("최지원", 20));
		set.add(new Human("최지투", 20));
		set.add(new Human("최지삼", 25));
		System.out.println(set);
		//set에 저장해서 사용하는 객체(Human)은  equlas와 hashCode를 오버라이딩 해줘야함
		//set은 hashcode()로 분류 후  equlas()로 비교해서 중복값을 검사함
		
		set.add(new Human("최지투", 20));
		set.add(new Human("최지삼", 25));
		System.out.println(set); //동일객체는 추가가 되지않음.
		
		Human h1 = new Human("최지투", 20);
		Human h2 = new Human("최지투", 20);
		//동일객체 : h1.hashCode() == h2.hashCode() && h1.equlas(h2)
		//equlas와 hashCode를 오버라이딩 하지 않으면 Object의 것을 사용
		//Object 의 equlas = 주소값 비교
		//Object의 hashCode = 주소값을 가지고 10진수 형태로 해시값을 구한것
		
		//contains() 요소에 포함여부 확인
		System.out.println("최지투가 존재? "+set.contains(h2));
		
		//remove(E e) 요소를 총해 요소제거
		set.remove(h2);
		System.out.println(set1);
		set1.remove(h2);
		System.out.println(set1);
		System.out.println("삭제 후 : "+set);
		
		System.out.println("size : "+ set.size());
		
		//set의 모든 요소에 순차적으로 접근하는 방법
		//set은  index값이 없기 때문에 get()을 사용할 수 없음
		
		//1. for each
		for(Human h :set) {
			System.out.println(h);
		}
		
		//2. ArrayList에 담아서 반복 -> addAll(Collection e)
		ArrayList list = new ArrayList();
		list.addAll(set);
		for(int i=0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//3. Iterator(반복자 인터페이스)를 활용
		//컬렉션에 저장된 요소를 순차적으로 접근하기 위한 인터페이스
		//순서가 없는 Set같은 자료구조를 탐색할 때 반드시 필요
		//hashNext() : 다음 읽을 요소가 있으면  true, 없으면 false
		//next() : 다음 요소를 반환
		Iterator<Human> it = set.iterator();
		Scanner sc = new  Scanner(System.in);
		System.out.println("이름 입력");
		String name = sc.nextLine().toLowerCase();
		System.out.println(name);
	}

}
