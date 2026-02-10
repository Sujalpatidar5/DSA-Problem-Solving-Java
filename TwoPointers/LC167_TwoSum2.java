/*
LeetCode 167 - Two Sum II (Input Array Is Sorted)

Pattern Used:
Two Pointers

Problem Statement:
Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Return the indices of the two numbers (1-based indexing).

Approach:
- Since the array is sorted, we can use two pointers.
- One pointer starts from the beginning (left).
- Another pointer starts from the end (right).
- Calculate sum of elements at both pointers.
    - If sum == target → answer found.
    - If sum < target → move left pointer forward to increase sum.
    - If sum > target → move right pointer backward to decrease sum.
- This avoids using extra space like HashMap.

Algorithm:
1. Initialize left = 0, right = numbers.length - 1.
2. While left < right:
   a. Compute sum = numbers[left] + numbers[right].
   b. If sum == target → return indices.
   c. If sum < target → left++.
   d. Else → right--.
3. Return result array.

Time Complexity:
O(n)

Space Complexity:
O(1) (constant extra space)

Why Two Pointers works here?
Because the array is sorted, moving pointers intelligently guarantees
we explore all valid pairs in linear time.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because problem expects 1-based indexing
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;   // need bigger sum
            } else {
                right--;  // need smaller sum
            }
        }

        return result;
    }
}
