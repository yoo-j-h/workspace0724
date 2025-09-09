package com.kh.example.collection1;

import java.util.List;
import java.util.Scanner;

public class MusicView {
	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	public void main() {
		while(true) {
			System.out.print("=====***** 메인 메뉴 *****===== \r\n"
					+ "1. 마지막 위치에 곡 추가 \r\n"
					+ "2. 첫 위치에 곡 추가 \r\n"
					+ "3. 전체 곡 목록 출력 \r\n"
					+ "4. 특정 곡 검색  \r\n"
					+ "5. 특정 곡 삭제 \r\n"
					+ "6. 특정 곡 수정 \r\n"
					+ "7. 곡 명 오름차순 정렬 \r\n"
					+ "8. 가수 명 내림차순 정렬 \r\n"
					+ "9. 종료 \r\n"
					+ "메뉴 번호 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default :
				System.out.println("잘못입력하셨습니다.");
			}
			System.out.println();
		}
	}

	private void descSinger() {
		// TODO Auto-generated method stub
		
	}

	private void ascTitle() {
		// TODO Auto-generated method stub
		
	}

	private void setMusic() {
		System.out.print("****** 특정 곡 수정 ****** \r\n"
				+ "검색할 곡 명 : ");
		String oldtitle = sc.nextLine();
		
		System.out.print("수정할 곡 명 : ");
		String newtilte = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String newsinger = sc.nextLine();
		Music m = mc.setMusic(oldtitle, new Music(newtilte,newsinger));
		
		
	}

	private void removeMusic() {
		System.out.print("****** 특정 곡 삭제 ****** \r\n"
				+ "검색할 곡 명 : ");
		String title = sc.nextLine();
		Music m = mc.removeMusic(title);
		if(m==null) {
			System.out.println("삭제할 곡이 없습니다.");
		}else {
			System.out.println(m.toString()+"을 삭제");
		}
		
	}

	private void searchMusic() {
		System.out.print("****** 특정 곡 검색 ****** \r\n"
				+ "검색할 곡 명 : ");
		String title = sc.nextLine();
		Music m = mc.searchMusic(title);
		if(m==null) {
			System.out.println("검색한 곡이 없습니다.");
			
		}else {
			System.out.println("검색한 곡은" + m.toString());
		}
		
	}

	private void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ****** ");
		List<Music> list = mc.printAll();
		System.out.println(list);
		
	}

	private void addAtZero() {
		System.out.print("****** 처음 위치에 곡 추가 ****** \r\n"
				+ "곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addAtZero(new Music(title,singer));
		System.out.println(result == 1 ? "성공" : "실패");
		
	}

	private void addList() {
		System.out.print("****** 마지막 위치에 곡 추가 ****** \r\n"
				+ "곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		int result = mc.addList(new Music(title,singer));
		System.out.println(result == 1 ? "성공" : "실패");
		
	}

}
