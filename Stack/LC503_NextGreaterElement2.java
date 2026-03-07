/*
LeetCode 503 - Next Greater Element II

---------------------------------------

Problem Statement:

Given a circular integer array nums, return the next greater
number for every element.

The next greater number of a number x is the first greater
number to its right in the array.

Since the array is circular, the search continues from
the beginning of the array after reaching the end.

If no greater element exists, return -1 for that element.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Monotonic Stack

Why?

We need to find the next greater element on the RIGHT side.
Using brute force would take O(n²).

A stack helps remove smaller elements efficiently and
keeps possible candidates for the next greater element.

Since the array is circular, we simulate circular traversal
by looping through the array twice.

---------------------------------------

Key Idea:

1. Traverse the array from right to left.
2. Use a stack to keep possible next greater elements.
3. Remove elements from the stack that are smaller than
   or equal to the current element.
4. The top of the stack becomes the next greater element.
5. To simulate circular array behavior, traverse the array
   twice using index i % n.

---------------------------------------

Algorithm / Process:

1. Let n = nums.length.
2. Create answer array ans of size n.
3. Create a stack.
4. Traverse from index (2n - 1) down to 0.
5. Current element = nums[i % n].
6. If stack top is greater than current element,
   it becomes the next greater element.
7. Otherwise pop elements from stack until a greater
   element is found or stack becomes empty.
8. If stack becomes empty, next greater element = -1.
9. Push current element into the stack.
10. Only store answers when i < n (original array indices).

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {

            int curr = nums[i % n];

            if (!s.isEmpty() && s.peek() > curr) {

                if (i < n) {
                    ans[i] = s.peek();
                }

                s.push(curr);
            }
            else {

                while (!s.isEmpty()) {

                    if (s.peek() > curr) {

                        if (i < n) {
                            ans[i] = s.peek();
                        }

                        s.push(curr);
                        break;
                    }
                    else {
                        s.pop();
                    }
                }

                if (s.isEmpty()) {

                    if (i < n) {
                        ans[i] = -1;
                    }

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

Explanation:
Each element is pushed and popped from the stack
at most once during the traversal.

---------------------------------------

Space Complexity:

O(n)

Explanation:
Stack and answer array can store up to n elements.

---------------------------------------

Example:

Input:
nums = [1,2,1]

Circular traversal idea:
1 2 1 | 1 2 1

Output:
[2,-1,2]

Explanation:

1 → next greater element is 2
2 → no greater element → -1
1 → circularly finds 2

---------------------------------------

Explanation:

"I used a monotonic stack and traversed the array
twice to simulate circular behavior. Smaller elements
were removed from the stack, and the remaining top
element represented the next greater element."

---------------------------------------
*/
