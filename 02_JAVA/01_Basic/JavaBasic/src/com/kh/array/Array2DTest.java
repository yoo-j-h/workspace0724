package com.kh.array;

import java.util.Scanner;

public class Array2DTest {

	public static void main(String[] args) {
		//사용자에게 행(m)과 열(n)을 압력받아
		//해당 행과 열의 빙고판을 만들어라.
		//다음 행과 열의 들어갈 문자를 각각 모두 입력받아 저장한뒤
		//출력해라.
		/*
		 * 행 : 2
		 * 열 : 3
		 * 
		 * 1행1열 : 바나나
		 * 1행2열 : 배
		 * ...
		 * 2행3열 : 귤
		 * */
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("행을 입력 : ");
		int m = sc.nextInt();
		System.out.print("열을 입력 : ");
		int n = sc.nextInt();
		String[][] bingo = new String[m][n];
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				System.out.printf("%d행 %d열 : ", j+1, i+1);
				bingo[j][i] = sc.next();
			}
		}
		
		System.out.println("완성된 빙고");
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				System.out.print(bingo[j][i]+" ");
			}
			System.out.println();
		}
		*/
		
		
		//사용자에게 좌석의 행과 열을 입력받아 2차원배열을 생성
		//각 좌석에 들어갈 관객의 이름을 입력받아 저장한뒤
		//모두 입력받았으면 좌석표를 출력
		//행(줄)의 수 : 
		//열(좌석)의 수 : 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 수 : ");
		int m = sc.nextInt();
		System.out.print("열의 수 : ");
		int n = sc.nextInt();
		String[][] bord = new String[m][n];
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++){
				System.out.printf("%d행 %d열 : ",j+1,i+1);
				bord[j][i] = sc.next();
			}
		}
		System.out.println("=====좌석표=====");
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				System.out.print(bord[j][i]+" ");
			}
			System.out.println();
		}
		
	}
}
