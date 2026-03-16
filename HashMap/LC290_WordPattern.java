/*
Problem: 290. Word Pattern
Link: https://leetcode.com/problems/word-pattern/

-----------------------------------------------------

Problem Statement

Given a pattern and a string s, determine if s follows the same pattern.

Here follow means a full match, such that there is a bijection between
a letter in pattern and a word in s.

Rules:
• Each pattern character maps to exactly one word.
• No two pattern characters map to the same word.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap (Bidirectional Mapping)

Why:
To ensure one-to-one mapping between pattern characters and words.

We maintain two maps:

pattern → word
word → pattern

This prevents multiple characters mapping to the same word.

-----------------------------------------------------

Key Idea

Example:

pattern = "abba"
s = "dog cat cat dog"

Mapping:
a → dog
b → cat

Check both directions:

char → word
word → char

If mapping mismatch occurs → return false.

-----------------------------------------------------

Algorithm / Process

1. Split string s into words using space.
2. If pattern length ≠ words length → return false.
3. Create two HashMaps:
      mapAB → char → word
      mapBA → word → char
4. Traverse pattern and words together.
5. Check mapping consistency in both directions.
6. If mismatch occurs → return false.
7. If traversal completes → return true.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        int n = pattern.length();
        int m = words.length;

        if (n != m)
            return false;

        HashMap<Character, String> mapAB = new HashMap<>();
        HashMap<String, Character> mapBA = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char ch = pattern.charAt(i);
            String str = words[i];

            // mapping: char → word
            if (mapAB.containsKey(ch)) {

                if (!mapAB.get(ch).equals(str))
                    return false;

            } else {

                mapAB.put(ch, str);
            }

            // mapping: word → char
            if (mapBA.containsKey(str)) {

                if (mapBA.get(str) != ch)
                    return false;

            } else {

                mapBA.put(str, ch);
            }
        }

        return true;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

We traverse the pattern and words once.

-----------------------------------------------------

Space Complexity
O(n)

For storing mappings in HashMaps.

-----------------------------------------------------

Example

Input:
pattern = "abba"
s = "dog cat cat dog"

Output:
true

Explanation:
a → dog
b → cat

Both mappings are consistent.

-----------------------------------------------------

Explanation :

Use two HashMaps to maintain a bijection between pattern characters
and words. While traversing both simultaneously, ensure the mapping
is consistent in both directions.
*/
