/*
Problem: 108. Convert Sorted Array to Binary Search Tree

-----------------------------------------------------

Problem Statement

Given an integer array nums sorted in ascending order,
convert it into a height-balanced Binary Search Tree.

-----------------------------------------------------

Pattern Used & Why

Pattern: Divide & Conquer (Recursion)

Why:
- Middle element becomes root
- Left half → left subtree
- Right half → right subtree
- Ensures balanced BST

-----------------------------------------------------

Key Idea

- Pick middle element as root
- Recursively build left and right subtrees
- This guarantees minimum height (balanced)

-----------------------------------------------------

Algorithm / Process

1. Take start and end index
2. Find mid = (start + end) / 2
3. Create node with nums[mid]
4. Recursively build:
   - left subtree → start to mid-1
   - right subtree → mid+1 to end

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    public static TreeNode createBST(int[] nums, int start, int end) {

        // base case
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid + 1, end);

        return root;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(log n) (recursion stack)

-----------------------------------------------------

Example

Input:
nums = [-10, -3, 0, 5, 9]

Output:
Balanced BST

-----------------------------------------------------

Explanation 

I use divide and conquer.

Since array is sorted:
- Middle element should be root to keep tree balanced

Then:
- Left half forms left subtree
- Right half forms right subtree

I recursively repeat this process,
which ensures height-balanced BST.
*/
