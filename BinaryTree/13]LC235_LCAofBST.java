/*
Problem: 235. Lowest Common Ancestor of a Binary Search Tree

-----------------------------------------------------

Problem Statement

Given a Binary Search Tree (BST) and two nodes p and q,
find their Lowest Common Ancestor (LCA).

-----------------------------------------------------

Pattern Used & Why

Pattern: BST + DFS

Why:
- BST property helps reduce search space
- No need to traverse entire tree

-----------------------------------------------------

Key Idea

- If both p and q are smaller → go left
- If both p and q are greater → go right
- Else → current node is LCA

-----------------------------------------------------

Algorithm / Process

1. If root is null → return null
2. If both p and q < root → go left
3. If both p and q > root → go right
4. Else → root is answer

-----------------------------------------------------

Code
*/

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // both at right side
        if (root.val < p.val && root.val < q.val) {
            return helper(root.right, p, q);
        }

        // both at left side
        if (root.val > p.val && root.val > q.val) {
            return helper(root.left, p, q);
        }

        // split point (LCA)
        return root;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(h)  (h = height of tree)

-----------------------------------------------------

Space Complexity
O(h)

-----------------------------------------------------

Example

Input:
      6
     / \
    2   8
   / \ / \
  0  4 7  9

p = 2, q = 8

Output:
6

-----------------------------------------------------

Short Explanation

Use BST property.
If both nodes on same side → move there.
Else current node is LCA.
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
