import java.io.*; 
import java.util.Scanner; 

public class dvrouter{
    public static void main(String[] args){
        Graph g = new Graph();
        int x=0;
         try {
            Scanner scan = new Scanner(new FileInputStream(args[0]));
            while (scan.hasNextLine()) {
                String inputLine = scan.nextLine();
                String[] values = inputLine.split(" ");
                g.editEdge(Integer.parseInt(values[0]),
                Integer.parseInt(values[1]),Integer.parseInt(values[2]));
                x++;
            }
            scan.close();
        } catch (Exception e){
         
        }              
                Graph G2 = g;
                g.setNodes();

                for(int i = 0; i<g.size();i++){
                    g.dj(i);
                }        
              
                
         try {
            Scanner scan = new Scanner(new FileInputStream(args[1]));
            while (scan.hasNextLine()) {        
               
             
                System.out.println("---------------------------------------------------------------------------------------");
                String inputLine = scan.nextLine();
                String[] values = inputLine.split(" ");
                G2.editEdge(Integer.parseInt(values[0]),Integer.parseInt(values[1]),Integer.parseInt(values[2]));
                Graph G3 = G2;
                G3.setNodes();
                for(int i = 0; i<g.size();i++){
                    G3.dj(i);
                }  
            }
            scan.close();
        } catch (Exception e){
            
        }
   // g.printEdges();

    }

    
}


