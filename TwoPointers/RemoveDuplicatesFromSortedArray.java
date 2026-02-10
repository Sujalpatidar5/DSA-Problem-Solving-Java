/*
LeetCode 26 - Remove Duplicates from Sorted Array

Pattern Used:
Two Pointers

Problem Statement:
Given a sorted integer array `nums`, remove the duplicates in-place
such that each unique element appears only once.
Return the number of unique elements.
The relative order of the elements should be kept the same.

Approach:
- Since the array is already sorted, duplicates will be adjacent.
- Use two pointers:
  - `left` → points to the last unique element position.
  - `right` → scans the array to find new unique elements.
- When nums[right] != nums[right - 1]:
  - It means a new unique element is found.
  - Place it at nums[left + 1].
  - Increment `left` and `count`.

Algorithm:
1. Initialize:
   - left = 0
   - right = 1
   - count = 1 (first element is always unique)
2. While right < nums.length:
   a. If nums[right] == nums[right - 1]:
      - Duplicate found → move right.
   b. Else:
      - Copy nums[right] to nums[left + 1]
      - left++, count++
      - move right
3. Return count.

Time Complexity:
O(n)

Space Complexity:
O(1) (in-place modification)

Why Two Pointers works here?
Because the array is sorted, duplicates are consecutive.
One pointer tracks unique elements while the other scans the array.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int count = 1;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                right++;
                continue;
            }

            nums[left + 1] = nums[right];
            left++;
            count++;
            right++;
        }

        return count;
    }
}
