package com.kh.example.oop7;

public class ProductController {
	private Product[] pro = new Product[10];

	public ProductController() {
		super();
		pro[0] = new Product("갤럭시", 1200000, "삼성");
		pro[1] = new Product("아이폰", 1300000, "애플");
		pro[2] = new Product("아이패드", 800000, "애플");
	}
	
	public void insertProduct(String pName, int price, String brand) {
		int index = 0; 
		for(int i=0; i<pro.length; i++) {
			if(pro[i] == null) {
				index = i;
				break;
			}
		}
		pro[index] = new Product(pName,price,brand);
	}
	
	public Product[] selectProduct() {
		return pro;
	}
	
}
