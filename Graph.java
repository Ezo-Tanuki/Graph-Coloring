import java.util.ArrayList;
import java.util.Map;

public class Graph{
    private final int MAX_SIZE;
    protected int size;
    private ArrayList<Node> nodes;
    private Map<Integer, String> colorSchemeMap;

    public Graph() {
        this.MAX_SIZE = Integer.MAX_VALUE;
        this.size = 0;
        this.nodes = new ArrayList<>();
    }

    public Graph(Map<Integer, String> colorSchemeMap, int maxSize) {
        this.MAX_SIZE = maxSize;
        this.size = 0;
        this.nodes = new ArrayList<>(size);
        this.setColorSchemeMap(colorSchemeMap);
    }

    public Graph(int maxSize, Map<Integer, String> colorSchemeMap) {
        this.MAX_SIZE = maxSize;
        this.size = 0;
        this.nodes = new ArrayList<>(size);
        this.setColorSchemeMap(colorSchemeMap);
    }

    public Graph(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.size = 0;
        this.nodes = new ArrayList<>(size);
    }

    public boolean addNode() {
        if(this.size >= this.MAX_SIZE){
            System.out.println("Max size reached!");
            return false;
        }

        String identifier = Integer.toString(this.size);

        this.nodes.add(new Node(identifier));
        this.size++;
        return true;
    }

    public void connectNodes(int obj1, int obj2) {
        // this.edges[obj1][obj2] = 1;
        // this.edges[obj2][obj1] = 1;
        Node node1 = nodes.get(obj1);
        Node node2 = nodes.get(obj2);
        node1.addConnection(node2);
        node2.addConnection(node1);
    }

    public void printColor() {
        for(Node node: this.nodes){
            if(colorSchemeMap != null){
                System.out.println(node.getIdentifier() + ": " + colorSchemeMap.get(node.getColor()));
            }
            
            else System.out.println(node.getIdentifier() + ": " + node.getColor());
        }
    }

    

    public void setColorSchemeMap(Map<Integer, String> colorSchemeMap) {
        this.colorSchemeMap = colorSchemeMap;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

}
