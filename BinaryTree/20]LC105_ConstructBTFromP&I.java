/*
Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal

-----------------------------------------------------

Problem Statement

Given two arrays:
- preorder (root → left → right)
- inorder (left → root → right)

Construct and return the binary tree.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Divide & Conquer)

Why:
- Root is always first in preorder
- Inorder helps split left & right subtree

-----------------------------------------------------

Key Idea

- preorder gives root
- inorder splits tree:
      left side → left subtree
      right side → right subtree

-----------------------------------------------------

Algorithm / Process

1. Take root from preorder using index
2. Find root position in inorder
3. Left subtree:
      inorder[left → idx-1]
4. Right subtree:
      inorder[idx+1 → right]
5. Recursively build tree

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    private int preIdx;
    private Map<Integer, Integer> inIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preIdx = 0;
        inIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int left, int right) {

        if (left > right) return null;

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        preIdx++;

        int inIdx = inIndex.get(rootVal);

        root.left = helper(preorder, left, inIdx - 1);
        root.right = helper(preorder, inIdx + 1, right);

        return root;
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
preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]

Output Tree:
        3
       / \
      9  20
         / \
        15  7

-----------------------------------------------------

Explanation 

I will use preorder and inorder properties.

- In preorder:
  first element is always the root.

- I take root from preorder using an index pointer.

- Then I find this root in inorder array.
  This splits the tree into:
    left subtree (elements before root)
    right subtree (elements after root)

- I recursively build:
  left subtree using left part of inorder
  right subtree using right part of inorder

- I use a HashMap to quickly find index in inorder.

- This process continues recursively to build full tree.
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
