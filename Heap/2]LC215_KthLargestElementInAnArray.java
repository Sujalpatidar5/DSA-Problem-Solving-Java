/*
Problem: 215. Kth Largest Element in an Array
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

-----------------------------------------------------

Problem Statement

Given an integer array nums and an integer k,
return the kth largest element in the array.

-----------------------------------------------------

Pattern Used & Why

Pattern: Heap (Min Heap of size k)

Why:
We maintain a min heap of size k.
This ensures that the smallest among the k largest elements
is always at the top.

-----------------------------------------------------

Key Idea

- Store first k elements in min heap
- For remaining elements:
    If current element > heap top:
        remove top
        add current element
- Finally, heap top = kth largest

-----------------------------------------------------

Algorithm / Process

1. Create min heap
2. Add first k elements
3. Traverse remaining elements:
      if element > top:
          remove top
          add element
4. Return top

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

        // Step 1: first k elements
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // Step 2: remaining elements
        for (int i = k; i < nums.length; i++) {

            if (nums[i] > pq.peek()) {
                pq.poll();        // remove smallest
                pq.add(nums[i]);  // add larger
            }
        }

        return pq.peek();
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log k)

-----------------------------------------------------

Space Complexity
O(k)

-----------------------------------------------------

Example

Input:
nums = [3,2,1,5,6,4], k = 2

Output:
5

Explanation:
Sorted = [1,2,3,4,5,6]
2nd largest = 5

-----------------------------------------------------

Explanation :

Use min heap of size k.
Keep only k largest elements.
Top of heap gives kth largest.
*/
