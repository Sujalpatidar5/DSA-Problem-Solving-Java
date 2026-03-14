/*
LeetCode 71 - Simplify Path

Problem Statement:
Given a string path which represents an absolute
path for a Unix-style file system, simplify it.

Rules:
1. "."  → current directory → ignore
2. ".." → go to previous directory → pop
3. "//" → multiple slashes → treat as single slash

Return the simplified canonical path.

---------------------------------------

Pattern Used:
Stack

Why this pattern?

When we encounter ".." we must remove the
previous directory. Stack naturally supports
this behavior using push and pop operations.

---------------------------------------

Key Idea:

1. Split the path using "/"
2. Traverse each part
3. Ignore "" and "."
4. If ".." → pop from stack
5. Otherwise push directory name
6. Build final path from stack

---------------------------------------

Approach:

Split path → iterate parts → use stack
to maintain valid directories.

---------------------------------------

Algorithm:

1. Split path using "/".
2. Create an empty stack.
3. Traverse each part:
   - If "" or "." → ignore
   - If ".." → pop stack if not empty
   - Otherwise → push directory
4. Build result using StringBuilder.
5. If stack empty → return "/"
6. Else return constructed path.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public String simplifyPath(String path) {

        String[] parts = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String curr : parts) {

            // ignore empty and current directory
            if (curr.equals("") || curr.equals(".")) {
                continue;
            }

            // go back to previous directory
            else if (curr.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // normal directory
            else {
                stack.push(curr);
            }
        }

        // build final path
        StringBuilder sb = new StringBuilder();

        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        if (sb.length() == 0) {
            return "/";
        }

        return sb.toString();
    }
}

/*
---------------------------------------

Example:

Input:
"/a/./b/../../c/"

Split:
["", "a", ".", "b", "..", "..", "c", ""]

Stack process:
a → push
b → push
.. → pop b
.. → pop a
c → push

Final stack:
[c]

Output:
/c

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(n)

---------------------------------------

Explanation:

"I split the path by '/' and used a stack.
If I encounter '.', I ignore it.
If I encounter '..', I pop the previous directory.
Otherwise I push the folder name.
Finally I build the simplified path from the stack."

---------------------------------------
*/
