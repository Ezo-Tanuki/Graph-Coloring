import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Algorithms{
    public void BF(Graph graph){
        ArrayList<Node> nodes = graph.getNodes();
        Queue<Node> nodeQueue = new LinkedList<>();

        //Set first node to be colored
        nodeQueue.add(nodes.get(0));
        while(!nodeQueue.isEmpty()){
            Set<Integer> unavailableColor = new HashSet<>(4);
            int availableColor = 0;
            Node currentNode = nodeQueue.poll();

            for(Node adjacent : currentNode.getAdjacent()){
                unavailableColor.add(adjacent.color);
                if(!adjacent.visited) nodeQueue.add(adjacent);
            }
            
            while(unavailableColor.contains(availableColor)){
                availableColor++;
            }

            currentNode.setColor(availableColor);
            currentNode.visited = true;
        }

    }

    public void WP(Graph graph){
        Collections.sort(graph.getNodes(), new NodeComparator());
    }
}

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node obj1, Node obj2) {
        return obj1.degree > obj2.degree ? 0 : 1;
    }
}