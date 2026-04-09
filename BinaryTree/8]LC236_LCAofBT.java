/*
Problem: 236. Lowest Common Ancestor of a Binary Tree

-----------------------------------------------------

Problem Statement

Given a binary tree and two nodes p and q,
find their Lowest Common Ancestor (LCA).

LCA = lowest node that has both p and q as descendants.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Postorder Traversal)

Why:
- Need information from left and right subtree
- Combine results to find LCA

-----------------------------------------------------

Key Idea

- For each node:
    check how many targets (p, q) exist in subtree

- If total >= 2 → this node is LCA

-----------------------------------------------------

Algorithm / Process

1. Traverse tree using recursion
2. For each node:
      - check left subtree
      - check right subtree
      - check self
3. If sum == 2 → mark LCA
4. Return count upwards

-----------------------------------------------------

Code
*/

class Solution {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q);

        return ans;
    }

    private int helper(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);

        int self = (root == p || root == q) ? 1 : 0;

        int total = left + self + right;

        if (total == 2 && ans == null) {
            ans = root;
        }

        return total;
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
      3
     / \
    5   1
   / \ / \
  6  2 0  8

p = 5, q = 1

Output:
3

-----------------------------------------------------

Short Explanation

Count occurrences of p and q in subtrees.
First node where total becomes 2 is LCA.
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
