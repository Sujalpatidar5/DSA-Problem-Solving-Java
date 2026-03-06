/*
LeetCode 1047 - Remove All Adjacent Duplicates In String

Problem Statement:
Given a string s consisting of lowercase letters.

Remove all adjacent duplicate characters
repeatedly until no duplicates remain.

Return the final string.

---------------------------------------

Pattern Used:
Stack

Why this pattern?

1. We need to check the previous character
   while processing the current character.

2. Stack helps us keep track of the last character.

3. If the current character equals the stack top,
   it means a duplicate pair → remove it.

---------------------------------------

Key Observation:

If the current character equals the last character
stored in the stack:

duplicate pair found → remove it.

Otherwise:

push the character to stack.

---------------------------------------

Approach:

1. Create an empty stack.

2. Traverse the string character by character.

3. If stack is not empty AND
   stack top == current character

      pop from stack (remove duplicate)

4. Otherwise

      push current character to stack

5. After traversal, stack contains
   the final characters.

6. Convert stack into string and return it.

---------------------------------------

Algorithm:

1. Initialize an empty stack.

2. For each character ch in string:

   If stack not empty AND stack.peek() == ch
      pop

   Else
      push ch

3. Convert stack to string using StringBuilder.

4. Return the final string.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          
            // if duplicate found → remove previous
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } 
            else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        // convert stack to string
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}

/*
---------------------------------------

Example:

Input:
s = "abbaca"

Process:

abbaca
^^
remove bb

aaca
^^
remove aa

Remaining:
ca

Output:
"ca"

---------------------------------------

Time Complexity:

Traversal of string → O(n)

Each character pushed and popped at most once.

Total → O(n)

---------------------------------------

Space Complexity:

Stack may store all characters.

O(n)

---------------------------------------

Explanation :

"I used a stack to track characters.

While iterating the string,
if the current character equals
the top of the stack,
I remove it because it forms
an adjacent duplicate pair.

Otherwise I push the character.

Finally I convert the stack
into the result string."

---------------------------------------
*/
