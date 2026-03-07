/*
Previous Greater Element

Problem Statement:
Given an array arr[] of size n,
for every element find the Previous Greater Element (PGE).

The Previous Greater Element of arr[i] is the nearest element
to the left of arr[i] which is greater than arr[i].

If no such element exists, return -1 for that position.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Stack (Monotonic Stack)

Why?
We need to check elements on the LEFT side of the current element.
Using brute force would take O(n²).

Stack helps us efficiently track potential previous greater elements
by removing useless smaller elements.

---------------------------------------

Key Idea:

For each element:

1. Remove elements from stack that are <= current element
2. The top of the stack (if exists) becomes the Previous Greater
3. If stack becomes empty → answer = -1
4. Push current element into the stack

---------------------------------------

Algorithm / Process:

1. Create an empty stack and answer list.
2. First element always has no previous greater → add -1.
3. Push first element into stack.
4. Traverse array from index 1.
5. For each element:
   - Pop stack elements while they are <= current element.
   - If stack becomes empty → add -1.
   - Else → top of stack is previous greater.
6. Push current element into stack.
7. Continue until array ends.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    static ArrayList<Integer> preGreaterEle(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        ans.add(-1);
        s.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            int curr = arr[i];

            if (s.peek() > curr) {
                ans.add(s.peek());
                s.push(curr);
            } 
            else {

                while (!s.isEmpty()) {

                    if (s.peek() > curr) {
                        ans.add(s.peek());
                        s.push(curr);
                        break;
                    } 
                    else {
                        s.pop();
                    }
                }

                if (s.isEmpty()) {
                    ans.add(-1);
                    s.push(curr);
                }
            }
        }

        return ans;
    }
}

/*
---------------------------------------

Time Complexity:
O(n)

Reason:
Each element is pushed and popped from the stack at most once.

---------------------------------------

Space Complexity:
O(n)

Reason:
Stack can store up to n elements in worst case.

---------------------------------------

Example:

Input:
arr = [10, 4, 5, 7]

Output:
[-1, 10, 10, 10]

Explanation:

10 → no element on left → -1
4  → previous greater = 10
5  → previous greater = 10
7  → previous greater = 10

---------------------------------------

Explanation:

"I used a stack to keep track of possible previous greater elements.
For every element, I remove all smaller elements from the stack.
The remaining top element becomes the previous greater.
If the stack becomes empty, the answer is -1."

---------------------------------------
*/
