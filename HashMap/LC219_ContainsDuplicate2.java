/*
Problem: 219. Contains Duplicate II
Link: https://leetcode.com/problems/contains-duplicate-ii/

-----------------------------------------------------

Problem Statement

Given an integer array nums and an integer k,
return true if there are two distinct indices i and j such that:

nums[i] == nums[j] AND
|i - j| <= k

Otherwise return false.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap (Value → Last Index)

Why:
We store the last seen index of each number.
If the same number appears again, we can quickly check
the index difference.

-----------------------------------------------------

Key Idea

For each element:
1. If it already exists → check index difference.
2. If difference <= k → return true.
3. Otherwise update its latest index.

-----------------------------------------------------

Algorithm / Process

1. Create a HashMap<Integer, Integer>.
2. Traverse the array.
3. For each element:
      If it exists in map:
          calculate difference = currentIndex - previousIndex
          if difference <= k → return true
4. Update map with current index.
5. If no valid pair found → return false.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                int diff = i - map.get(nums[i]);

                if (diff <= k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

Each element is processed once.

-----------------------------------------------------

Space Complexity
O(n)

For storing elements in HashMap.

-----------------------------------------------------

Example

Input:
nums = [1,2,3,1], k = 3

Output:
true

Explanation:
nums[0] == nums[3]
|0 - 3| = 3 <= k

-----------------------------------------------------

Explanation :

Use a HashMap to store the last index of each number.
When a duplicate is found, check if the index difference
is within k. If yes, return true.
*/
