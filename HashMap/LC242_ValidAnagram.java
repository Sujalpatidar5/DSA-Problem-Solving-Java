/*
Problem: 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/

-----------------------------------------------------

Problem Statement
Given two strings s and t, return true if t is an anagram of s,
and false otherwise.

An Anagram means both strings contain exactly the same characters
with the same frequency, but possibly in a different order.

-----------------------------------------------------

Pattern Used & Why
Pattern: HashMap (Frequency Counting)

Why:
To count the frequency of characters in both strings and verify
that each character appears the same number of times.

-----------------------------------------------------

Key Idea

1. Count frequency of characters in string s.
2. Decrease frequency using characters of string t.
3. If both strings are anagrams, all frequencies will become 0.

-----------------------------------------------------

Algorithm / Process

1. If lengths of s and t are different → return false.
2. Create a HashMap<Character, Integer>.
3. Traverse string s and increase frequency of each character.
4. Traverse string t and decrease frequency of each character.
5. Check the map:
   if any character frequency ≠ 0 → return false.
6. Otherwise return true.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // count characters of s
        for (int i = 0; i < s.length(); i++) {
            char y = s.charAt(i);
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        // subtract characters of t
        for (int i = 0; i < t.length(); i++) {
            char x = t.charAt(i);
            map.put(x, map.getOrDefault(x, 0) - 1);
        }

        // check frequencies
        for (char ch : map.keySet()) {
            if (map.get(ch) != 0)
                return false;
        }

        return true;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

We traverse both strings once.

-----------------------------------------------------

Space Complexity
O(1)

At most 26 lowercase characters are stored in the map.

-----------------------------------------------------

Example

Input:
s = "anagram"
t = "nagaram"

Output:
true

Explanation:
Both strings contain the same characters with same frequency.

-----------------------------------------------------

Explanation :

Use a HashMap to count the frequency of characters in the first
string and decrease the frequency using the second string.
If all frequencies become zero, the strings are anagrams.
*/
