/*
Problem: 22. Generate Parentheses

-----------------------------------------------------

Problem Statement

Given n pairs of parentheses,
generate all combinations of well-formed parentheses.

-----------------------------------------------------

Pattern Used & Why

Pattern: Backtracking

Why:
- We need to generate all valid combinations
- At every step → 2 choices:
  1. Add '('
  2. Add ')'
- But with constraints to keep it valid

-----------------------------------------------------

Key Idea

- We can add '(' if open < n
- We can add ')' only if close < open

This ensures the string is always valid.

-----------------------------------------------------

Algorithm / Process

1. Start with empty string
2. If length becomes 2*n → add to result
3. If open < n → add '(' and recurse
4. If close < open → add ')' and recurse

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        func(0, 0, n, "", ans);

        return ans;
    }

    private void func(int open, int close, int n, String curr, List<String> ans) {

        // base case
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // include '('
        if (open < n) {
            func(open + 1, close, n, curr + "(", ans);
        }

        // include ')'
        if (close < open) {
            func(open, close + 1, n, curr + ")", ans);
        }
    }
}

/*
-----------------------------------------------------

Time Complexity
O(2^n)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
n = 3

Output:
["((()))","(()())","(())()","()(())","()()()"]

-----------------------------------------------------

Explanation

Use backtracking.
Add '(' if open < n and ')' if close < open.
This ensures only valid parentheses are generated.
*/
