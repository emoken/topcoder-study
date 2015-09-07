package util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestUtil {

	public static String dos2unix(String dosStr) {
		return dosStr.replaceAll("\r\n", "\n");
	}

	public static String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}

	public static String[] convert(int[] intArray){
		String strIntArray = Arrays.toString(intArray);
		return strIntArray.substring(1, strIntArray.length() - 1).split(", ");
	}
	
	public static int[] toIntArray(String[] strArray){
    int[] intArray = new int[strArray.length];
    for(int i=0;i<strArray.length;i++){
      intArray[i] = Integer.parseInt(strArray[i]);
    }
    return intArray;
  }

}
