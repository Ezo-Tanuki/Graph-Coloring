public class Graph{
    int size;
    protected Node[] nodes;

    protected int vertex[][];

    public Graph(int size) {
        this.size = size;
        this.nodes = new Node[size];
        this.vertex = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int[][] getVertex() {
        return vertex;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public void setVertex(int[][] vertex) {
        this.vertex = vertex;
    }
}
