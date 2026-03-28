/*
Problem: Kth Smallest Element (Heap)

-----------------------------------------------------

Problem Statement

Given an array arr[] and an integer k,
find the kth smallest element in the array.

-----------------------------------------------------

Pattern Used & Why

Pattern: Heap (Max Heap of size k)

Why:
We maintain a max heap of size k.
This ensures that the largest among the k smallest elements
is always at the top.

-----------------------------------------------------

Key Idea

- Store first k elements in max heap
- For remaining elements:
    If current element < heap top:
        remove top
        add current element
- Finally, heap top = kth smallest

-----------------------------------------------------

Algorithm / Process

1. Create max heap
2. Add first k elements
3. Traverse remaining elements:
      if element < top:
          remove top
          add element
4. Return top

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    public int kthSmallest(int[] arr, int k) {

        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Step 1: first k elements k log k
        for (int i = 0; i < k; i++) { 
            pq.add(arr[i]);
        }

        // Step 2: remaining elements // n log k
        for (int i = k; i < arr.length; i++) {

            if (arr[i] < pq.peek()) {
                pq.poll();        // remove largest
                pq.add(arr[i]);   // add smaller
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
arr = [7,10,4,3,20,15], k = 3

Output:
7

Explanation:
Sorted array = [3,4,7,10,15,20]
3rd smallest = 7

-----------------------------------------------------

Explanation :

Use max heap of size k.
Keep only k smallest elements.
Top of heap gives kth smallest.
*/
