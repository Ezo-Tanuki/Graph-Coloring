public class Graph{
    final int size;
    protected Node[] nodes;

    protected int edges[][];

    public Graph(int size) {
        this.size = size;
        this.nodes = new Node[size];
        this.edges = new int[size][size];
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int[][] getEdges() {
        return edges;
    }
    
    public class ConnectNode extends Graph {
    public ConnectNode(int size) {
        super(size);
    }

    public void connect(int node1, int node2) {
        this.edges[node1][node2] = 1;
        this.edges[node2][node1] = 1;
    }
}
}
