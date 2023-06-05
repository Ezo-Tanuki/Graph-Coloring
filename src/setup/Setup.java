package setup;

import java.awt.Color;
import java.util.HashMap;
import java.util.Scanner;

import graph.Graph;

public class Setup {
    Graph outputGraph;

    public Graph setup(Graph g) throws InterruptedException {
        this.outputGraph = g;
        boolean running = true;
        Scanner s = new Scanner(System.in);
        while (running) {
            
            System.out.println("------------------------------------------------");
            System.out.println("Choose the type of setup you would like to do");
            System.out.println("(Please input a number)");
            System.out.println("-------------------------------------------------");
            System.out.println("1 : Quick Setup");
            System.out.println("2 : Reset Color");
            System.out.println("3 : Return to Main Menu");
            System.out.println("-------------------------------------------------");

            int input = s.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Beginning Quick setup.....");
                    // Thread.sleep(5000);
                    System.out.println("Please input the size / number of nodes:");
                    int size = s.nextInt();
                    this.outputGraph = new Graph(size);

                    for (int i = 0; i < size; i++)
                        this.outputGraph.addNode();

                    System.out.println("Please input number of Connection:");
                    int numberConnection = s.nextInt();
                    for (int i = 0; i < numberConnection; i++) {
                        System.out.println("Please input Connection no." + (i + 1));
                        int var1 = s.nextInt();
                        int var2 = s.nextInt();
                        System.out.println(var1);
                        System.out.println(var2);
                        this.outputGraph.connectNodes(var1, var2);
                    }

                    break;
                case 2:
                    System.out.println("Reset");
                    this.outputGraph.resetNode();
                    break;
                case 3:
                    System.out.println("Returning.....");
                    running = false;
                    // Thread.sleep(4000);
                    break;
            }
        }
        // s.close();
        outputGraph.setColorSchemeMap(new HashMap<>(5));
        outputGraph.setColor(0, Color.CYAN);
        outputGraph.setColor(1, Color.YELLOW);
        outputGraph.setColor(2, Color.GREEN);
        outputGraph.setColor(3, Color.LIGHT_GRAY);
        return this.outputGraph;
    }
}
