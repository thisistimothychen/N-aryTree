/**
 * Created by Timothy Chen on 7/13/16.
 */
public class Test {

    public static void main(String[] args) {
        Tree<Integer> myTree1 = new Tree(new Node(new Integer(10)));
        myTree1.insertValue(5);
        myTree1.insertValue(6);
        myTree1.insertValue(8);
        myTree1.insertValue(7);
        myTree1.insertValue(5);
        myTree1.insertValue(5);


        Tree<Integer> myTree2 = new Tree(new Node(new Integer(10)));
        myTree2.insertValue(9);

        System.out.println(myTree1.getLongestPathFromRootToAnyLeaf());
        System.out.println(myTree2.getLongestPathFromRootToAnyLeaf());
        System.out.println(myTree2.equals(myTree1));

        System.out.println("Select ")
    }

}
