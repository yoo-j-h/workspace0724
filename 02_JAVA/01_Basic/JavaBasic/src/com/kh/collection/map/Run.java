package com.kh.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Run {
	/*
	 * Map
	 * Key와 value를 쌍으로 저장하는 자료구조
	 * key는 중복 불가, value는 중복가능
	 * HashMap(가장 보편적이고 속도향상), LinkedHashMap(입력순서 보장), TreeMap(정렬된 key순서유지)
	 * */
	public static void main(String[] args) {
		Map<Integer, Human> hMap = new HashMap<>();
		
		//1. put() map에 key, value쌍으로 값을 추가
		hMap.put(10, new Human("최지원", 20));
		hMap.put(20, new Human("최지투", 30));
		hMap.put(30, new Human("최지삼", 40));
		hMap.put(40, new Human("최지사", 50));
		hMap.put(50, new Human("최지사", 50));
		hMap.put(40, new Human("최지오", 50));//동일한 key사용 시 덮어씀
		System.out.println(hMap);//저장되는 순서 유지 안됨.
		
		//2. get(key) 해당 key의 가지는 value를 반환
		System.out.println(hMap.get(30));
		
		//3. size() 담겨있는 객체 수
		System.out.println("size : "+hMap.size());
		
		//4. remove(key) 해당 key의 값을 찾아서 쌍으로 제거
		hMap.remove(40);
		System.out.println(hMap);
		
		//Map에 전체요소를 탐색하는 방법
		//Iterator 이용불가
		//for each 역시 이용불가
		
		//다른 자료구조로 변경 후 반복
		//1. key를 모아서 set자료구조 형태로 반환
		Set keySet = hMap.keySet();
		System.out.println(keySet);
		for(Object key : keySet) {
			System.out.println("키 : "+ key+"값 : "+hMap.get(key));
		}
		
		//2. entrySet을 이용한 전체탐색
		//Map은 key와  value를 쌍으로 저장하기 때문에 단순하게 keySet(), value()만으로는 
		//한번에  key와 값을 가져올 수 없음.
		//Set<Map.Entry<k,v>>
		Set entrySet = hMap.entrySet();
		for(Object entry : entrySet) {
			Entry e = (Entry)entry;
			System.out.println(e.getKey()+ " " + e.getValue());
		}
		
	}

}
