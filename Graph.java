import java.util.ArrayList;

public class Graph{
    final int size;
    protected ArrayList<Node> nodes;

    protected int edges[][];

    public Graph(int size) {
        this.size = size;
        this.nodes = new ArrayList<>(size);
        this.edges = new int[size][size];
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public int[][] getEdges() {
        return edges;
    }

    public void connectNodes(int node1, int node2) {
        this.edges[node1][node2] = 1;
        this.edges[node2][node1] = 1;
    }
}
