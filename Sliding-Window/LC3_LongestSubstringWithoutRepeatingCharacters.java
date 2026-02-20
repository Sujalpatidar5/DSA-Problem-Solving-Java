/*
LeetCode 3 - Longest Substring Without Repeating Characters

Problem Statement:
Given a string s, return the length of the longest
substring without repeating characters.

---------------------------------------

Pattern Used:
Sliding Window (Variable Size) + HashSet

Why this pattern?
- We need longest substring (continuous).
- Condition: no repeating characters.
- Window size changes dynamically.
- HashSet helps check duplicates in O(1).

---------------------------------------

Key Observation:
- Expand window using right pointer.
- If duplicate character found:
    shrink window from left
    until duplicate is removed.
- Keep updating maximum length.

---------------------------------------

Approach:
1. Use two pointers:
   - left → start of window
   - right → end of window
2. Use HashSet to store characters in current window.
3. If duplicate appears:
   - Remove characters from left
   - Move left forward
4. Update max length at each step.

---------------------------------------

Algorithm:
1. Initialize:
   left = 0
   maxLen = 0
   HashSet<Character> set
2. Traverse string using right pointer:
   - While set contains current character:
       remove s[left]
       left++
   - Add current character to set
   - Update maxLen
3. Return maxLen

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1) (at most 128 ASCII characters)

---------------------------------------
*/

import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int left = 0, maxLen = 0;

        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {

            char c = s.charAt(right);

            // shrink window if duplicate found
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // add current character
            set.add(c);

            // update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

/*
---------------------------------------

Example:

Input:
s = "abcabcbb"

Window movement:
"abc" → valid
"abca" → duplicate 'a' → shrink
Continue...

Longest substring:
"abc"

Output:
3

---------------------------------------

 Explanation :

"I used sliding window with a HashSet.
I expanded the window using the right pointer.
If a duplicate character appeared,
I removed characters from the left
until the window became valid again.
I updated the maximum length at each step."

---------------------------------------
*/
