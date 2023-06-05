package graph;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

public class Graph{
    private final int MAX_SIZE;
    private int size;
    private ArrayList<Node> nodes;
    private Map<Integer, Color> colorSchemeMap;

    public Graph() {
        this.MAX_SIZE = Integer.MAX_VALUE;
        this.size = 0;
        this.nodes = new ArrayList<>();
    }

    public Graph(Map<Integer, Color> colorSchemeMap, int maxSize) {
        this(maxSize, colorSchemeMap);
    }

    public Graph(int maxSize, Map<Integer, Color> colorSchemeMap) {
        this(maxSize);
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

    public void resetNode() {
        for(Node node: this.nodes){
            node.setColor(-1);
            node.setVisited(false);
        }
    }

    public void setColorSchemeMap(Map<Integer, Color> colorSchemeMap) {
        this.colorSchemeMap = colorSchemeMap;
    }

    public Map<Integer, Color> getColorSchemeMap() {
        return this.colorSchemeMap;
    }

    public void setColor(int key, Color value) {
        this.colorSchemeMap.put(key, value);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public int getSize() {
        return this.size;
    }

    public int getMAX_SIZE() {
        return this.MAX_SIZE;
    }

    

}
