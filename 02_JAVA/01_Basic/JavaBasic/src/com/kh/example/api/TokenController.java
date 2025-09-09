package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str, " ");
		int size = stn.countTokens();
		//String st = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			//st = st.concat(stn.nextToken());
			//st += stn.nextToken();
			sb.append(stn.nextToken());
		}
		return sb.toString();
	}
	
	public String firstCap(String input) {
		
		char c = input.toUpperCase().charAt(0);
		/*
		 * String st1 = input.substring(0,1).toUpperCase(); String st2 =
		 * input.substring(1); String str = st1 + st2;
		 */
		return c+input.substring(1);
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == one) {
				count++;
			}
		}
		return count;
	}
}
