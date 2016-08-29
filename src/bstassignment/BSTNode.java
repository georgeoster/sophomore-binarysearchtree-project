package bstassignment;

/**
 * Binary Search Tree 
 * created for CSCI 211 
 * author: george oster 
 * last edited: 4/21/15
 */
public class BSTNode {

    int element;
    int depth;
    BSTNode left;
    BSTNode right;

    public BSTNode() {
    }

    public BSTNode(int e) {
        element = e;
    }

    public int getElement() {
        return element;
    }

    public int getDepth() {
        return depth;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setElement(int e) {
        element = e;
    }

    public void setDepth(int d) {
        depth = d;
    }

    public void setLeft(BSTNode l) {
        left = l;
    }

    public void setRight(BSTNode r) {
        right = r;
    }

}
