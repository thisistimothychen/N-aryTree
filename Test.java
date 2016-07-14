import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Timothy Chen on 7/13/16.
 */
public class Test {

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        BetterNode<Integer> tree = new BetterNode(new BetterNode());
        BetterNode<Integer> root = tree;
        int userInput;
        char opSel;
        String operation = "";

        System.out.println("Insert root value: ");
        System.out.print(">> ");
        userInput = intInput.nextInt();
        tree.setData(userInput);


        do {
            if (tree.numChildren() != 0) {
                System.out.println("\nSelect action: ");
                System.out.println("a. Exit program");
                System.out.println("b. Create child node");
                System.out.println("c. Select child");

                System.out.print(">> ");
                opSel = stringInput.nextLine().charAt(0);
                switch (opSel) {
                    case 'a':   operation = "Exit";
                                break;
                    case 'b':   operation = "Create child";
                                break;
                    case 'c':   operation = "Select child";
                                break;
                }
            } else if (root.equals(tree)) {
                System.out.println("\nSelect action: ");
                System.out.println("a. Exit program");
                System.out.println("b. Create child node");

                System.out.print(">> ");
                opSel = stringInput.nextLine().charAt(0);
                switch (opSel) {
                    case 'a':   operation = "Exit";
                                break;
                    case 'b':   operation = "Create child";
                                break;
                }
            } else if (tree.numChildren() == 0) {
                System.out.println("\nSelect action: ");
                System.out.println("a. Exit program");
                System.out.println("b. Create child node");
                System.out.println("c. Select parent");

                System.out.print(">> ");
                opSel = stringInput.nextLine().charAt(0);
                switch (opSel) {
                    case 'a':   operation = "Exit";
                                break;
                    case 'b':   operation = "Create child";
                                break;
                    case 'c':   operation = "Select parent";
                                break;
                }
            } else {
                System.out.println("\nSelect action: ");
                System.out.println("a. Exit program");
                System.out.println("b. Create child node");
                System.out.println("c. Select child");
                System.out.println("d. Select parent");

                System.out.print(">> ");
                opSel = stringInput.nextLine().charAt(0);
                switch (opSel) {
                    case 'a':   operation = "Exit";
                                break;
                    case 'b':   operation = "Create child";
                                break;
                    case 'c':   operation = "Select child";
                                break;
                    case 'd':   operation = "Select parent";
                                break;
                }
            }

            if (operation.equals("Create child")) {                                             // Create child node
                System.out.println("\nWhat value would you like to insert into the tree?");
                userInput = intInput.nextInt();

                tree.addChild(new BetterNode<>(userInput));
            } else if (operation.equals("Select child")) {                                      // Select child
                System.out.println("\nWhich child would you like to select (by index)?");

                ArrayList<BetterNode<Integer>> children = (ArrayList<BetterNode<Integer>>) tree.getChildren();
                for (int i = 0; i < children.size(); i++) {
                    System.out.println("Enter " + (i + 1) + " for: " + children.get(i));
                }

                userInput = intInput.nextInt();
                tree = tree.getChildAt(userInput - 1);
                System.out.println("Currently in child with data " + tree.getData());
            } else if (operation.equals("Select parent")) {                                                 // Select parent
                tree = tree.getParent();
                System.out.println("Currently in parent with data " + tree.getData());
            }

            root.getPostOrderTraversal();

        } while (!operation.equals("Exit"));

        root.getPostOrderTraversal();
    }
}