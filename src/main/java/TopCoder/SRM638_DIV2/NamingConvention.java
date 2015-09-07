package TopCoder.SRM638_DIV2;

public class NamingConvention {

  public String toCamelCase(String variableName){
    
    char[] snakeChars = variableName.toCharArray();
    
    for(int i=0;i<snakeChars.length;i++){
      if(snakeChars[i]=='_' && i != snakeChars.length -1 && i != 0){
        i++;
        snakeChars[i] = Character.toUpperCase(snakeChars[i]);
      }
    }
    
    return new String(snakeChars).replaceAll("_", "");
  }
}