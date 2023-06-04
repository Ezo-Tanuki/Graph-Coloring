import setup.MainSet;

public class Main {
    public static void main(String[] args) {
        MainSet setup = new MainSet();
        try {
            setup.run();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Scanner s = new Scanner(System.in);
        // System.out.println("Input graph size");
        // int size = s.nextInt();
        // Graph g = new Graph(size);
        // for(int i = 0; i < size; i++){
        //     g.addNode();
        // }

        // System.out.println("Enter number of connection");
        // int connection = s.nextInt();

        // System.out.println("Enter the connection");
        // for(int i = 0; i < connection; i++){
        //     int a = s.nextInt();
        //     int b = s.nextInt();
        //     g.connectNodes(a, b);
        // }
        

        // Algorithms.Dsatur(g);

        // g.printColor();
        
        // System.out.println(Algorithms.validate(g));

        // s.close();
    }
}
