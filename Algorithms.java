import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
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
            //Stores adjacent node color
            Set<Integer> unavailableColor = new HashSet<>();

            //Initialize first color
            int availableColor = 0;

            //Observe thr frontmost node of the queue
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
        System.out.println("Welsh-Powell Algorithm implementation");

        LinkedList<Node> nodes = new LinkedList<>(graph.getNodes());
        // nodes.addAll(graph.getNodes());

        Collections.sort(nodes, new NodeDegreeComparator().reversed());

        //Starting color
        int color = 0;

        while(!nodes.isEmpty()){
            Iterator it = nodes.listIterator();

        }
    }
}

class NodeDegreeComparator implements Comparator<Node>{
    @Override
    public int compare(Node obj1, Node obj2) {
        return obj1.degree - obj2.degree;
    }
}