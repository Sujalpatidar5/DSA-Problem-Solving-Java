/*
Problem: 113. Path Sum II

-----------------------------------------------------

Problem Statement

Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of node values equals targetSum.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS + Backtracking

Why:
- Need to explore all root-to-leaf paths
- Maintain current path and undo after recursion

-----------------------------------------------------

Key Idea

- Traverse all paths using DFS
- Keep track of current path and sum
- At leaf:
    if sum == target → add path to result
- Use backtracking to remove last element

-----------------------------------------------------

Algorithm / Process

1. Start DFS from root
2. Add node to current path
3. Update sum
4. If leaf and sum == target:
      add path to result
5. Recurse left & right
6. Backtrack (remove last element)

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(TreeNode root, int sum, int target,
                       List<Integer> path, List<List<Integer>> ans) {

        if (root == null) return;

        path.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            ans.add(new ArrayList<>(path));
        }

        helper(root.left, sum, target, path, ans);
        helper(root.right, sum, target, path, ans);

        // backtrack
        path.remove(path.size() - 1);
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
  11  13  4
 /  \     / \
7    2   5   1

target = 22

Output:
[[5,4,11,2], [5,8,4,5]]

-----------------------------------------------------

Explanation 

I will use DFS with backtracking.

- I traverse all root-to-leaf paths.

- At each node:
  I add the node value to current path
  and update the running sum.

- If I reach a leaf node:
  and the sum equals target,
  I add this path to the result.

- Then I recursively explore left and right subtrees.

- After exploring:
  I backtrack by removing the last element
  so that the path remains correct for other branches.
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
