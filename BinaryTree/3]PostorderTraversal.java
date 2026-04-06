/*
Problem: 145. Binary Tree Postorder Traversal

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
return the postorder traversal of its nodes' values.

Postorder Traversal:
Left → Right → Root

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Tree problems are naturally recursive
- Process children first, then parent

-----------------------------------------------------

Key Idea

- First go to left subtree
- Then go to right subtree
- Then visit current node

-----------------------------------------------------

Algorithm / Process

1. If root is null → return
2. Traverse left subtree
3. Traverse right subtree
4. Add root value

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        dfs(root, res);

        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {

        // base case
        if (root == null) return;

        // Left
        dfs(root.left, res);

        // Right
        dfs(root.right, res);

        // Root
        res.add(root.val);
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
[3,2,1]

-----------------------------------------------------

Short Interview Explanation

Traverse left subtree,
then right subtree,
then visit node at last.
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
