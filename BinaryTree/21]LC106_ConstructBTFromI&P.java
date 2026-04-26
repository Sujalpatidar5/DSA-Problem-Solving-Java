/*
Problem: 106. Construct Binary Tree from Inorder and Postorder Traversal

-----------------------------------------------------

Problem Statement

Given two arrays:
- inorder (left → root → right)
- postorder (left → right → root)

Construct and return the binary tree.

-----------------------------------------------------

Pattern Used & Why

Pattern: DFS (Divide & Conquer)

Why:
- Root is always last in postorder
- Inorder helps split left & right subtree

-----------------------------------------------------

Key Idea

- postorder gives root (LAST element)
- inorder splits tree:
      left side → left subtree
      right side → right subtree

-----------------------------------------------------

Algorithm / Process

1. Take root from postorder (last element)
2. Find root position in inorder
3. IMPORTANT:
      Build RIGHT subtree first
      then LEFT subtree
4. Recursively construct tree

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    int postIdx;
    Map<Integer, Integer> inIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIdx = postorder.length - 1;

        inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int low, int high) {

        if (low > high) return null;

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int inIdx = inIndex.get(rootVal);

        // build RIGHT first
        root.right = helper(postorder, inIdx + 1, high);

        // then LEFT
        root.left = helper(postorder, low, inIdx - 1);

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
inorder   = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Output Tree:
        3
       / \
      9  20
         / \
        15  7

-----------------------------------------------------

Explanation 

I will use postorder and inorder properties.

- In postorder:
  last element is always the root.

- I pick root from postorder using a pointer (postIdx).

- Then I find this root in inorder array,
  which splits tree into left and right parts.

- IMPORTANT:
  Since we are moving backward in postorder,
  I must build RIGHT subtree first,
  then LEFT subtree.

- I recursively build both subtrees.

- HashMap is used for O(1) index lookup in inorder.
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
