import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Algorithms{
    public boolean validate(Graph graph){
        for(Node currentNode : graph.getNodes()){
            for(Node adjacentNode : currentNode.getAdjacent()){
                if(currentNode.getColor() == adjacentNode.getColor()) return false;
            }
        }

        return true;
    }

    public void G1(Graph graph){
        System.out.println("Greedy 1 Algorithm implementation");
        ArrayList<Node> nodes = graph.getNodes();
        Queue<Node> nodeQueue = new LinkedList<>();

        //Set first node to be colored
        nodeQueue.add(nodes.get(0));
        while(!nodeQueue.isEmpty()){
            //Stores adjacent node color
            Set<Integer> unavailableColor = new HashSet<>();

            //Initialize first color
            int availableColor = 0;

            //Observe the frontmost node of the queue
            Node currentNode = nodeQueue.poll();

            for(Node adjacent : currentNode.getAdjacent()){
                unavailableColor.add(adjacent.getColor());
                if(!adjacent.isVisited()) nodeQueue.add(adjacent);
            }
            
            while(unavailableColor.contains(availableColor)){
                availableColor++;
            }

            currentNode.setColor(availableColor);
            currentNode.setVisited(true);
        }

    }

    public void WP(Graph graph){
        System.out.println("Welsh-Powell Algorithm implementation");

        LinkedList<Node> nodes = new LinkedList<>(graph.getNodes());

        Collections.sort(nodes, new NodeDegreeComparator().reversed());

        //Starting color
        int color = 0;

        //Iterate through the list
        while(!nodes.isEmpty()){
            Iterator<Node> it = nodes.listIterator();
            
            //Check adjacent color
            do{
                Node currentNode = it.next();
                boolean validColor = true;

                for(Node adjacentNode : currentNode.getAdjacent()){
                    //Current color already used on adjacent node
                    if(adjacentNode.getColor() == color){
                        validColor = false;
                        break;
                    }
                }

                //Remove node from list and set the color to the current node
                if(validColor){
                    currentNode.setColor(color);
                    it.remove();
                }
            }
            while(it.hasNext());
            
            color++;
        }
    }
}

class NodeDegreeComparator implements Comparator<Node>{
    @Override
    public int compare(Node obj1, Node obj2) {
        return obj1.getDegree() - obj2.getDegree();
    }
}