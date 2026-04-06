/*
Problem: 226. Invert Binary Tree

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
invert the tree (mirror it).

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Swap left and right at each node
- Recursively apply same to subtrees

-----------------------------------------------------

Key Idea

- Swap left and right child
- Then recursively invert left and right

-----------------------------------------------------

Algorithm / Process

1. If root is null → return null
2. Swap left and right
3. Recursively invert left subtree
4. Recursively invert right subtree
5. Return root

-----------------------------------------------------

Code
*/

class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(n)

-----------------------------------------------------

Example

Input:
    4
   / \
  2   7
 / \ / \
1  3 6  9

Output:
    4
   / \
  7   2
 / \ / \
9  6 3  1

-----------------------------------------------------

Short Interview Explanation

Swap left and right at each node recursively.
*/

-----------------------------------------------------

// Definition for TreeNode

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
