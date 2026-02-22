/*
LeetCode 438 - Find All Anagrams in a String

Problem Statement:
Given two strings s and p,
return all start indices of p's anagrams in s.

---------------------------------------

Pattern Used:
Sliding Window (Fixed Size) + Frequency Array

Why this pattern?
- Window size is fixed (k = p.length()).
- We compare character frequency.
- Instead of sorting every time (O(k log k)),
  we use a frequency array of size 26.

---------------------------------------

Key Observation:

If frequency array becomes all zeros,
that means current window is an anagram.

We:
1) Add frequency of p
2) Subtract frequency of current window
3) If all values = 0 → anagram found

---------------------------------------

Approach:

1. Create frequency array of size 26.
2. Add frequency of string p.
3. Build first window of size k in s.
4. If freq array becomes all zero → add index 0.
5. Slide window:
   - Add new character (right)
   - Remove old character (left)
   - Check frequency again
6. Return result list.

---------------------------------------

Time Complexity:
O(n * 26) → O(n)

Space Complexity:
O(1)

---------------------------------------
*/

import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int freq[] = new int[26];

        int k = p.length();
        int n = s.length();

        if (n < k) return list;

        // Step 1: Add frequency of p
        for (int i = 0; i < k; i++) {
            freq[p.charAt(i) - 'a']++;
        }

        // Step 2: Build first window
        for (int i = 0; i < k; i++) {
            freq[s.charAt(i) - 'a']--;
        }

        // Step 3: Check first window
        if (checkAll(freq)) {
            list.add(0);
        }

        // Step 4: Slide window
        for (int right = k; right < n; right++) {

            // Add new element
            freq[s.charAt(right) - 'a']--;

            // Remove old left element
            freq[s.charAt(right - k) - 'a']++;

            if (checkAll(freq)) {
                list.add(right - k + 1);
            }
        }

        return list;
    }

    public boolean checkAll(int freq[]) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
}

/*
---------------------------------------

Example:

Input:
s = "cbaebabacd"
p = "abc"

Output:
[0, 6]

Explanation:
Substring at index 0 → "cba"
Substring at index 6 → "bac"
Both are anagrams of "abc"

---------------------------------------

 Explanation :

"I used fixed size sliding window.
I maintained a frequency array of size 26.
If all values become zero,
it means current window is an anagram."

---------------------------------------
*/
