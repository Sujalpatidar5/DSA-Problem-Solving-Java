/*
Problem: 205. Isomorphic Strings
Link: https://leetcode.com/problems/isomorphic-strings/

-----------------------------------------------------

Problem Statement
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

Rules:
• All occurrences of a character must be replaced with another character.
• The order of characters must be preserved.
• No two characters may map to the same character.

-----------------------------------------------------

Pattern Used & Why
Pattern: HashMap (Bidirectional Mapping)

Why:
To ensure a one-to-one mapping between characters of both strings.
We maintain two hash maps:
1. s → t mapping
2. t → s mapping

This ensures no two characters map to the same character.

-----------------------------------------------------

Key Idea

For every index i:

c1 = s.charAt(i)
c2 = t.charAt(i)

Check two mappings:

1️. s → t  
If c1 already mapped but mapped value ≠ c2 → return false.

2️. t → s  
If c2 already mapped but mapped value ≠ c1 → return false.

If both conditions satisfied → store the mapping.

-----------------------------------------------------

Algorithm / Process

1. If lengths of both strings are different → return false.
2. Create two HashMaps:
      mapST → mapping from s to t
      mapTS → mapping from t to s
3. Traverse both strings simultaneously.
4. For every character pair:
      check s → t mapping
      check t → s mapping
5. If mapping conflict occurs → return false.
6. If traversal finishes → return true.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // map S → T
            if (mapST.containsKey(c1)) {

                if (mapST.get(c1) != c2)
                    return false;

            } else {

                mapST.put(c1, c2);
            }

            // map T → S
            if (mapTS.containsKey(c2)) {

                if (mapTS.get(c2) != c1)
                    return false;

            } else {

                mapTS.put(c2, c1);
            }
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

HashMaps store at most 256 characters (ASCII).

-----------------------------------------------------

Example

Input
s = "egg"
t = "add"

Mapping
e → a
g → d

Output
true

-----------------------------------------------------

Explanation :

Use two hash maps to maintain bidirectional mapping between characters of
both strings. While iterating, ensure the mapping is consistent in both
directions. If any conflict occurs, return false. Otherwise the strings
are isomorphic.
*/
