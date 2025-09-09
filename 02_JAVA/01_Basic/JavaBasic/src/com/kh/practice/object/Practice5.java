package com.kh.practice.object;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//문자가 등장할 때 등장한 문자를 체크해두고
		//이미 나왔던 문자가 다시 등장했다면, 이전문자와 같은지 확인후
		//이미 나왔던 문자가 이전문자와 다름문자라면 그룹단어X
		int n = sc.nextInt();
		int count = 0;
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			boolean[] isDupl = new boolean[26];
			char prev = 0;
			
			boolean isOk = true;
			
			for(int j=0; j<str.length(); j++) {
				char ch = str.charAt(j);
				if(prev != ch) {
					int index = ch - 'a';
					if(isDupl[index]) {
						isOk = false;
						break;
					}
					isDupl[index] = true;
					prev = ch
;				}
			}
			if(isOk) count++;
		}
		System.out.println(count);

		/*
		int num = sc.nextInt();
		String[] str = new String[num];
		
		int count = 0;
		
		for(int i=0; i<num; i++) {
			str[i] = sc.next().toLowerCase();
		}
		for(String st : str) {
			char[] ch = st.toCharArray();
			boolean[] check = new boolean[26];
			for(int i=0; i<26; i++) {
				if(ch[i] != ch[i+1]) {
					if(check[ch[i]-'a']==false) {
						check[ch[i]-'a'] = true;
					}else {
						count -= 1;
						break;
					}
				}
			}
			count += 1;
		}
		System.out.println(count);
		*/

	}

}
