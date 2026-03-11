/*
LeetCode 1209 - Remove All Adjacent Duplicates in String II

---------------------------------------

Problem Statement:

Given a string s and an integer k,
remove all adjacent duplicates in the string
where k identical characters appear consecutively.

The removal should continue until
no more such groups exist.

Return the final string after all removals.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Stack

Why?

We need to track adjacent characters and
their frequency. A stack helps us store
characters along with their count so we
can efficiently remove groups of size k.

---------------------------------------

Key Idea:

Instead of storing characters only,
store both character and its frequency.

Whenever the same character appears,
increase the frequency.

If frequency becomes k,
remove that group from the stack.

---------------------------------------

Algorithm / Process:

1. Create a stack that stores:
   [character ASCII value, frequency].

2. Traverse each character of the string.

3. If stack is not empty and
   top character equals current character:
      increase frequency.

4. Otherwise push new character
   with frequency = 1.

5. If frequency becomes k:
      remove that group from stack.

6. After traversal,
   build the final string from stack.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public String removeDuplicates(String s, int k) {

        // Stack will store: [character ASCII value, frequency]
        Stack<int[]> stack = new Stack<>();

        // Traverse every character of the string
        for (char c : s.toCharArray()) {

            // If stack is not empty AND top character is same as current
            if (!stack.isEmpty() && stack.peek()[0] == c) {

                // Increase frequency of that character
                stack.peek()[1]++;

            } else {

                // New character → push with frequency 1
                stack.push(new int[]{c, 1});
            }

            // If frequency becomes k → remove that group
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        // Build final string from stack
        StringBuilder result = new StringBuilder();

        // Traverse stack elements
        for (int[] pair : stack) {

            // pair[0] = ASCII value of character
            // Convert it back to char
            char ch = (char) pair[0];

            // pair[1] = frequency of that character
            int count = pair[1];

            // Append character 'count' times
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        // Return final string
        return result.toString();
    }
}

/*
---------------------------------------

Time Complexity:

O(n)

Each character is pushed and popped
from the stack at most once.

---------------------------------------

Space Complexity:

O(n)

Stack may store up to n characters
in the worst case.

---------------------------------------

Example:

Input:
s = "deeedbbcccbdaa"
k = 3

Process:
eee → removed
ccc → removed
bbb → removed

Output:
"aa"

---------------------------------------

Explanation:

"I used a stack storing character and frequency.
Whenever the same character appears,
its count increases. If the count reaches k,
that group is removed from the stack.
Finally, the remaining stack builds the result."

---------------------------------------
*/
