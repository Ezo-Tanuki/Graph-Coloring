public class Graph{
    int size;
    protected Node nodes[];

    protected int vertex[][];

    public Graph(int size) {
        this.size = size;
        this.nodes = new Node[size];
        this.vertex = new int[size][size];
    }
    
    
}