package ku.opensrcsw._MidTerm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	FileReader in = null;
    	Scanner scan = null;
		try {
			in = new FileReader("midterm.json");
			scan = new Scanner(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String str = "";
    	while(scan.hasNext()) {
    		str += scan.nextLine();
    	}
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) jsonParser.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JSONArray infoArray = (JSONArray) jsonObject.get("poem");
    	System.out.print("Enter the keyword you are looking for : ");
    	scan = new Scanner(System.in);
    	String str2 = scan.nextLine();
        for(int i=0;i<infoArray.size();i++) {
        	JSONObject itemObject = (JSONObject) infoArray.get(i);
        	String str3 = (String)itemObject.get("item");
        	if(str3.contains(str2)) {
            	System.out.println("item "+i+": "+itemObject.get("item"));	
        	}
        }
    }
}
