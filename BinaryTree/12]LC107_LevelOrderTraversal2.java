/*
Problem: 107. Binary Tree Level Order Traversal II

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
return the bottom-up level order traversal.

(From last level to root)

-----------------------------------------------------

Pattern Used & Why

Pattern: BFS (Level Order Traversal)

Why:
- Traverse level by level using queue
- Insert each level at front for reverse order

-----------------------------------------------------

Key Idea

- Normal level order traversal
- Instead of reversing at end → insert at front

-----------------------------------------------------

Algorithm / Process

1. If root is null → return empty list
2. Use queue and add root
3. While queue not empty:
      - Get size (level nodes)
      - Traverse all nodes of level
      - Add children to queue
4. Insert level at index 0
5. Return result

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

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

            result.add(0, level); // add in front
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
  9   20
     /  \
    15   7

Output:
[[15,7], [9,20], [3]]

-----------------------------------------------------

Short Explanation

Use level order traversal.
Insert each level at front instead of reversing later.
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
