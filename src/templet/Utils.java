package templet;



public class Utils {
	
	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public  static String getClassName(String str)
	{
		
		String s0=str.substring(0, 1).toUpperCase();
		
		return s0+str.substring(1);
	}
	
	
	
}
