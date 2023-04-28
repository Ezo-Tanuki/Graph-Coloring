import java.util.ArrayList;
import java.util.Scanner;

public class Graph{
    private final int MAX_SIZE;
    protected int size;
    private ArrayList<Node> nodes;

    // protected int edges[][];

    public Graph(){
        this.MAX_SIZE = -1;
        this.size = 0;
        this.nodes = new ArrayList<>();
    }

    public Graph(int maxSize) {
        this.MAX_SIZE = Integer.MAX_VALUE;
        this.size = 0;
        this.nodes = new ArrayList<>(size);
        // this.edges = new int[size][size];
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    // public int[][] getEdges() {
    //     return edges;
    // }


    public boolean addNode(boolean costumIdentifier){
        if(this.size >= this.MAX_SIZE){
            System.out.println("Max size reached!");
            return false;
        }

        Scanner s = new Scanner(System.in);
        String identifier;
        if(costumIdentifier){
            System.out.println("Input the node identifier");
            identifier = s.nextLine();
        }
        else identifier = Integer.toString(this.size);

        this.nodes.add(new Node(identifier));
        this.size++;
        return true;
    }

    public boolean addNode(){
        return this.addNode(false);
    }

    public void connectNodes(int obj1, int obj2) {
        // this.edges[obj1][obj2] = 1;
        // this.edges[obj2][obj1] = 1;
        Node node1 = nodes.get(obj1);
        Node node2 = nodes.get(obj2);
        node1.addConnection(node2);
        node2.addConnection(node1);
    }

    public void printColor(){
        for(Node node: this.nodes){
            System.out.println(node.getIdentifier() + ": " + node.color);
        }
    }
}
