public class Graph{
    final int size;
    protected Node[] nodes;

    protected int vertex[][];

    public Graph(int size) {
        this.size = size;
        this.nodes = new Node[size];
        this.vertex = new int[size][size];
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int[][] getVertex() {
        return vertex;
    }
    
    public class ConnectNode extends Graph {
    public ConnectNode(int size) {
        super(size);
    }

    public void connect(int node1, int node2) {
          this.vertex[node1][node2] = 1;
        this.vertex[node2][node1] = 1;
    }
}
}
