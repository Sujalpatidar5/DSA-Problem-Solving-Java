/*
Problem: 101. Symmetric Tree

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
check whether it is symmetric (mirror of itself).

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Compare left subtree with right subtree (mirror)
- Check symmetry recursively

-----------------------------------------------------

Key Idea

- Root is symmetric if:
      left subtree == mirror of right subtree

- Compare:
      left.left ↔ right.right
      left.right ↔ right.left

-----------------------------------------------------

Algorithm / Process

1. If root is null → return true
2. Call helper(left, right)
3. In helper:
      - if both null → true
      - if one null → false
      - if values differ → false
      - check:
            left.left vs right.right
            left.right vs right.left

-----------------------------------------------------

Code
*/

class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        boolean r1 = isMirror(root1.left, root2.right);
        boolean r2 = isMirror(root1.right, root2.left);

        if (r1 == true && r2 == true) {
            return true;
        }

        return false;
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
  2   2
 / \ / \
3  4 4  3

Output:
true

-----------------------------------------------------

Short Interview Explanation

Compare left and right subtree in mirror fashion.
Left-left with right-right and left-right with right-left.
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
