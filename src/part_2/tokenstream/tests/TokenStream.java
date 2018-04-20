package part_2.tokenstream.tests;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Vector;

/**
 * Alan Chen
 * 2018-1-7 下午11:31:08
 */
public class TokenStream {

	Vector tokenList;
	BufferedReader buffReader;
	int currentIndex;
	int previousChar;
	
	TokenStream(Reader read){
		parseTokensFromReader(read);
	}
	
	void parseTokensFromReader(Reader read){
	    buffReader = new BufferedReader(read);
		takeChar();
		tokenList = parseAndStoreTokens();
		currentIndex = 0;
	}
	
	Vector parseAndStoreTokens(){
		Vector v = null;//accumulate the tokens that have bean parsed.
		// .....
		return v;
	}
	
	void takeChar(){}
}
