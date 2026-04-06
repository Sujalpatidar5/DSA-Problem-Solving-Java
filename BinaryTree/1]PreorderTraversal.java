/*
Problem: 144. Binary Tree Preorder Traversal

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
return the preorder traversal of its nodes' values.

Preorder Traversal:
Root → Left → Right

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Tree problems are naturally recursive
- Visit node, then left, then right

-----------------------------------------------------

Key Idea

- Visit current node first
- Then traverse left subtree
- Then traverse right subtree

-----------------------------------------------------

Algorithm / Process

1. If root is null → return
2. Add root value to result
3. Traverse left subtree
4. Traverse right subtree

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {

        // base case
        if (root == null) return;

        // preorder → Root
        res.add(root.val);

        // Left
        dfs(root.left, res);

        // Right
        dfs(root.right, res);
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
    1
     \
      2
     /
    3

Output:
[1,2,3]

-----------------------------------------------------

Short Interview Explanation

Visit root first, then left subtree, then right subtree using recursion.
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
