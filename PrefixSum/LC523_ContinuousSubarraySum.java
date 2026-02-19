/*
LeetCode 523 - Continuous Subarray Sum

Problem Statement:
Given an integer array nums and an integer k,
return true if there exists a continuous subarray
of size at least 2 whose sum is a multiple of k.

---------------------------------------

Pattern Used:
Prefix Sum + HashMap

Why this pattern?
- We need to check if a subarray sum is divisible by k.
- If two prefix sums have the same remainder when divided by k,
  then their difference is divisible by k.
- That difference represents a valid subarray.

---------------------------------------

Key Observation:
If:

prefix[j] % k == prefix[i] % k

Then:

(prefix[j] - prefix[i]) % k == 0

Meaning:
Subarray between (i+1 to j) is divisible by k.

---------------------------------------

Approach:
1. Maintain a running prefix sum.
2. Store remainder (prefix % k) in a HashMap.
3. If same remainder appears again:
   - Check if subarray length >= 2.
   - If yes, return true.
4. Store only first occurrence of remainder.

---------------------------------------

Algorithm:
1. Initialize:
   - sum = 0
   - HashMap to store remainder → index
   - Put (0, -1) in map
2. Traverse array:
   - Update sum
   - Compute remainder = sum % k
   - If remainder already exists:
       check length condition
   - Else:
       store remainder with index
3. Return false if no valid subarray found.

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(n)

---------------------------------------
*/

import java.util.*;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> rem = new HashMap<>();

        // Important: handles subarray starting from index 0
        rem.put(0, -1);

        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];

            int remainder = sum % k;

            if (rem.containsKey(remainder)) {

                // Check if subarray length >= 2
                if (i - rem.get(remainder) >= 2) {
                    return true;
                }

            } else {
                // Store only first occurrence
                rem.put(remainder, i);
            }
        }

        return false;
    }
}

/*
---------------------------------------

Example:

Input:
nums = [23, 2, 4, 6, 7]
k = 6

Prefix Remainders:
23 % 6 = 5
25 % 6 = 1
29 % 6 = 5   ← same remainder appeared again

Subarray [2,4] sum = 6
6 % 6 = 0

Output:
true

---------------------------------------

Explanation :

"I used prefix sum and stored remainder of prefix % k.
If the same remainder appears again,
it means the subarray between them is divisible by k.
I also checked that the subarray length is at least 2."

---------------------------------------
*/
