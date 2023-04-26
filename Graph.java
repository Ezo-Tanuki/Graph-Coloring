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
}
