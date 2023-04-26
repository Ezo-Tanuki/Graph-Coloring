public class Node {
    protected int color;
    protected int degree;

    public Node() {
        this.color = -1;
    }

    public Node(int color) {
        this.color = color;
        this.degree = 0;
    }

    public void reset(){
        this.color = -1;
        this.degree = 0;
    }
}
