/*
Problem: 98. Validate Binary Search Tree

-----------------------------------------------------

Problem Statement

Given the root of a binary tree,
determine if it is a valid Binary Search Tree (BST).

A BST is valid if:
- Left subtree < root
- Right subtree > root
- Both subtrees are also BST

-----------------------------------------------------

Pattern Used & Why

Pattern: Inorder Traversal

Why:
- Inorder traversal of BST gives sorted order
- If not sorted → not a BST

-----------------------------------------------------

Key Idea

- Perform inorder traversal
- Track previous node
- If current <= previous → invalid BST

-----------------------------------------------------

Algorithm / Process

1. Initialize prev = null
2. Do inorder traversal:
      left → root → right
3. At each node:
      if prev != null AND curr <= prev → return false
4. Update prev = current
5. Continue traversal

-----------------------------------------------------

Code
*/

class Solution {

    TreeNode prev = null;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.val <= prev.val) {
            ans = false;
            return;
        }

        prev = root;

        inorder(root.right);
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
    2
   / \
  1   3

Output:
true

-----------------------------------------------------

Explanation 

I will use inorder traversal.

- In a valid BST, inorder traversal always gives a sorted sequence.

- I maintain a previous node pointer (prev).

- While traversing:
  if current node value <= previous node value,
  then BST property is violated.

- So I mark answer as false.

- Otherwise, I update prev and continue traversal.

- If entire traversal is sorted → tree is valid BST.
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
