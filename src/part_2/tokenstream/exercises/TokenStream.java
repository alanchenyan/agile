package part_2.tokenstream.exercises;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Vector;

/**
 * Alan Chen
 * 2018-1-7 下午11:31:08
 * 
 * Turn the comments into code
 */
public class TokenStream {

	Vector v;//a list of tokens parsed from br.
	int index;//index of the current token in v.
	BufferedReader br;//read the chars from here to parse the tokens.
	int currentChar;//previous char read from br.
	
	// read the chars from the reader and parse the tokens.
	TokenStream(Reader read){
		br = new BufferedReader(read);
		takeChar();
		v = parseFile();
		index = 0;
	}
	
	//read the chars from br,parse the tokens and store them into a vector.
	Vector parseFile(){
		Vector v = null;//accumulate the tokens that have bean parsed.
		// .....
		return v;
	}
	
	void takeChar(){}
}
