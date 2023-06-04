package setup;

import java.util.Scanner;

import graph.Algorithms;
import graph.Graph;

public class MainSet {
    private Graph graph;

    public void run() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("-----------------------------------");
            System.out.println("What Would you like to do?");
            System.out.println("(Please input a number)");
            System.out.println("-----------------------------------");
            System.out.println("1 : Setup / Reset graph");
            System.out.println("2 : Color the graph");
            System.out.println("3 : Algorithm");
            System.out.println("4 : Paint color");
            System.out.println("5 : Exit");
            System.out.println("-----------------------------------");

            int input = s.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Going to setup menu....");
                    Thread.sleep(3000);
                    Setup setup = new Setup();
                    this.graph = setup.setup();
                    break;
                case 2:
                    System.out.println("Coloring the graph.....");
                    Thread.sleep(3000);
                    break;
                case 3:

                    System.out.println("Algorithm");
                    Thread.sleep(3000);
                    System.out.println(
                            "You chose Algorithm. Please choose an algorithm: (1) Greedy, (2) Welsh-Powell, (3) Dsatur");
                    int algorithm = s.nextInt();
                    switch (algorithm) {
                        case 1:
                            System.out.println("You chose Greedy algorithm.");
                            Algorithms.G1(graph);
                            break;
                        case 2:
                            System.out.println("You chose Welsh-Powell algorithm.");
                            Algorithms.WP(graph);
                            break;
                        case 3:
                            System.out.println("You chose Dsatur algorithm.");
                            Algorithms.Dsatur(graph);
                            break;
                        default:
                            System.out.println(
                                    "Invalid algorithm choice. Please choose a valid algorithm number.");
                            break;
                    
                    }
                    break;

                case 4:
                    System.out.println("Printing color....");
                    Thread.sleep(3000);
                    graph.printColor();
                    Thread.sleep(4000);
                    break;
                case 5:
                    System.out.println("Goodbye");
                    running = false;
                    break;
            }
        }
    }

}
