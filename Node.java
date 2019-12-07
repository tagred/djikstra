import java.util.*;
import java.io.*;

public class Node{

    public int ID;
    public List<Integer> connections = new LinkedList<Integer>();
    public List<Integer> weight = new LinkedList<Integer>();
    public Node(){

    }
    public void addConn(int c,int w){
        connections.add(c-1);
        weight.add(w);
    }
    public void print(){
        System.out.println(connections + " " + weight);
    }
    public int getWeight(int i){
        return weight.get(i);
    }
    public int getConnection(int i){
        return connections.get(i);
    }
    public boolean contains(int i){
        if(connections.contains(i))
        return true;

        return false;
    }
    public int getSize(){
       // System.out.println(connections.size()-1);
        return connections.size();
    }
    
}
