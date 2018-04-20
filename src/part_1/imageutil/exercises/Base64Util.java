package part_1.imageutil.exercises;

public class Base64Util {
	
	private static Base64Util instance;

	private Base64Util(){};
	
	public static Base64Util shareInstance(){
		if(instance == null){
			instance = new Base64Util();
		}
		return instance;
	}
}
