package part_2.inchtopointconvertor.solutions;

/**
 * Alan Chen
 * 2018-1-7 上午1:03:46
 * 
 * Turn the first comment into the method name and the second into a variable name;
 */
public class InchToPointConvertor {

	final static int POINTS_PER_INCH = 72;
	
	static float convertToPoints(float inch) {
		return inch * POINTS_PER_INCH;
	}
}
