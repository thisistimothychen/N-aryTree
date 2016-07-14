import java.util.ArrayList;
import java.util.List;

/**
 * A BetterNode of any type. A BetterNode contains a data and links to it's children and it's parent.
 *
 * @param <T> The class type of the BetterNode
 */
public class BetterNode<T> {

    private T data;
    private List<BetterNode<T>> children;
    private BetterNode<T> parent;

    public BetterNode(T data) {
        this.data = data;
        this.children = new ArrayList<BetterNode<T>>();
    }

    public BetterNode() {
        this.children = new ArrayList<BetterNode<T>>();
    }

    /**
     * Initialize a BetterNode with another BetterNode's data.
     * This does not copy the BetterNode's children.
     *
     * @param BetterNode The BetterNode whose data is to be copied.
     */
    public BetterNode(BetterNode<T> BetterNode) {
        this.data = BetterNode.getData();
        children = new ArrayList<BetterNode<T>>();
    }

    /**
     * Add a child to this BetterNode.
     *
     * @param child child BetterNode
     */
    public void addChild(BetterNode<T> child) {
        child.setParent(this);
        children.add(child);
    }

    public void setChildren(List<BetterNode<T>> children) {
        for (BetterNode<T> child : children)
            child.setParent(this);

        this.children = children;
    }

    public int numChildren() {
        return this.children.size();
    }

    /**
     * Remove all children of this BetterNode.
     */
    public void removeChildren() {
        this.children.clear();
    }

    /**
     * Remove given child of this BetterNode.
     *
     * @param childToBeDeleted the child BetterNode to remove.
     * @return <code>true</code> if the given BetterNode was a child of this BetterNode and was deleted,
     * <code>false</code> otherwise.
     */
    public boolean removeChild(BetterNode<T> childToBeDeleted) {
        List<BetterNode<T>> list = getChildren();
        return list.remove(childToBeDeleted);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BetterNode<T> getParent() {
        return this.parent;
    }

    public void setParent(BetterNode<T> parent) {
        this.parent = parent;
    }

    public List<BetterNode<T>> getChildren() {
        return this.children;
    }

    public BetterNode<T> getChildAt(int index) {
        return children.get(index);
    }

    //TODO
    public String getBeautifiedTree() {
        String tree = "";

        return tree;
    }

    private void printTraversal(ArrayList<BetterNode<T>> traversal) {
        String output = "[";

        for (BetterNode<T> node : traversal) {
            output += node.toString() + ", ";
        }

        output.substring(0, output.length() - 2);
        output += "]";

        System.out.println(traversal);
    }

    /**
     * Get the list of nodes arranged by the post-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the post-order
     */
    public ArrayList<BetterNode<T>> getPostOrderTraversal() {
        ArrayList<BetterNode<T>> postOrder = new ArrayList<BetterNode<T>>();
        buildPostOrder(this, postOrder);

        printTraversal(postOrder);

        return postOrder;
    }

    private void buildPostOrder(BetterNode<T> node, ArrayList<BetterNode<T>> postOrder) {
        for (BetterNode<T> child : node.getChildren()) {
            buildPostOrder(child, postOrder);
        }
        postOrder.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof BetterNode) {
            if (((BetterNode<?>) obj).getData().equals(this.data))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}