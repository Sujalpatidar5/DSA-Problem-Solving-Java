/*
Previous Smaller Element

---------------------------------------

Problem Statement:

Given an array arr[] of size n,
for every element find the Previous Smaller Element (PSE).

The Previous Smaller Element of arr[i] is the nearest element
to the left of arr[i] which is smaller than arr[i].

If no such element exists, return -1 for that position.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Monotonic Stack

Why?

We need to find the nearest smaller element on the LEFT side.

Using brute force would require checking all previous elements,
which takes O(n²).

Using a stack helps maintain useful candidates and removes
larger elements efficiently, reducing the time complexity to O(n).

---------------------------------------

Key Idea:

1. Traverse the array from left to right.
2. Maintain a stack that stores potential previous smaller elements.
3. Remove elements from stack that are greater than or equal to
   the current element.
4. If stack becomes empty → no smaller element exists → answer = -1.
5. Otherwise stack top is the previous smaller element.
6. Push current element into stack.

---------------------------------------

Algorithm / Process:

1. Create an empty stack.
2. Create an ArrayList ans to store the results.
3. Traverse the array from left to right.
4. For each element:
   - Pop elements from stack while stack.peek() >= current element.
   - If stack becomes empty → add -1 to answer.
   - Else → stack.peek() is the previous smaller element.
5. Push the current element into the stack.
6. Continue until array ends.
7. Return the answer list.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public static ArrayList<Integer> prevSmaller(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            int curr = arr[i];

            while (!s.isEmpty() && s.peek() >= curr) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(s.peek());
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

Explanation:
Each element is pushed and popped from the stack
at most once.

---------------------------------------

Space Complexity:

O(n)

Explanation:
Stack may store up to n elements in the worst case.

---------------------------------------

Example:

Input:
arr = [4, 5, 2, 10, 8]

Output:
[-1, 4, -1, 2, 2]

Explanation:

4 → no smaller element on left → -1
5 → previous smaller = 4
2 → no smaller element on left → -1
10 → previous smaller = 2
8 → previous smaller = 2

---------------------------------------

Explanation:

"I used a monotonic stack to keep track of smaller elements.
While traversing the array, I removed elements from the stack
that were greater than or equal to the current element.
The remaining top element becomes the previous smaller element."

---------------------------------------
*/
