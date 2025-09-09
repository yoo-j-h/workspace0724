package com.kh.example.abstractNInterface;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] p = {new GalaxyNote9(), new V40()};
		for(int i=0; i<p.length; i++) {
			if(p[i] instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9)p[i]).printInformation();
			}else {
				result[i]=((V40)p[i]).printInformation();
			}
		}
		return result;
	}
 }
