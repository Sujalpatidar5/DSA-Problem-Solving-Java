/*
Problem: 94. Binary Tree Inorder Traversal

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
return the inorder traversal of its nodes' values.

Inorder Traversal:
Left → Root → Right

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Tree problems follow recursion naturally
- Visit left subtree first, then node, then right

-----------------------------------------------------

Key Idea

- First go to left subtree
- Then visit current node
- Then go to right subtree

-----------------------------------------------------

Algorithm / Process

1. If root is null → return
2. Traverse left subtree
3. Add root value
4. Traverse right subtree

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {

        // base case
        if (root == null) return;

        // Left
        dfs(root.left, res);

        // Root
        res.add(root.val);

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
[1,3,2]

-----------------------------------------------------

Short Interview Explanation

Traverse left subtree first,
then visit node,
then traverse right subtree.
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
