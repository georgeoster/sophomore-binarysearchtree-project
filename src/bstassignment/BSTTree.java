package bstassignment;

/**
 * Binary Search Tree 
 * created for CSCI 211 
 * author: george oster 
 * last edited: 4/21/15
 */
public class BSTTree {

    
    BSTNode root;
    int height;
    int size = 0;

    
    public BSTTree() {
    }

    //creates BST from an array of integers
    public BSTTree(int[] array) {

        BSTNode[] nodes = new BSTNode[array.length];

        for (int i = 0; i < array.length; i++) {
            nodes[i] = new BSTNode();
            nodes[i].setElement(array[i]);
            insert(nodes[i]);
        }
    }

  /*
    insert(BSTNode toAdd) inserts a node if there is no root 
    otherwise calls insert(BSTNode current, BSTNode toAdd)
    */
    public void insert(BSTNode toAdd) {
        if (root == null) {
            root = toAdd;
            size++;
            toAdd.setDepth(1);
        } else {
            toAdd.setDepth(1);
            insert(root, toAdd);
        }
    }

  /*
    insert(BSTNode current, BSTNode toAdd) inserts a node if the root already exists.
    starts with root and then recursively traverses the BST, branching left or right
    based on < > comparisons, until .getLeft or .getRight == NULL.
    depth and size are adjusted accordingly.
   */
    public void insert(BSTNode current, BSTNode toAdd) {

        if (toAdd.getElement() < current.getElement()) {
            if (current.getLeft() == null) {
                toAdd.setDepth(toAdd.getDepth() + 1);
                current.setLeft(toAdd);
                size++;
            } else {
                toAdd.setDepth(toAdd.getDepth() + 1);
                insert(current.getLeft(), toAdd);
            }
        }

        if (toAdd.getElement() > current.getElement()) {
            if (current.getRight() == null) {
                toAdd.setDepth(toAdd.getDepth() + 1);
                current.setRight(toAdd);
                size++;
            } else {
                toAdd.setDepth(toAdd.getDepth() + 1);
                insert(current.getRight(), toAdd);
            }
        }

    }
/*
    deletion has 4 possible scenarios.
    
    1: todelete has no children
                if todelete is root, set root to null.
                else find if todelete is left or right child of previous node and set NULL accordingly.
                adjust size 
    
    2: todelete has only a right child
                set previous node's right pointer to todelete's right child.
    
    3: todelete has only a left child
                set previous node's left pointer to todelete's left child.
    
    4: todelete has both a left and right child
                node containing min value in right subtree is copied into temp.
                min value is copied into i.
                delete() is recursively called to delete temp.
                todelete's data element is set to i.
                depth and size are decremented accordingly.
        */
    public void delete(BSTTree tree, BSTNode todelete) {
        BSTNode previous = new BSTNode();
        previous = tree.findPreviousNode(tree, todelete);

        // todelete has no children
        if (todelete.getLeft() == null && todelete.getRight() == null) {
            if (tree.size == 1) {
                tree.setRoot(null);
            } else {
                if (previous.getLeft() == todelete) {
                    previous.setLeft(null);
                    tree.size--;
                }
                if (previous.getRight() == todelete) {
                    previous.setRight(null);
                    tree.size--;
                }
            }

        }

        //todelete has only a left child
        if (todelete.getLeft() != null && todelete.getRight() == null) {
            decrementSubtreeDepth(tree, todelete);
            if (previous != null) {
                previous.setLeft(todelete.getLeft());
            }
            if (previous == null) {
                tree.setRoot(todelete.getLeft());
            }
            tree.size--;
        }

        //todelete has only a right child
        if (todelete.getLeft() == null && todelete.getRight() != null) {
            decrementSubtreeDepth(tree, todelete);
            if (previous != null) {
                previous.setRight(todelete.getRight());
            }
            if (previous == null) {
                tree.setRoot(todelete.getRight());
            }
            tree.size--;
        }

        //todelete has two children
        if (todelete.getLeft() != null && todelete.getRight() != null) {
            BSTNode temp = new BSTNode();
            temp = findMin(todelete.getRight());
            int i = temp.getElement();
            delete(tree, temp);
            todelete.setElement(i);
            tree.size--;
        }

    }

    
    //searches BST and returns the node containing i
    public BSTNode search(BSTNode current, int i) {
        BSTNode toreturn = new BSTNode();

        if (i == current.getElement()) {
            System.out.println("the node containing " + current.getElement() + " has been found. it is: " + current.getElement());
            toreturn = current;
        }
        if (i < current.getElement()) {
            if (current.getLeft() == null) {
                System.out.println("that data item does not exist");
            } else {
                search(current.getLeft(), i);
            }
        }

        if (i > current.getElement()) {
            if (current.getRight() == null) {
                System.out.println("that data item does not exist");
            } else {
                search(current.getRight(), i);
            }
        }
        return toreturn;
    }

    
    public void preOrder(BSTNode n) {

        if (n != null) {
            System.out.print(n.getElement() + ", ");
            preOrder(n.getLeft());
            preOrder(n.getRight());
        }
    }

    
    public void inOrder(BSTNode n) {

        if (n != null) {
            inOrder(n.getLeft());
            System.out.print(n.getElement() + ", ");
            inOrder(n.getRight());
        }
    }

    
    public void postOrder(BSTNode n) {

        if (n != null) {
            postOrder(n.getLeft());
            postOrder(n.getRight());
            System.out.print(n.getElement() + ", ");
        }
    }



