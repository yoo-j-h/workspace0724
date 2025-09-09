package com.kh.practice.controll;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주사위 값 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int price = 0;
		if (num1 == num2 && num2 == num3) {
			price = 10000 + num1 * 1000;
		}else if(num1 != num2 && num2 != num3 && num1 != num3) {
			if (num1>num2) {
				if(num1>num3) {
					price = num1 * 100;
				}else{
					price = num3 * 100;
				}
			}else{
				if(num2>num3) {
					price = num2 * 100;
				}else{
					price = num3 * 100;
				}
			}
		}else if(num1 == num2) {
			price = 1000 + num1 * 100;
		}else if(num2 == num3) {
			price = 1000 + num2 * 100;
		}else if(num1 == num3) {
			price = 1000 + num1 * 100;
		}
		System.out.println("상금은 : "+price);
		sc.close();
	}
	
}
