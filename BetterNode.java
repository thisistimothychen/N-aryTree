import java.util.Vector;

/**
 * A BetterNode of any type. A BetterNode contains a data and links to it's children and it's parent.
 *
 * @param <T> The class type of the BetterNode
 */
public class BetterNode<T> {

    private T data;
    private int count;
    private Vector<BetterNode<T>> children;
    private BetterNode<T> parent;

    public BetterNode(T data) {
        this.data = data;
        this.count = 1;
        this.children = new Vector<BetterNode<T>>();
    }

    public BetterNode() {
        this.count = 1;
        this.children = new Vector<BetterNode<T>>();
    }

    /**
     * Initialize a BetterNode with another BetterNode's data.
     * This does not copy the BetterNode's children.
     *
     * @param BetterNode The BetterNode whose data is to be copied.
     */
    public BetterNode(BetterNode<T> BetterNode) {
        this.data = BetterNode.getData();
        children = new Vector<BetterNode<T>>();
    }

    /**
     * Add a child to this BetterNode.
     *
     * @param childData for child BetterNode
     */
    public void addChild(T childData) {
        BetterNode<T> childDup = this.find(childData);
        if (childDup != null) {
            childDup.count += 1;
            while (childDup.getParent() != null) {
                childDup.getParent().count += 1;
                childDup = childDup.getParent();
            }
        } else {
            BetterNode<T> child = new BetterNode<T>(childData);
            child.setParent(this);
            children.add(child);

            while (child.getParent() != null) {
                child.getParent().count += 1;
                child = child.getParent();
            }
        }
    }

    public BetterNode<T> find(T data) {
        for (BetterNode<T> node : this.getChildren()) {
            if (node.getData().equals(data)) {
                return node;
            }
        }

        return null;
    }

    public void setChildren(Vector<BetterNode<T>> children) {
        for (BetterNode<T> child : children)
            child.setParent(this);

        this.children = children;
    }

    public int getNumChildren() {
        return this.children.size();
    }

    public int getCount() {
        return this.count;
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
        Vector<BetterNode<T>> Vector = getChildren();
        return Vector.remove(childToBeDeleted);
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

    public Vector<BetterNode<T>> getChildren() {
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

    private void printTraversal(Vector<BetterNode<T>> traversal) {
        System.out.print("PRINTING TREE: ");
        for(BetterNode<T> node : traversal) {
            System.out.print(node.getData() + ":" + node.getCount() + " ");
        }
        System.out.println("");
    }

    /**
     * Get the Vector of nodes arranged by the post-order traversal of the tree.
     *
     * @return The Vector of nodes in the tree, arranged in the post-order
     */
    public Vector<BetterNode<T>> getPostOrderTraversal() {
        Vector<BetterNode<T>> postOrder = new Vector<BetterNode<T>>();
        buildPostOrder(this, postOrder);

        printTraversal(postOrder);

        return postOrder;
    }

    private void buildPostOrder(BetterNode<T> node, Vector<BetterNode<T>> postOrder) {
        for (BetterNode<T> child : node.getChildren()) {
            buildPostOrder(child, postOrder);
        }
        postOrder.add(node);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (null == obj)
//            return false;
//
//        if (obj instanceof BetterNode) {
//            if (((BetterNode<?>) obj).getData().equals(this.data))
//                return true;
//        }
//
//        return false;
//    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof BetterNode) {
            BetterNode<T> other = (BetterNode<T>) obj;

            if (other.getNumChildren() != this.getNumChildren())
                return false;
            else {
                Vector<BetterNode<T>> other_children = other.getChildren();
                Vector<BetterNode<T>> this_children = this.getChildren();
                int this_num_children = this.getNumChildren();

                for (int i = 0; i < this_num_children; i++) {
                    if (!other_children.get(i).equals(this_children.get(i))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}


/*
include count
change to recursion
compare tree
 */