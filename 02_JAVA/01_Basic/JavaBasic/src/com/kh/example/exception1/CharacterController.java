package com.kh.example.exception1;

public class CharacterController {

	public CharacterController() {
		super();
	}
	
	public int countAlpha(String s) throws CharCheckException{
		if(s.contains(" ")) {
			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
		}
		
		
		int countA = 0;
		for(char c : s.toCharArray()) {
			if(c>='a'&&c<='z'||c>='A'&&c<='Z') {
				countA++;
			}else if(c==' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
		}
		
		return countA;
	}
}
 