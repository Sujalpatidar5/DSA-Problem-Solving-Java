/*
Problem: 129. Sum Root to Leaf Numbers

-----------------------------------------------------

Problem Statement

Given the root of a binary tree where each node contains a digit (0–9),
each root-to-leaf path represents a number.

Return the total sum of all root-to-leaf numbers.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Recursion)

Why:
- Traverse all root-to-leaf paths
- Build number along the path

-----------------------------------------------------

Key Idea

- At each node → build number:
      curr = curr * 10 + node.val
- At leaf → add to answer

-----------------------------------------------------

Algorithm / Process

1. Start from root with curr = 0
2. At each node:
      curr = curr * 10 + node.val
3. If leaf node:
      add curr to answer
4. Recurse left and right

-----------------------------------------------------

Code
*/

class Solution {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return ans;
    }

    private void solve(TreeNode root, int currPath) {

        if (root == null) {
            return;
        }

        currPath = currPath * 10 + root.val;

        if (root.left == null && root.right == null) {
            ans += currPath;
        }

        solve(root.left, currPath);
        solve(root.right, currPath);
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

Paths:
1→2 = 12
1→3 = 13

Output:
25

-----------------------------------------------------

Explanation

Build number while traversing.
At leaf, add to result.
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
