// code snippet

case "3":
                    // Handle Algorithm
                    System.out.println("You chose Algorithm. Please choose an algorithm: (1) Brute force, (2) Welsh-Powell");
                    String algorithm = scanner.nextLine();
                    switch (algorithm) {
                        case "1":
                            // Handle Brute force algorithm
                            System.out.println("You chose Brute force algorithm.");
                            Algorithms algorithms = new Algorithms();
                            algorithms.BF(graph);
                            break;
                        case "2":
                            // Handle Welsh-Powell algorithm
                            System.out.println("You chose Welsh-Powell algorithm.");
                            algorithms = new Algorithms();
                            algorithms.WP(graph);
                            break;
                        default:
                            System.out.println("Invalid algorithm choice. Please choose a valid algorithm number.");
                            break;
                           
                           
//have not implement the integer variable yet maybe something like this
                     
                     int chosenAlgorithm = 0;
                  
                     // Assume the user has selected the Brute Force algorithm
                     chosenAlgorithm = 1;
