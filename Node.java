import java.util.ArrayList;

public class Node {
    private String identifier;
    protected int color;
    private ArrayList<Node> adjacent;
    protected int degree;
    protected boolean visited;

    private void setup(){
        this.setColor(-1);
        this.degree = 0;
        this.adjacent = new ArrayList<>();
    }

    public Node(String identifier) {
        this.identifier = identifier;
        this.setup();
    }

    public Node() {
        this.setup();
    }

    public void reset(){
        this.color = -1;
        this.degree = 0;
        this.visited = false;
    }

    public void addConnection(Node obj){
        this.adjacent.add(obj);
        this.degree++;
    }

    public void setColor(int color){
        this.color = color;
    }

    public String getIdentifier(){
        return this.identifier;
    }

    public ArrayList<Node> getAdjacent(){
        return this.adjacent;
    }
    
}
