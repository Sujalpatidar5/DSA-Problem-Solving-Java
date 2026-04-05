#  Binary Tree 

-----------------------------------------------------

##  What is a Binary Tree?

A Binary Tree is a data structure where each node has:
- At most 2 children
  - Left child
  - Right child

-----------------------------------------------------

##  Types of Binary Trees

- Full Binary Tree
- Complete Binary Tree
- Perfect Binary Tree
- Balanced Binary Tree
- Binary Search Tree (BST)

-----------------------------------------------------

##  Basic Structure

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

-----------------------------------------------------

##  Core Patterns

### 1. DFS (Depth First Search)

Types:
- Preorder → Root Left Right
- Inorder → Left Root Right
- Postorder → Left Right Root

Template:

void dfs(TreeNode root) {
    if (root == null) return;

    // preorder (do work here)

    dfs(root.left);

    // inorder (do work here)

    dfs(root.right);

    // postorder (do work here)
}

-----------------------------------------------------

### 2. BFS (Level Order Traversal)

Using Queue:

Queue<TreeNode> q = new LinkedList<>();
q.add(root);

while (!q.isEmpty()) {
    TreeNode node = q.poll();

    if (node.left != null) q.add(node.left);
    if (node.right != null) q.add(node.right);
}

-----------------------------------------------------

##  Time Complexity

- Traversal → O(n)
- BFS → O(n)
- DFS → O(n)

-----------------------------------------------------

##  Short Interview Explanation

Binary Tree problems are solved using recursion.
At each node, solve left subtree and right subtree and combine.

-----------------------------------------------------
