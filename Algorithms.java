import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public final class Algorithms{
    public static boolean validate(Graph graph){
        for(Node currentNode : graph.getNodes()){
            for(Node adjacentNode : currentNode.getAdjacent()){
                if(currentNode.getColor() == adjacentNode.getColor()) return false;
            }
        }

        return true;
    }

    public static void G1(Graph graph){
        System.out.println("Greedy 1 Algorithm implementation");
        Queue<Node> nodeQueue = new LinkedList<>();

        //Set first node to be colored
        nodeQueue.add(graph.getNodes().get(0));
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

            if(nodeQueue.isEmpty()){
                //check for uncolored node
                for(Node node : graph.getNodes()){
                    if(node.getColor() == -1){
                        nodeQueue.add(node);
                        break;
                    }

                }

            }

        }

    }

    public static void WP(Graph graph){
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

    public static void Dsatur(Graph graph){
        System.out.println("DSatur Algorithm implementation");
        
        Map<Node, Set<Integer>> saturationMap = new HashMap<>(graph.getMAX_SIZE());

        PriorityQueue<Node> nodeQueue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node obj1, Node obj2) {
                //Check highest saturation
                if(saturationMap.get(obj1).size() != saturationMap.get(obj2).size()) return Integer.compare(saturationMap.get(obj2).size(), saturationMap.get(obj1).size());
                //Check highest degree
                if(obj1.getDegree() != obj2.getDegree()) return Integer.compare(obj2.getDegree(), obj1.getDegree());
                //Label comparison
                return obj1.getIdentifier().compareTo(obj2.getIdentifier());
            }
        });

        for(Node node : graph.getNodes()){
            saturationMap.put(node, new HashSet<>());    
            nodeQueue.add(node);
        }

        while(!nodeQueue.isEmpty()){
            Node currentNode = nodeQueue.poll();
            if(currentNode.isVisited()) continue;

            Set<Integer> unavailableColor = new HashSet<>();

            //Starting color
            int availableColor = 0;
            for(Node adjacent : currentNode.getAdjacent()){
                unavailableColor.add(adjacent.getColor());
                if(!adjacent.isVisited()) nodeQueue.add(adjacent);
            }
            
            while(unavailableColor.contains(availableColor)){
                availableColor++;
            }

            currentNode.setColor(availableColor);
            currentNode.setVisited(true);

            for(Node adjacent : currentNode.getAdjacent()){
                if(adjacent.isVisited()) continue;
                saturationMap.get(adjacent).add(availableColor);
            }

            if(nodeQueue.isEmpty()){
                //check for uncolored node
                for(Node node : graph.getNodes()){
                    if(node.getColor() == -1){
                        nodeQueue.add(node);
                        break;
                    }

                }

            }

        }

    }
}

class NodeDegreeComparator implements Comparator<Node>{
    @Override
    public int compare(Node obj1, Node obj2) {
        return Integer.compare(obj1.getDegree(), obj2.getDegree());
    }
}