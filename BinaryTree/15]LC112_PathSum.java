/*
Problem: 112. Path Sum

-----------------------------------------------------

Problem Statement

Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that
adding up all the values along the path equals targetSum.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Explore all root-to-leaf paths
- Keep track of running sum

-----------------------------------------------------

Key Idea

- Add current node value to sum
- If leaf node → check sum == target
- Otherwise → explore left and right

-----------------------------------------------------

Algorithm / Process

1. Start from root with sum = 0
2. Add current node value
3. If leaf node:
      - check sum == target
4. Else:
      - go left OR right
5. Return true if any path matches

-----------------------------------------------------

Code
*/

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return solve(root, 0, targetSum);
    }

    private boolean solve(TreeNode root, int sum, int target) {

        if (root == null) {
            return false;
        }

        sum += root.val;

        if (root.left == null && root.right == null) {
            return sum == target;
        }

        return solve(root.left, sum, target) || solve(root.right, sum, target);
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
      5
     / \
    4   8
   /   / \
 11   13  4
 / \        \
7   2        1

target = 22

Output:
true

-----------------------------------------------------

 Explanation

Traverse all root-to-leaf paths.
Keep adding values and check at leaf.
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
