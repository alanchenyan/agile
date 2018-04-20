package part_2.complexpassword.tests;

/**
 * Alan Chen
 * 2018-1-7 下午10:54:07
 */
public class Account {

	boolean checkPwdIsComplexEnough(String password){
		boolean containsDigitOrSymbol = false;
		boolean containsLetter = false;
		for(int i = 0;i<password.length();i++){
			char c = password.charAt(i);
			if(Character.isLowerCase(c) || Character.isUpperCase(c)){
				containsLetter = true;
			}else{
				containsDigitOrSymbol = true;
			}
		}
		return containsLetter && containsDigitOrSymbol;
	}
}
