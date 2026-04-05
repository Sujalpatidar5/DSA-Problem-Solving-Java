/*
Problem: Remove all occurrences of a character from string (GFG)

-----------------------------------------------------

Problem Statement

Given a StringBuilder s and a character c,
remove all occurrences of c from the string.

-----------------------------------------------------

Pattern Used & Why

Pattern: Recursion (StringBuilder)

Why:
- Traverse string using recursion
- Build result separately
- Replace original string

-----------------------------------------------------

Key Idea

- Create temp StringBuilder
- Add only those characters which are not equal to c
- Copy result back to original

-----------------------------------------------------

Algorithm / Process

1. Create temp StringBuilder
2. Traverse string using recursion
3. If char != c → add to temp
4. After recursion:
      clear original string
      copy temp into original

-----------------------------------------------------

Code
*/

class Solution {

    public void removeCharacter(StringBuilder s, char c) {

        StringBuilder temp = new StringBuilder();

        build(s, c, 0, temp);

        s.setLength(0);   // clear original
        s.append(temp);   // copy result
    }

    private void build(StringBuilder s, char c, int i, StringBuilder temp) {

        // base case
        if (i == s.length()) {
            return;
        }

        // work
        if (s.charAt(i) != c) {
            temp.append(s.charAt(i));
        }

        // recursive call
        build(s, c, i + 1, temp);
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
s = "aabbcc", c = 'a'

Output:
"bbcc"

-----------------------------------------------------

Short Interview Explanation

Use recursion to build a new string.
Skip target character and copy remaining.
*/
