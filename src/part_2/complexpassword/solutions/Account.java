package part_2.complexpassword.solutions;

/**
 * Alan Chen
 * 2018-1-7 下午11:05:45
 * 
 * The first comment contains two sentences.The first sentence:
 * "check if the password is complex enough" describes the purpose
 * of the method,it should be the method name.As the method name 
 * "isComplexPassword" is exactly like that,so we can simply delete
 * this sentence.The second sentence "contains letter and digit/symbol"
 * describes how the method works,so it should become the method body,
 * not the method name
 * 
 * PS:
 * 1、个人觉得 isComplexPassword 没有 我的 checkPwdIsComplexEnough 好
 * 2、关键是containsLetter、containsDigit、containsSymbol这些方法怎么实现，
 *   循环三次？
 */
public class Account {

	boolean isComplexPassword(String password){
		return containsLetter(password) &&
				(containsDigit(password) || containsSymbol(password));
	}
	
	
	boolean containsLetter(String password){
		return true;
	}
	
	boolean containsDigit(String password){
		return true;
	}
	
	boolean containsSymbol(String password){
		return true;
	}
}
