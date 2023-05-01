import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input graph size");
        int size = s.nextInt();
        Graph g = new Graph(size);
        for(int i = 0; i < size; i++){
            g.addNode();
        }

        System.out.println("Enter number of connection");
        int connection = s.nextInt();

        System.out.println("Enter the connection");
        for(int i = 0; i < connection; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            g.connectNodes(a, b);
        }
        
        Algorithms Algo = new Algorithms();

        Algo.BF(g);

        g.printColor();
        
        s.close();
    }
}
