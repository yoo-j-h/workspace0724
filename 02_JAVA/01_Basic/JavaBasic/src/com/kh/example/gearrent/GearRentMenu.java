package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class GearRentMenu {
	private GearRentController gc = new GearRentController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.print("========== KH 장비 대여 관리 ========== \r\n"
					+ "=====***** 메인 메뉴 *****===== \r\n"
					+ "1) 장비등록 \r\n"
					+ "2) 회원등록 \r\n"
					+ "3) 대여 \r\n"
					+ "4) 반납 \r\n"
					+ "5) 태그검색 \r\n"
					+ "6) 키워드검색 \r\n"
					+ "7) 전체장비 \r\n"
					+ "8) 대여중목록 \r\n"
					+ "9. 종료 \r\n"
					+ "메뉴 번호 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch (sel) {
			case 1: 
				addDevice();
				break;
			case 2: 
				addMember();
				break;
			case 3: 
				borrow();
				break;
			case 4: 
				returnItem();
				break;
			case 5: 
				findByTag();
				break;
			case 6: 
				findByKeyword();
				break;
			case 7: 
				printAllDevices();
				break;
			case 8: 
				printActiveLoans();
				break;
			case 9: 
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
		}
	}
	public void addDevice() {
		Device d = null;
		while(true) {
			System.out.print("유형(1:Camera, 2:Laptop): ");
			int sel = sc.nextInt();
			sc.nextLine();
			System.out.print("id : ");
			String id = sc.nextLine();
			System.out.print("name : ");
			String name = sc.nextLine().toLowerCase();
			System.out.print("category : ");
			String category = sc.nextLine().toLowerCase();
			System.out.print("tags(쉼표로 구분) : ");
			String tags = sc.nextLine().toLowerCase();
			String[] arr = tags.split(",");
			HashSet<String> tagSet = new HashSet<>();
			for(String st : arr) {
				tagSet.add(st);
			}
			if(sel == 1) {
				d = new Camera(id, name, category, tagSet);
				break;
			}else if(sel==2) {
				d = new Laptop(id, name, category, tagSet);
				break;
			}else {
				System.out.println("잘못입력");
			}
		}
		boolean isTrue = gc.addDevice(d);
		if(isTrue) {
			System.out.println("등록 완료");
		}else {
			System.out.println("중복된 ID입니다. 다시 입력해주세요.");
		}
	}
	public void addMember() {
		System.out.print("member id : ");
		String id = sc.nextLine();
		System.out.print("name : ");
		String name = sc.nextLine().toLowerCase();
		Member m = new Member(id, name);
		boolean isTrue = gc.addMember(m);
		if(isTrue) {
			System.out.println("등록 완료");
		}else {
			System.out.println("중복된 ID입니다. 다시 입력해주세요.");
		}
	}
	public void borrow() {
		System.out.print("memberid : ");
		String memberid = sc.nextLine();
		System.out.print("itemid : ");
		String itemid = sc.nextLine();
		System.out.print("대여일(YYYY-MM-DD): ");
		String date = sc.nextLine();
	
		String[] arr = date.split("-");
		LocalDate date1 = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		Loan l = gc.borrow(memberid, itemid, date1);
		System.out.println("대여 완료 : "+l);
		System.out.println("반납 예정일 : "+l.getDueDate());
	}
	public void returnItem() {
		System.out.print("memberid : ");
		String memberid = sc.nextLine();
		System.out.print("itemid : ");
		String itemid = sc.nextLine();
		System.out.println("반납일(YYYY-MM-DD) : ");
		String returndate = sc.nextLine();
		String[] arr = returndate.split("-");
		LocalDate date1 = LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		int lateFee = gc.returnItem(itemid, date1);
		if(lateFee == 0) {
			System.out.println("반납완료");
		}else {
			System.out.println("연체료 : "+lateFee);
		}
		
	}
	public void findByTag() {
		System.out.print("테그 : ");
		String key = sc.nextLine();
		ArrayList<Device> list = gc.findByTag(key);
		for(Object h : list) {
			System.out.println(h);
		}
	}
	public void findByKeyword() {
		System.out.print("키워드 : ");
		String key = sc.nextLine();
		ArrayList<Device> list = gc.findByKeyword(key);
		for(Object h : list) {
			System.out.println(h);
		}
	}
	public void printAllDevices() {
		Collection<Device> c = gc.getAllDevices();
		for(Object h : c) {
			System.out.println(h);
		}
	}
	public void  printActiveLoans() {
		Collection<Loan> c = gc.getActiveLoans();
		for(Object h : c) {
			System.out.println(h);
		}
		
	}
}
