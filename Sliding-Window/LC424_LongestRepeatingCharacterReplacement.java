/*
LeetCode 424 - Longest Repeating Character Replacement

Problem Statement:
Given a string s and an integer k,
you can replace at most k characters.
Return the length of the longest substring
containing the same letter after replacement.

---------------------------------------

Pattern Used:
Sliding Window (Variable Size - Maximum Type)

Why this pattern?
- We need the longest valid substring.
- Window expands using right pointer.
- If window becomes invalid, shrink from left.
- Condition is based on number of replacements allowed.

---------------------------------------

Key Observation:
In a valid window:

(window size - frequency of most frequent character) <= k

Why?
Because:
We can change all other characters into the most frequent one.
Number of changes needed =
window size - maxFreq

If this exceeds k → window invalid.

---------------------------------------

Approach:
1. Use two pointers:
   - left - start of window
   - right - end of window
2. Use HashMap to store character frequencies.
3. Track maxFreq (highest frequency in current window).
4. If window becomes invalid:
   shrink from left.
5. Update maximum length.

---------------------------------------

Algorithm:
1. Initialize:
   left = 0
   maxFreq = 0
   maxLength = 0
   HashMap<Character, Integer> map
2. Traverse string using right pointer:
   - Add current character to map
   - Update maxFreq
   - While (window size - maxFreq > k):
       shrink window
   - Update maxLength
3. Return maxLength

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1) (since only uppercase letters)

---------------------------------------
*/

import java.util.*;

class Solution {

    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Update most frequent character count
            maxFreq = Math.max(maxFreq, map.get(ch));

            // If replacements required exceed k → shrink window
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            // Update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

/*
---------------------------------------

Example:

Input:
s = "AABABBA"
k = 1

Explanation:
Window expands:
"AABA" → replace one 'B' → "AAAA"
Length = 4

Output:
4

---------------------------------------

Explanation :

"I used sliding window.
At each step, I tracked the most frequent character.
If the number of replacements needed exceeded k,
I shrank the window.
The answer is the maximum valid window size."

---------------------------------------
*/
