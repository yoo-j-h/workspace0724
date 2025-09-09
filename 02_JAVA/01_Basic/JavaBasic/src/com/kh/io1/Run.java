package com.kh.io1;

import java.io.File;
import java.io.IOException;

public class Run {
	/*
	 * 간단하게 파일/폴더 생성, 정보확인
	 * java.io.File class를 이용
	 * -파일/폴더 경로를 표현하는 객체
	 * 
	 * 상대경로 : 지금 내 위치를 기반으로 다른경로를 탐색
	 * 절대경로 : window -> C:~,D:~ Unix -> /root/~ 최상위 루트를 기준으로 다른 경로를 탐색
	 * 
	 * */
	public static void main(String[] args) {
		//1. 경로지정없이 파일 객체를 생성(상대경로 - 현재 작업 폴더 기준)
		File f1 = new File("test.txt");//파일 객체를하나 생성(실제 파일x)->코드로 존재하는 파일객체
		//2. 실제 존재하는 경로에 파일 생성(절대 경로)
		File f2 = new File("D:\\test.txt");
		//3. 존재하지 않는 경로에 파일 생성
		File f3 = new File("D:\\tmp\\test.txt");
		
		try {
			f1.createNewFile();
			f2.createNewFile();
			//f3.createNewFile(); 존재하지않는 경로로 생성시 예외 발생 -> IOException
			
			//폴더 먼저 생성
			File tmpFolder = new File("D:\\\\tmp");
			tmpFolder.mkdir();
			f3.createNewFile();
			
			File f4 = new File("ttt.txt");
			
			//exists() : 파일 존재유무확인
			System.out.println("exists : " + f4.exists());
			System.out.println("exists : " + f1.exists());
			
			//isFile() : 파일유무 확인
			System.out.println("exists : " + f1.isFile());
			System.out.println("exists : " + tmpFolder.isFile());
			
			System.out.println("파일명 : "+f1.getName());
			System.out.println("파일경로 : "+f1.getAbsolutePath());
			System.out.println("파일용량: "+f1.length());
			System.out.println("파일상위폴더: "+f1.getParent());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
