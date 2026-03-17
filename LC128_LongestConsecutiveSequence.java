/*
Problem: 128. Longest Consecutive Sequence
Link: https://leetcode.com/problems/longest-consecutive-sequence/

-----------------------------------------------------

Problem Statement

Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashSet

Why:
We need fast lookup (O(1)) to check if a number exists.
HashSet helps in checking consecutive elements efficiently.

-----------------------------------------------------

Key Idea

1. Store all numbers in a HashSet.
2. Only start counting when current number is the start of sequence:
      (num - 1) should NOT exist.
3. Then count forward (num + 1, num + 2...).
4. Track maximum length.

-----------------------------------------------------

Algorithm / Process

1. Insert all elements into HashSet.
2. Initialize maxLength = 0.
3. Traverse each number in set:
      If (num - 1) NOT present → start sequence
4. Count length while (num + 1 exists)
5. Update maxLength.
6. Return maxLength.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // Step 2: check for sequences
        for (int num : set) {

            // start of sequence
            if (!set.contains(num - 1)) {

                int length = 1;
                int current = num;

                // count consecutive numbers
                while (set.contains(current + 1)) {
                    current += 1;
                    length += 1;
                }

                // update max length
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

Each element is processed at most twice.

-----------------------------------------------------

Space Complexity
O(n)

For storing elements in HashSet.

-----------------------------------------------------

Example

Input:
nums = [100,4,200,1,3,2]

Output:
4

Explanation:
Sequence = [1,2,3,4]

-----------------------------------------------------

Explanation :

Store all elements in a HashSet. Start counting only from numbers
that are the beginning of a sequence (num - 1 not present).
Then expand forward and track maximum length.
*/
