package com.kh.example.poly1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] an = new Animal[5];
		an[0] = new Dog("누렁이", 3,"진돗개");
		an[1] = new Cat("네로", 3,"검은색");
		an[2] = new Dog("삽살이", 3,"삽살개");
		an[3] = new Dog("백구", 3,"진돗개");
		an[4] = new Cat("샬롯", 3,"흰색");
		
		for(int i=0; i<an.length; i++) {
			an[i].speak();
			if(an[i] instanceof Dog) {
				System.out.printf("이 개의 견종은 %s입니다\n", ((Dog)an[i]).getBreed());
			}else {
				System.out.printf("이 고양이의 색상은 %s입니다\n", ((Cat)an[i]).getColor());
			}
			System.out.println();
		}

	}

}
