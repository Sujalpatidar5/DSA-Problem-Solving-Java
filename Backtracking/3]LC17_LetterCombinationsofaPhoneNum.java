/*
Problem: 17. Letter Combinations of a Phone Number

-----------------------------------------------------

Problem Statement

Given a string containing digits from 2–9,
return all possible letter combinations that the number could represent.

(Just like phone keypad mapping)

-----------------------------------------------------

Pattern Used & Why

Pattern: Backtracking

Why:
- For each digit → multiple choices (letters)
- Need to generate all combinations → recursion + choices

-----------------------------------------------------

Key Idea

- Each digit maps to some letters
- For each digit → try all possible letters
- Build string step by step

-----------------------------------------------------

Algorithm / Process

1. Create mapping of digits → letters
2. Start from index 0
3. For current digit:
   - Get its letters
   - Loop through each letter
   - Add to current string
   - Recurse for next digit
4. Base case: when index reaches end → add string

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        func(digits, 0, "", ans, map);

        return ans;
    }

    private void func(String digits, int i, String curr, List<String> ans,
                      Map<Character, String> map) {

        // base case
        if (i == digits.length()) {
            ans.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(i));

        for (int j = 0; j < letters.length(); j++) {

            char ch = letters.charAt(j);

            func(digits, i + 1, curr + ch, ans, map);
        }
    }
}

/*
-----------------------------------------------------

Time Complexity
O(4^n)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
digits = "23"

Output:
["ad","ae","af","bd","be","bf","cd","ce","cf"]

-----------------------------------------------------

Explanation

Use backtracking.
For each digit, try all mapped letters and recurse.
Add result when full length is reached.
*/
