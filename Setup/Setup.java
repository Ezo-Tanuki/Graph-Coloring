import java.util.Scanner;

public class Setup {

    public void setup(Graph graph) throws InterruptedException {
        Scanner Setups = new Scanner(System.in);
        boolean isReturn = false;
        System.out.println("------------------------------------------------");
        System.out.println("Choose the type of setup you would like to do");
        System.out.println("(Please input a number)");
        System.out.println("-------------------------------------------------");
        System.out.println("1 : Quick Setup");
        System.out.println("2 : Advance Setup");
        System.out.println("3 : Return to Main Menu");
        System.out.println("-------------------------------------------------");
        int Choice = Setups.nextInt();

        switch (Choice){
            case 1:
                System.out.println("Beginning Quick setup.....");
                Thread.sleep(5000);
                System.out.println("Please input the size/ number of nodes:");
                int sizeIn = Setups.nextInt();
                graph = new Graph(sizeIn);

                for(int i = 0; i < sizeIn; i++) graph.addNode();

                System.out.println("Please input number of Connection:");
                int ConIn = Setups.nextInt();
                for (int i = 0; i < ConIn; i++ ) {
                    System.out.printf("Please input Connection no.", i+1);
                    int var1 = Setups.nextInt();
                    int var2 = Setups.nextInt();
                    System.out.println(var1);
                    System.out.println(var2);
                    graph.connectNodes(var1, var2);
                }

                break;
            case 2:
                System.out.println("Advance");

                break;
            case 3:
                System.out.println("Returning.....");
                Thread.sleep(4000);
                isReturn = true;
                break;
        }
        if(isReturn) return;
        setup(graph);
    }
}
