import java.util.*;
import java.io.*;


public class Graph{
    private Node[] nodes;
    private List<Edge> net = new LinkedList<Edge>(); //note to self sets cannot contain dupes
    public Graph(){
    }
    public int size(){
        return net.size();
    }
    public void editEdge(int from, int to, int sz){ // to is a set containing the size and destination from is initial start... will need access to 
        //adds to the edge, will remove from edge and replace if edge already exists, and will remove an edge if its link has been broken
        Edge e = new Edge(from,to,sz);
        if(net.isEmpty()){//adds initial edge
            net.add(e);
        }else if(sz ==-999){//removes broken link
            for (int i = 0; i< net.size();i++){
                if(net.get(i).getTo() == to && net.get(i).getFrom() == from){
                    net.remove(i);
                }
            }        
        }else{//This statement will replace e if it is already contained or just add e
            for (int i = 0; i< net.size();i++){
                if(net.get(i).getTo() == to && net.get(i).getFrom() == from){
                    net.get(i).setSize(sz);
                    return;
                }
            } 
        net.add(e);
        }
    }

    public void setNodes(){
                nodes = new Node[net.size()];
        for (int i = 0; i<net.size();i++){
            nodes[i] = new Node();

        }
        for (int i = 0; i<net.size();i++){
          for (int j = 0; j<net.size();j++){
            if (net.get(j).getTo() == i+1)
                nodes[i].addConn(net.get(j).getFrom(),net.get(j).getSize());
            if(net.get(j).getFrom() == i+1)
               nodes[i].addConn(net.get(j).getTo(), net.get(j).getSize());
            }
        }

    }
    public void printEdges(){
        for (int i =0;i<net.size();i++)
        System.out.println(net.get(i).getFrom() + " " + 
        net.get(i).getTo() + " "+net.get(i).getSize());
    }
    public boolean visited(){
        return true;
    }
    public void dj(int s){

    int shortestD[] = new int [net.size()];
    int prev[] = new int[net.size()];
    int near;
    boolean chk[] = new boolean[net.size()];
    
    for (int i = 0; i < net.size(); i++) { 
            shortestD[i] = Integer.MAX_VALUE; 
            chk[i] = false;
    } 
    shortestD[s] = 0;
    prev[s]=s+1;
     for (int i = 0; i < net.size() -1; i++) { 
        

            int a = minDistance(shortestD, chk); 
  
            
            chk[a] = true;

            for (int j = 0; j < nodes[a].getSize()  ; j++) {

                if (!chk[nodes[a].getConnection(j)] && nodes[a].getWeight(j) != 0 
                && shortestD[a]!= Integer.MAX_VALUE && 
                shortestD[a] + nodes[a].getWeight(j) < shortestD[nodes[a].getConnection(j)]) {

                    shortestD[nodes[a].getConnection(j)] = shortestD[a] + nodes[a].getWeight(j); 

                    prev[a] = a;
                        
                }



        } 
    }
   print(shortestD, prev); 
    }            
    public int minDistance(int[] dist, boolean[] visit) {
        int min = Integer.MAX_VALUE; 
        int minI = -1;
        for(int i = 0; i < net.size() ; i++) {
            if(visit[i] == false && dist[i] <= min) {
                min = dist[i];
                minI = i;
            }
        }
    //System.out.println( minI);
    return minI;
  }
    public void print(int[] dist, int[] prev){
     System.out.println();
    for (int i = 0; i < net.size(); i++) 
        System.out.println(i+1 + " " +prev[i]+ " " + dist[i] );
    }
    
}
