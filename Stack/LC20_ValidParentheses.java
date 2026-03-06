/*
LeetCode 20 - Valid Parentheses

Problem Statement:
Given a string s containing just the characters:

( ) { } [ ]

Determine if the input string is valid.

A string is valid if:

1. Every opening bracket has a corresponding closing bracket.
2. Brackets must close in the correct order.
3. Every closing bracket must match the most recent opening bracket.

---------------------------------------

Pattern Used:
Stack

Why this pattern?

Brackets follow a Last In First Out order.

The last opened bracket must be closed first.

Stack perfectly handles this behavior.

---------------------------------------

Key Idea:

1. Push opening brackets into stack.

2. When a closing bracket appears:
   check if the stack top has the matching opening bracket.

3. If yes → pop it.
4. If not → invalid string.

At the end:
Stack must be empty.

---------------------------------------

Approach:

Traverse the string character by character.

Case 1:
If character is opening bracket
→ push into stack.

Case 2:
If character is closing bracket

Check:
- stack empty → invalid
- top matches → pop
- otherwise → invalid

Finally:
If stack is empty → valid
else → invalid

---------------------------------------

Algorithm:

1. Create a stack.
2. Traverse string.
3. If '(' or '{' or '[' → push.
4. If ')', '}', ']':

   if stack empty → return false

   if top matches → pop

   else → return false

5. After traversal:
   if stack empty → true
   else → false

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Case 1: opening bracket
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            // Case 2: closing bracket
            else {

                if (st.isEmpty()) {
                    return false;
                }

                if ((ch == ')' && st.peek() == '(')
                        || (ch == '}' && st.peek() == '{')
                        || (ch == ']' && st.peek() == '[')) {

                    st.pop();
                }

                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}

/*
---------------------------------------

Example 1:

Input:
s = "()"

Output:
true

---------------------------------------

Example 2:

Input:
s = "()[]{}"

Output:
true

---------------------------------------

Example 3:

Input:
s = "(]"

Output:
false

---------------------------------------

Time Complexity:

O(n)

Each character is pushed or popped once.

---------------------------------------

Space Complexity:

O(n)

Stack may store all opening brackets.

---------------------------------------

Explanation :

"I used a stack to track opening brackets.
Whenever I encountered a closing bracket,
I checked if the top of the stack had the
matching opening bracket. If yes I popped it.
If not, the string is invalid.
At the end the stack must be empty."

---------------------------------------
*/
