// code snippet

    public void BruteForce(Graph graph) {
        System.out.println("Brute Force Algorithm implementation");

        ArrayList<Node> nodes = graph.getNodes();

        // Generate all possible color combinations
        int numColors = nodes.size();
        int[] colors = new int[numColors];
        BruteForceHelper(nodes, colors, 0);

        // Assign the generated color combination to nodes
        for (int i = 0; i < numColors; i++) {
            nodes.get(i).setColor(colors[i]);
        }
    }

    private void BruteForceHelper(ArrayList<Node> nodes, int[] colors, int nodeIndex){
        if(nodeIndex==nodes.size()){
            // All nodes have been assigned a color combination
            // Check if the assignment is valid
            if(isValidColoring(nodes)){
                // Found a valid coloring
                return;
            }
        }else{
            // Try all possible colors for the current node
            for(int color=0;color<nodes.size();color++){
                colors[nodeIndex]=color;
                BruteForceHelper(nodes,colors,nodeIndex+1);
            }
        }
    }