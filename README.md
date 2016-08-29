Create a class for a binary search tree named BST.  
Each node in the tree should have data, a reference to the node’s left sub-tree, and a reference to the node’s right sub-tree.
For the purposes of this project, the nodes can be integers. 
The node class of objects can be an inner class of the BST class. 
The BST should have a height property, a size property, which is the number of nodes in the tree, and the following methods:

1. a null constructor 
2. a constructor that builds a tree from a specified array of integers 
3. insert  (add a node to the tree) 
4. delete (remove a specific node from the tree) note: remember to update the height and size properties with insert and delete methods. 
5. search  (given a key value, find the node) 
6. preorder iterate ( list all  nodes in order according to the preorder traversal of the tree) 
7. inorder iterate ( list all  nodes in order according to the inorder traversal of the tree) 
8. postorder iterate ( list all  nodes in order according to the postorder traversal of the tree) 
9. value order iterate ( list all  nodes in order according to key value of each node) 
10. return the maximum value in the tree 
11. return the minimum value in the tree 
12. find the depth of any given node

Test each method to ensure that it works properly.
Generate a binary search with 100 elements added in the correct order 
add 1, then add 2, then add 3, etc.
What is the height of the resulting tree?
Generate a binary search with 100 elements added in reverse order 
add the numbers 100, then 99, then 98, and so on.
What is the height of the resulting tree?
Generate a binary search with 100 randomly generated elements
What is the height of the resulting tree?
