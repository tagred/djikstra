import java.util.*;
import java.io.*;

public class ReadFile{
    public ReadFile(string fileName){
        File file = new File(fileName);
	    Scanner sc = new Scanner(file);
        List<String> line = new ArrayList<String>();
        
        try{
            while(sc.hasNextLine()){
                line.add(sc.nextLine());
                //TODO parse string delim == whatever style the files use
            }
        }catch(IOException e){

        }
    }
}
