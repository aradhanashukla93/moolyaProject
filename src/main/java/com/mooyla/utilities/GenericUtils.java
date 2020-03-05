package com.mooyla.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GenericUtils {
	
	private static final String JSON_FILE_PATH= System.getProperty("user.dir") + "\\src\\test\\resources\\APIData\\JSON\\";
	
	private GenericUtils() {}
	
	public static JSONObject readJSONFile(String filename) {
		JSONObject obj=null;
		try {
			obj= (JSONObject) new JSONParser().parse(new FileReader(JSON_FILE_PATH+filename));
			return obj;
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
			return null;
		}
		catch(IOException e) {
			System.out.println(e);
			return null;
		}
		catch(ParseException e){
			System.out.println(e);
			return null;
		}
		
	}
}