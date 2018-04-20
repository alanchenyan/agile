package part_1.imageutil.exercises;

public class ImageUtil {
	
	private static ImageUtil instance;

	private ImageUtil(){
		
	}
	
	public static ImageUtil shareInstance(){
		if(instance == null){
			instance = new ImageUtil();
		}
		return instance;
	}
}
