/*
Problem: 653. Two Sum IV - Input is a BST

-----------------------------------------------------

Problem Statement

Given the root of a Binary Search Tree and an integer k,
return true if there exist two elements in the BST such that their sum = k.

-----------------------------------------------------

Pattern Used & Why

Pattern: Inorder + Two Pointers

Why:
- Inorder traversal of BST → sorted array
- Then apply two-pointer technique

-----------------------------------------------------

Key Idea

- Convert BST → sorted list using inorder
- Use two pointers to find sum = k

-----------------------------------------------------

Algorithm / Process

1. Do inorder traversal → store values in list
2. Use two pointers:
      left = 0, right = n-1
3. While left < right:
      - if sum == k → true
      - if sum < k → left++
      - if sum > k → right--
4. Return false if not found

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean findTarget(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        if (list.size() < 2) return false;

        int left = 0, right = list.size() - 1;

        while (left < right) {

            if (list.get(left) + list.get(right) == k) {
                return true;
            } 
            else if (list.get(left) + list.get(right) < k) {
                left++;
            } 
            else {
                right--;
            }
        }

        return false;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
  3   6
 / \   \
2   4   7

k = 9

Output:
true

-----------------------------------------------------

Short Explanation

Convert BST to sorted list using inorder.
Then use two-pointer to find pair with sum k.
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
