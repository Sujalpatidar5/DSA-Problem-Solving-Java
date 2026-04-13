/*
Problem: 958. Check Completeness of a Binary Tree

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
check whether it is a complete binary tree.

A complete binary tree is:
- All levels completely filled except possibly the last
- Last level nodes are as left as possible

-----------------------------------------------------

Pattern Used & Why

Pattern: BFS (Level Order Traversal)

Why:
- Completeness is level-wise property
- BFS helps check nodes level by level

-----------------------------------------------------

Key Idea

- Once a NULL node is found in BFS:
  → all following nodes must also be NULL

- If we see a NON-NULL node after NULL:
  → NOT complete tree

-----------------------------------------------------

Algorithm / Process

1. Use queue (BFS)
2. Add root
3. Maintain flag → foundNull = false
4. Traverse:
   - If node == null → foundNull = true
   - Else:
       If foundNull already true → return false
       Add left and right children
5. If no violation → return true

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean foundNull = false;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                foundNull = true;
            } 
            else {
                if (foundNull) return false;

                q.add(node.left);
                q.add(node.right);
            }
        }

        return true;
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
   / \
  4   5

Output:
true

-----------------------------------------------------

Explanation

I will use BFS (level order traversal).

- I push nodes into a queue and process level by level.

- If I encounter a NULL node:
  I mark a flag (foundNull = true)

- After this point:
  if I see any NON-NULL node → tree is NOT complete

- Because in a complete tree:
  once a gap (NULL) appears, no further nodes should exist

- If traversal finishes without violation → return true
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
