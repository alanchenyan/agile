package part_2.tokenstream.solutions;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Vector;

/**
 * Alan Chen
 * 2018-1-7 下午11:31:08
 * 
 * The comments can be turned into names of variables,parameters
 * and methods.The comments describing how the constructor works
 * should be turned into the body of the constructor.
 */
public class TokenStream {

	Vector parsedTokenList;
	int currentTokenIdxInList;
	BufferedReader charInputSourceForParsing;
	int previousCharReadFromSource;
	
	TokenStream(Reader reader){
		charInputSourceForParsing = new BufferedReader(reader);
		takeChar();
		parsedTokenList = parseTokenFromInutSource();
		currentTokenIdxInList = 0;
	}
	
	Vector parseTokenFromInutSource(){
		Vector tokenParseSoFar = null;
		// .....
		return tokenParseSoFar;
	}
	
	void takeChar(){}
}
