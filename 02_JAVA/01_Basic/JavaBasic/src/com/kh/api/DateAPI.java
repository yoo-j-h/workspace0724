package com.kh.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAPI {
	public void method() {
		Date date1 = new Date();//매개변수 없이 실행시 실행시점의 날짜
		System.out.println(date1.toString());
		
		//내가 원하는 날짜(2026 3월 3일)로 세팅
		//1) 생성자를 통해서 생성
		//new Date(년(생성년도 - 1900), 월(생성월 - 1), 일)
		Date date2 = new Date(2026-1900, 3-1,3);
		System.out.println(date2);
		
		//2) 기본생선자로 생성 후 setter로 변경
		date1.setYear(2026-1900);
		date1.setMonth(2);
		date1.setDate(3);
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		System.out.println(1900+date1.getYear()+"년");
		
		//LocalDateTime
		//Java8에 도입된 클래스
		//날짜와 시간을 함께 표현하는 객체
		//시차/타임존을 고려하지 않음 - > 순수하게 지금 내 날짜와 시간정보를 다룸
		
		//1. 현재 날짜와 시간
		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재 시간 : " + now);
		
		//2.특정 날짜와 시간 생성
		LocalDateTime date3 = LocalDateTime.of(2026, 3, 3, 0, 0, 0);
		System.out.println("특정 날짜와 시간 : "+date3 );
		
		//3.날짜/시간 연산
		System.out.println(date3.plusDays(4758));
		System.out.println(date3.minusHours(5));
		
		//4. 날짜와 시간을 분리
		System.out.println("날짜 부분 : " + date3.toLocalDate());
		System.out.println("시간 부분 : " + date3.toLocalTime());
		
		//5. 포멧팅
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
		String str = date3.format(formatter);
		System.out.println(str);
		
	}
}
