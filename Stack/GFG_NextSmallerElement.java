/*
Next Smaller Element

---------------------------------------

Problem Statement:

Given an array arr[] of size n,
for every element find the Next Smaller Element (NSE).

The Next Smaller Element of arr[i] is the nearest element
to the right of arr[i] which is smaller than arr[i].

If no such element exists, return -1 for that position.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Monotonic Stack

Why?

We need to find the nearest smaller element on the RIGHT side.
Using brute force would take O(n²) because for every element
we would check all elements to its right.

Using a stack helps efficiently remove larger elements
and keeps only useful candidates.

---------------------------------------

Key Idea:

1. Traverse the array from right to left.
2. Maintain a stack that stores possible smaller elements.
3. Remove elements from the stack that are greater than or
   equal to the current element.
4. The top of the stack becomes the next smaller element.
5. If stack becomes empty → answer = -1.
6. Push the current element into the stack.

---------------------------------------

Algorithm / Process:

1. Create an empty stack.
2. Create an ArrayList ans to store results.
3. Traverse the array from right to left.
4. For each element:
   - Pop elements from stack while stack.peek() >= current element.
   - If stack empty → add -1 to the front of ans.
   - Else → stack.peek() is the next smaller element.
5. Push the current element into the stack.
6. Continue until the array ends.
7. Return the answer list.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public static ArrayList<Integer> nextSmaller(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            while (!s.isEmpty() && s.peek() >= curr) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans.add(0, -1);
            } else {
                ans.add(0, s.peek());
            }

            s.push(curr);
        }

        return ans;
    }
}

/*
---------------------------------------

Time Complexity:

O(n)

Each element is pushed and popped from the stack
at most once.

---------------------------------------

Space Complexity:

O(n)

Stack and answer list may store up to n elements.

---------------------------------------

Example:

Input:
arr = [4,5,2,10,8]

Output:
[2,2,-1,8,-1]

Explanation:

4 → next smaller = 2
5 → next smaller = 2
2 → no smaller element → -1
10 → next smaller = 8
8 → no smaller element → -1

---------------------------------------

Explanation:

"I used a monotonic stack and traversed the array
from right to left. While traversing, I removed
elements greater than or equal to the current element.
The remaining top of the stack represents the
next smaller element."

---------------------------------------
*/
