/*
Problem: 76. Minimum Window Substring

-----------------------------------------------------

Problem Statement

Given two strings s and t,
return the minimum window substring of s such that
every character in t (including duplicates) is included.

If no such substring exists, return "".

-----------------------------------------------------

Pattern Used & Why

Pattern: Sliding Window + Frequency Count

Why:
- We need smallest valid window
- Expand → to include chars
- Shrink → to minimize window

-----------------------------------------------------

Key Idea

- Use freq[] to store count of chars of t
- Maintain "required" = number of chars still needed
- Expand right → include chars
- When valid (required == 0) → shrink from left

-----------------------------------------------------

Algorithm / Process

1. Store frequency of t
2. Initialize left = 0
3. Expand right pointer
4. If char needed → decrease required
5. When required == 0:
   - Update answer
   - Shrink window from left
6. Repeat

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        int required = t.length();

        int freq[] = new int[128];

        // fill freq
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        for (int right = 0; right < s.length(); right++) {

            char curr = s.charAt(right);

            // include character
            if (freq[curr] > 0) {
                required--;
            }
            freq[curr]--;

            // shrink window
            while (required == 0) {

                // update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // remove left char
                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
s = "ADOBECODEBANC"
t = "ABC"

Output:
"BANC"

-----------------------------------------------------

Explanation 

I use Sliding Window with a frequency array.

First, I store frequency of characters of string t.

I expand the window using the right pointer:
- If current character is needed, I decrease "required"

When required becomes 0:
- It means current window is valid
- I try to shrink the window from left to make it minimum

While shrinking:
- If removing a character makes window invalid,
  I stop shrinking

This way I always maintain the smallest valid window.
*/
