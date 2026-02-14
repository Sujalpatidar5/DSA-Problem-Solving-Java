/*
GFG - Longest Substring with K Unique Characters

Problem Statement:
Given a string s and an integer k,
find the length of the longest substring
that contains exactly k unique characters.

If no such substring exists, return -1.

--------------------------------------------------

Pattern Used:
Sliding Window (Variable Size - Maximum Type)

--------------------------------------------------

Why this pattern?

- We are dealing with substring (continuous).
- Window size is not fixed.
- We need exactly k unique characters.
- We want maximum length.

So we expand window and shrink only when needed.

--------------------------------------------------

Key Observation:

- Expand window using high pointer.
- Maintain frequency using HashMap.
- If unique characters exceed k → shrink window.
- If unique characters become exactly k → update result.

--------------------------------------------------

Approach:

1. Use two pointers:
   - low  → left boundary
   - high → right boundary
2. Use HashMap to store character frequency.
3. Expand window by moving high.
4. If freq.size() > k → shrink window.
5. If freq.size() == k → update maximum length.
6. If never equal → return -1.

--------------------------------------------------

Algorithm:

1. Initialize:
   low = 0
   res = -1
   freq map

2. For high = 0 to n-1:
       Add s[high] to map

       while map.size() > k:
            Decrease freq of s[low]
            Remove if freq becomes 0
            low++

       if map.size() == k:
            res = max(res, high - low + 1)

3. Return res

--------------------------------------------------

Code:
*/

import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {

        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        int low = 0, res = -1;

        for (int high = 0; high < n; high++) {

            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if more than k unique characters
            while (freq.size() > k) {

                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                low++;
            }

            // Update result if exactly k unique characters
            if (freq.size() == k) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res;
    }
}

/*
--------------------------------------------------

Example:

Input:
s = "aabacbebebe"
k = 3

Output:
7

Explanation:
Longest substring with exactly 3 unique characters:
"cbebebe" → length = 7

--------------------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(k)

--------------------------------------------------

Explanation :

"I used Variable Size Sliding Window.
I expanded the window using high pointer and
maintained character frequency using a HashMap.
If unique characters exceeded k, I shrank the window.
Whenever unique characters became exactly k,
I updated the maximum length.
This gives O(n) time complexity."

--------------------------------------------------
*/
