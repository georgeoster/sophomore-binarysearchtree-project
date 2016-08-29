package bstassignment;

import java.util.Scanner;

/**
 * Binary Search Tree 
 * created for CSCI 211 
 * author: george oster 
 * last edited: 4/21/15
 */
public class BSTAssignment {

    public static void main(String[] args) {

        Scanner qwerty = new Scanner(System.in);
        String pause;
        BSTTree myTree = new BSTTree();
        BSTNode[] nodes = new BSTNode[100];

        for (int i = 0; i < 100; i++) {
            nodes[i] = new BSTNode();
            nodes[i].setElement(i);
            myTree.insert(nodes[i]);
        }

        System.out.println("\nWe have just created a tree of 100 nodes.");
        System.out.println("They were added sequentially(1 was added, then 2 was added, then 3 was added, etc).");
        System.out.print("Press enter to test findHeight(), getDepth(), findMax(), and findMin(). ");
        pause = qwerty.nextLine();

        System.out.println("\ncurrently, the height is " + myTree.findHeight(myTree));
        System.out.println("the depth of the int 45 is " + nodes[45].getDepth());
        System.out.println("the max is " + myTree.findMax(myTree.root).getElement());
        System.out.println("the min is " + myTree.findMin(myTree.root).getElement());

        System.out.println("\nPress enter to test the search() method. We will first search for");
        System.out.println("an item which does not exist, and then we will search for an item");
        System.out.print("which does exist. Press enter when ready.");
        pause = qwerty.nextLine();

        System.out.println("\nsearching for 5556.");
        myTree.search(myTree.root, 5556);

        System.out.println("searching for 75.");
        myTree.search(myTree.root, 75);

        System.out.println("\nIn this particular BST each node has only a right child. ");
        System.out.println("So, it is silly to test the inOrder(), preOrder(), and postOrder() methods using this BST.");
        System.out.println("Later i will manually hardcode a BST which has left and right children and is several layers deep");
        System.out.println("and we will use this BST to demonstrate the inOrder(), preOrder(), and postOrder() methods.");
        System.out.println("We will now perform the same tests, except with a new BST.  This new BST has had the nodes");
        System.out.println("added in descending order(100 was added, then 99, then 98, etc)");
        System.out.print("Press enter when ready");
        pause = qwerty.nextLine();

        BSTTree reverseTree = new BSTTree();
        BSTNode[] rnodes = new BSTNode[100];

        for (int i = 0; i < 100; i++) {
            rnodes[i] = new BSTNode();
            rnodes[i].setElement(i);
            reverseTree.insert(rnodes[i]);
        }

        System.out.println("\nThe height of this tree is " + reverseTree.findHeight(reverseTree));
        System.out.println("the depth of the int 34 is " + rnodes[34].getDepth());
        System.out.println("the max is " + reverseTree.findMax(reverseTree.root).getElement());
        System.out.println("the min is " + reverseTree.findMin(reverseTree.root).getElement());

        BSTNode one = new BSTNode(1);
        BSTNode two = new BSTNode(2);
        BSTNode three = new BSTNode(3);
        BSTNode four = new BSTNode(4);
        BSTNode five = new BSTNode(5);
        BSTNode six = new BSTNode(6);
        BSTNode seven = new BSTNode(7);

        BSTTree test = new BSTTree();

        test.setRoot(four);
        four.setLeft(two);
        four.setRight(six);
        two.setLeft(one);
        two.setRight(three);
        six.setLeft(five);
        six.setRight(seven);

        System.out.println("\n\nI have now harcoded a new tree with 7 nodes.");
        System.out.println("This tree is full and balanced, so we can demonstrate that  the delete()");
        System.out.println("insert(), and other methods work properly.");
        System.out.println("First we will demonstrate inOrder(), preOrder(), and postOrder().");
        System.out.println("Press enter when ready. ");
        pause = qwerty.nextLine();

        System.out.println("\ninorder: ");
        test.inOrder(test.root);

        System.out.println("\npreorder: ");
        test.preOrder(test.root);

        System.out.println("\npostoder: ");
        test.postOrder(test.root);

        System.out.println("\n\nNow we will delete four, and run inOrder(), preOrder() and postOrder() again");
        System.out.println("Press enter when ready.");
        pause = qwerty.nextLine();

        test.delete(test, four);

        System.out.println("\ninorder: ");
        test.inOrder(test.root);

        System.out.println("\npreorder: ");
        test.preOrder(test.root);

        System.out.println("\npostoder: ");
        test.postOrder(test.root);

        System.out.println("\n\nNow we will insert a new node containing the int 42, and run inOrder(), preOrder() and postOrder() again");
        System.out.println("Press enter when ready.");
        pause = qwerty.nextLine();

        BSTNode fortytwo = new BSTNode(42);
        test.insert(fortytwo);

        System.out.println("\ninorder: ");
        test.inOrder(test.root);

        System.out.println("\npreorder: ");
        test.preOrder(test.root);

        System.out.println("\npostoder: ");
        test.postOrder(test.root);

        System.out.println("\n\nNow we will insert 4 back into the tree and run inOrder(), preOrder() and postOrder() again");
        System.out.println("Press enter when ready.");
        pause = qwerty.nextLine();

        BSTNode newfour = new BSTNode(4);
        test.insert(newfour);

        System.out.println("\ninorder: ");
        test.inOrder(test.root);

        System.out.println("\npreorder: ");
        test.preOrder(test.root);

        System.out.println("\npostoder: ");
        test.postOrder(test.root);

        System.out.println("\n\nEverything has been tested and is working properly");
        System.out.println("Goodnight and good luck.");

    }
}