    //returns the node which contains the max value
    public BSTNode findMax(BSTNode node) {

        if (node.getRight() != null) {
            return findMax(node.getRight());
        } else {
            return node;
        }

    }

    
    //returns the node which contains the min value
    public BSTNode findMin(BSTNode node) {

        if (node.getLeft() != null) {
            return findMin(node.getLeft());
        } else {
            return node;
        }

    }

    
    //finds depth of n
    public int findDepth(BSTNode n) {
        return n.getDepth();
    }

  /*
    height is dynamic.
    adjusting height with every insert and delete would result in less easily readable code.
    so findHeight() traverses through right and left subtree, finds the max height for each,
    and returns whichever is greater.
  */
    
    public int findHeight(BSTTree tree) {
        int currentHeight = 0;
        int rightHeight = 0;
        int leftHeight = 0;
        BSTNode temp = tree.root;

        while (temp != null) {
            temp = temp.getLeft();
            leftHeight++;
        }

        temp = tree.root;

        while (temp != null) {
            temp = temp.getRight();
            rightHeight++;
        }

        if (rightHeight > leftHeight) {
            currentHeight = rightHeight;
        }
        if (leftHeight > rightHeight) {
            currentHeight = leftHeight;
        }
        if (leftHeight == rightHeight) {
            currentHeight = leftHeight;
        }

        return currentHeight;
    }

    
    public void setRoot(BSTNode n) {
        root = n;
    }

  
    //returns the parent of node.
    public BSTNode findPreviousNode(BSTTree tree, BSTNode node) {

        BSTNode previous = new BSTNode();
        previous = null;
        int exit = 0;
        
        if (node == tree.root) {
            exit++;
        }

        BSTNode temp = new BSTNode();
        temp = tree.root;
        
        while (exit < 1) {
            if (node.getElement() < temp.getElement()) {
                if (temp.getLeft() == null){
                    exit++;
                }
                
                if (temp.getLeft().getElement() == node.getElement()) {
                    previous = temp;
                    exit++;
                } else {
                    temp = temp.getLeft();
                }
            }

            if (node.getElement() > temp.getElement()) {
                if (temp.getRight() == null){
                    exit++;
                }
                if (temp.getRight().getElement() == node.getElement()) {
                    previous = temp;
                    exit++;

                } else {
                    temp = temp.getRight();
                }
            }

            if (temp.getLeft() == null && temp.getRight() == null) {
                System.out.println("sorry, that node does not exist in this tree");
                exit++;
            }

        }
        return previous;
    }
    

    //decrements the depth of every node in the subtree of node 
    public void decrementSubtreeDepth(BSTTree tree, BSTNode node) {

        if (node.getLeft() != null) {
            node.getLeft().depth--;
            decrementSubtreeDepth(tree, node.getLeft());
        }
        if (node.getRight() != null) {
            node.getRight().depth--;
            decrementSubtreeDepth(tree, node.getRight());
        }

    }

}
