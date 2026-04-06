/*
Problem: 102. Binary Tree Level Order Traversal

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
return the level order traversal of its nodes' values.

(Level by level traversal)

-----------------------------------------------------

Pattern Used & Why

Pattern: BFS (Queue)

Why:
- We need to traverse level by level
- Queue helps process nodes in order

-----------------------------------------------------

Key Idea

- Use queue
- Process nodes level by level
- For each level → store values separately

-----------------------------------------------------

Algorithm / Process

1. If root is null → return empty list
2. Add root to queue
3. While queue not empty:
      - get size of queue (level size)
      - loop size times:
            remove node
            add value
            push children
      - add level to result

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.remove();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(level);
        }

        return result;
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
  9  20
     / \
    15  7

Output:
[[3],[9,20],[15,7]]

-----------------------------------------------------

Short Interview Explanation

Use queue (BFS).
Process nodes level by level using queue size.
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
