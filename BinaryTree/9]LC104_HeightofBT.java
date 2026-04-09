/*
Problem: Height of Binary Tree

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
find the height (maximum depth) of the tree.

Height = number of nodes in the longest path from root to leaf.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Height depends on left and right subtree
- Recursively compute both and take max

-----------------------------------------------------

Key Idea

- Height = max(left height, right height) + 1

-----------------------------------------------------

Algorithm / Process

1. If root is null → return 0
2. Find height of left subtree
3. Find height of right subtree
4. Return max(left, right) + 1

-----------------------------------------------------

Code
*/

class Solution {

    int height(Node root) {

        // base case
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
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
   / \
  2   3
 /
4

Output:
3

-----------------------------------------------------

Short Explanation

Height = max depth from root to leaf.
Compute left and right recursively and take max.
*/

-----------------------------------------------------

// Definition for Node

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
