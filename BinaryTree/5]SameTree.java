/*
Problem: 100. Same Tree

-----------------------------------------------------

Problem Statement

Given two binary trees p and q,
check whether they are the same or not.

Two trees are same if:
- Structure is same
- Values are same

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Compare node by node
- Recursively check left and right subtrees

-----------------------------------------------------

Key Idea

- If both nodes are null → true
- If one is null → false
- If values differ → false
- Otherwise:
      check left and right

-----------------------------------------------------

Algorithm / Process

1. If both null → return true
2. If one null → return false
3. If values not equal → return false
4. Recursively check:
      left subtree
      right subtree
5. If both true → return true

-----------------------------------------------------

Code
*/

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // base case 1 → both null
        if (p == null && q == null) return true;

        // base case 2 → one null
        if (p == null || q == null) return false;

        // base case 3 → value mismatch
        if (p.val != q.val) return false;

        boolean r1 = isSameTree(p.left, q.left);
        boolean r2 = isSameTree(p.right, q.right);

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
p = [1,2,3]
q = [1,2,3]

Output:
true

-----------------------------------------------------

Short Interview Explanation

Compare nodes recursively.
Check structure and values both.
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
