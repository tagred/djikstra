
public class Edge{
    private boolean visit = false;    
    int From,To,Size;
    public Edge(int from, int to, int sz){
        this.From = from;
        this.To = to;
        this.Size = sz;
    }
    public int getSize(){
        return Size;
    }
    public void setSize(int sz){
    Size = sz;
    }
    public int getTo(){
        return To;
    }
    public int getFrom(){
        return From;
    }
    public boolean visited(){
        visit = true;
        return visit;    
    }
    public int getneighbor(int i){
        if (From == i){
            return From;
        }
        else{
            return To;
        }
    }
}
