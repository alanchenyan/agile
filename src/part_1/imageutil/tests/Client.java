package part_1.imageutil.tests;

public class Client {

	public static void main(String[] args) {
		ImageUtil imageUtil = (ImageUtil) SingleFactory.getSingleInstance(ImageUtil.class);
		ImageUtil imageUtil2 = (ImageUtil) SingleFactory.getSingleInstance(ImageUtil.class);
		
		if(imageUtil == imageUtil2){
			System.out.println("A");
		}else{
			System.out.println("B");
		}
	}
}
