/*
Problem: 347. Top K Frequent Elements
Link: https://leetcode.com/problems/top-k-frequent-elements/

-----------------------------------------------------

Problem Statement

Given an integer array nums and an integer k,
return the k most frequent elements.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap + Heap (Min Heap of size k)

Why:
- HashMap → count frequency
- Min Heap → keep only top k frequent elements

-----------------------------------------------------

Key Idea

1. Count frequency using HashMap
2. Use min heap of size k (based on frequency)
3. If heap size exceeds k → remove smallest freq
4. Heap will contain k most frequent elements

-----------------------------------------------------

Algorithm / Process

1. Build frequency map
2. Create min heap based on frequency
3. Traverse map:
      add pair(num, freq)
      if size > k → remove smallest
4. Extract elements from heap

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    class Pair {
        int num;
        int freq;

        Pair(int n, int f) {
            this.num = n;
            this.freq = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Step 2: Min Heap of size k
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq   // smallest freq on top
        );

        // Step 3: Insert ONLY k highest frequency items
        for (int key : freq.keySet()) {
            pq.add(new Pair(key, freq.get(key)));

            if (pq.size() > k) {
                pq.remove(); // remove smallest freq
            }
        }

        // Step 4: Extract result
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            ans[i++] = p.num;
        }

        return ans;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log k)

-----------------------------------------------------

Space Complexity
O(n)

-----------------------------------------------------

Example

Input:
nums = [1,1,1,2,2,3], k = 2

Output:
[1,2]

-----------------------------------------------------

Explanation :

Use HashMap to count frequency.
Use min heap of size k to store top k frequent elements.
Remove smallest freq when size exceeds k.
*/
