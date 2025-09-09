package com.practice.array2D;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] board = new boolean[100][100];
		int count = sc.nextInt();
		
		int extent = 0;
		for(int i=0; i<count; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					if(board[row+j][col+k]==false) {
						board[row+j][col+k]=true;
					}
				}
			}
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(board[i][j]==true) {
					extent += 1;
				}
			}
		}
		System.out.println(extent);
		
		sc.close();
	}

}
