/*
Problem: 103. Binary Tree Zigzag Level Order Traversal

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
return the zigzag level order traversal of its nodes' values.

(Zigzag = alternate left-to-right and right-to-left)

-----------------------------------------------------

Pattern Used & Why

Pattern: BFS (Level Order Traversal)

Why:
- Traverse tree level by level using queue
- Reverse alternate levels for zigzag effect

-----------------------------------------------------

Key Idea

- Use queue for level order
- Use flag to track direction
- Reverse level when needed

-----------------------------------------------------

Algorithm / Process

1. If root is null → return empty list
2. Use queue and add root
3. While queue not empty:
      - Get size (level nodes)
      - Traverse all nodes of level
      - Add children to queue
4. If flag is true → reverse level
5. Add level to result
6. Flip flag

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.remove();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (flag == true) {
                Collections.reverse(level);
            }

            result.add(level);
            flag = !flag;
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
[[3], [20,9], [15,7]]

-----------------------------------------------------

Short  Explanation

Use level order traversal.
Reverse alternate levels using a flag.
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
