package graph;
import java.util.ArrayList;

public class Node {
    private String identifier;

    private int color;
    private int degree;

    private ArrayList<Node> adjacent;

    private boolean visited;

    public Node(String identifier) {
        this.identifier = identifier;
        this.setColor(-1);
        this.degree = 0;
        this.adjacent = new ArrayList<>();        
    }

    public Node() {
        this(null);
    }

    public void reset() {
        this.color = -1;
        this.degree = 0;
        this.visited = false;
    }

    public void addConnection(Node obj) {
        this.adjacent.add(obj);
        this.degree++;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Node> getAdjacent() {
        return this.adjacent;
    }

    public int getColor() {
        return this.color;
    }

    public int getDegree() {
        return this.degree;
    }

    public String getIdentifier() {
        return this.identifier;
    }

}
