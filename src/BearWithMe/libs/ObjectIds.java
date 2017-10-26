package BearWithMe.libs;

import java.util.HashMap;
import java.util.Map;

public class ObjectIds {

	public static Map<String, Integer> id = new HashMap<String, Integer>();
	public static void initIds(){
		id.put("player",0);
		id.put("grass", 16);
	}
	
}