import java.util.Scanner;
public class MainSet {
    private Graph graph;
    public void menu() throws InterruptedException {
        Scanner Inp = new Scanner(System.in);
        boolean life = true;
        while(life == true){
            System.out.println("-----------------------------------");
            System.out.println("What Would you like to do?");
            System.out.println("(Please input a number)");
            System.out.println("-----------------------------------");
            System.out.println("1 : Setup/ Reset graph");
            System.out.println("2 : Color the graph");
            System.out.println("3 : Algorithm");
            System.out.println("4 : Paint color");
            System.out.println("5 : Exit");
            System.out.println("-----------------------------------");
            int fInp = Inp.nextInt();
            switch (fInp) {
                case 1:
                    System.out.println("Going to setup menu....");
                    Thread.sleep(3000);
                    Setup s = new Setup();
                    s.setup(this.graph);
                    continue;
                case 2:
                    System.out.println("Coloring the graph.....");
                    Thread.sleep(3000);
                    menu();
                    continue;
                case 3:
                    System.out.println("Algorithm");
                    Thread.sleep(3000);
                    System.out.println("You chose Algorithm. Please choose an algorithm: (1) Brute force, (2) Welsh-Powell");
                    int algorithm = Inp.nextInt();
                    switch (algorithm) {
                        case 1:
                            System.out.println("You chose Brute force algorithm.");
                            Algorithms algorithms = new Algorithms();
                            algorithms.BF(graph);
                            break;
                        case 2:
                            System.out.println("You chose Welsh-Powell algorithm.");
                            algorithms = new Algorithms();
                            algorithms.WP(graph);
                            break;
                        default:
                            System.out.println("Invalid algorithm choice. Please choose a valid algorithm number.");
                            break;
                    }
                    menu();
                    continue;
                case 4:
                    System.out.println("Printing color....");
                    Thread.sleep(3000);
                    graph.printColor();
                    Thread.sleep(4000);
                    menu();
                    continue;
                case 5:
                    System.out.println("Goodbye");
                    life = false;
            }
        }
    }
}
