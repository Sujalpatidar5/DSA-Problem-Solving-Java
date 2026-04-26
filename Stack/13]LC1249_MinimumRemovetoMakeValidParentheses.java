/*
Problem: 1249. Minimum Remove to Make Valid Parentheses

-----------------------------------------------------

Problem Statement

Given a string s containing '(' , ')' and lowercase letters,
remove the minimum number of parentheses so that the string becomes valid.

Return the valid string.

-----------------------------------------------------

Pattern Used & Why

Pattern: Stack + Mark Invalid

Why:
- We need to match '(' with ')'
- Stack helps track unmatched '('
- Mark invalid indices and skip later

-----------------------------------------------------

Key Idea

- Use stack to store indices of '('
- If ')' comes:
   - If no matching '(' → mark invalid
   - Else → match and pop
- Remaining '(' in stack are invalid
- Build result by skipping invalid indices

-----------------------------------------------------

Algorithm / Process

1. Traverse string
2. Push index of '('
3. For ')':
   - If stack empty → mark invalid
   - Else → pop
4. Mark leftover '(' as invalid
5. Build result string skipping invalid positions

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public String minRemoveToMakeValid(String s) {

        int n = s.length();
        boolean[] remove = new boolean[n];
        Stack<Integer> st = new Stack<>();

        // Step 1: mark invalid ')'
        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c == '(') {
                st.push(i);
            }
            else if (c == ')') {

                if (st.isEmpty()) {
                    remove[i] = true;
                } else {
                    st.pop();
                }
            }
        }

        // Step 2: mark remaining '('
        while (!st.isEmpty()) {
            remove[st.pop()] = true;
        }

        // Step 3: build result
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!remove[i]) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(n)

-----------------------------------------------------

Example

Input:
s = "lee(t(c)o)de)"

Output:
"lee(t(c)o)de"

-----------------------------------------------------

Explanation 

I use a stack to track indices of opening brackets.

While traversing:
- If I see '(', I push its index
- If I see ')':
   - If stack is empty → it's invalid, so I mark it
   - Else → I match it with a previous '('

After traversal:
- Any '(' left in stack are unmatched → mark them invalid

Finally:
- I build the result string by skipping all marked indices

This ensures minimum removals and valid parentheses.
*/
