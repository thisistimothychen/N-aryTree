import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Timothy Chen on 7/13/16.
 */
public class Test {

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        int userInput;
        String operation = "";

        System.out.println("Insert root value: ");
        System.out.print(">> ");
        userInput = intInput.nextInt();
        BetterNode<Integer> tree = new BetterNode(userInput);
        BetterNode<Integer> root = tree;

        recurse(stringInput, intInput, operation, tree, root);

        root.getPostOrderTraversal();

        Vector<BetterNode<Integer>> children = root.getChildren();
//        System.out.println("COMPARE index 0 and 2: " + children.get(0).equals(children.get(2)));
//        System.out.println("COMPARE index 0 and 1: " + children.get(0).equals(children.get(1)));
    }


    public static void recurse(Scanner stringInput, Scanner intInput, String operation, BetterNode<Integer> tree, BetterNode<Integer> root) {
        char opSel;
        int userInput;

        if (tree.getNumChildren() != 0 && root.equals(tree)) {             // At the top, has children
            System.out.println("\nSelect action: ");
            System.out.println("a. Exit program");
            System.out.println("b. Create child node");
            System.out.println("c. Select child");

            System.out.print(">> ");
            opSel = stringInput.nextLine().charAt(0);
            switch (opSel) {
                case 'a':
                    operation = "Exit";
                    break;
                case 'b':
                    operation = "Create child";
                    break;
                case 'c':
                    operation = "Select child";
                    break;
            }
        } else if (tree.getNumChildren() == 0 && root.equals(tree)) {      // At top, no children
            System.out.println("\nSelect action: ");
            System.out.println("a. Exit program");
            System.out.println("b. Create child node");

            System.out.print(">> ");
            opSel = stringInput.nextLine().charAt(0);
            switch (opSel) {
                case 'a':
                    operation = "Exit";
                    break;
                case 'b':
                    operation = "Create child";
                    break;
            }
        } else if (tree.getNumChildren() == 0) {                           // In middle, no children
            System.out.println("\nSelect action: ");
            System.out.println("a. Exit program");
            System.out.println("b. Create child node");
            System.out.println("c. Select parent");

            System.out.print(">> ");
            opSel = stringInput.nextLine().charAt(0);
            switch (opSel) {
                case 'a':
                    operation = "Exit";
                    break;
                case 'b':
                    operation = "Create child";
                    break;
                case 'c':
                    operation = "Select parent";
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
                case 'a':
                    operation = "Exit";
                    break;
                case 'b':
                    operation = "Create child";
                    break;
                case 'c':
                    operation = "Select child";
                    break;
                case 'd':
                    operation = "Select parent";
                    break;
            }
        }

        if (operation.equals("Create child")) {                                             // Create child node
            System.out.println("\nWhat value would you like to insert into the tree?");
            userInput = intInput.nextInt();

            tree.addChild(userInput);
        } else if (operation.equals("Select child")) {                                      // Select child
            System.out.println("\nWhich child would you like to select?");

            Vector<BetterNode<Integer>> children = (Vector<BetterNode<Integer>>) tree.getChildren();
            for (int i = 0; i < children.size(); i++) {
                System.out.println("Select " + children.get(i));
            }

            userInput = intInput.nextInt();
            tree = tree.find(userInput);
            System.out.println("Currently in child with data " + tree.getData());
        } else if (operation.equals("Select parent")) {                                     // Select parent
            tree = tree.getParent();
            System.out.println("Currently in parent with data " + tree.getData());
        }

        root.getPostOrderTraversal();

        if (!operation.equals("Exit")) {
            recurse(stringInput, intInput, operation, tree, root);
        }
    }


}