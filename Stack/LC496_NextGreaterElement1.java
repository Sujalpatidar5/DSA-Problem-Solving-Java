/*
LeetCode 496 - Next Greater Element I

---------------------------------------

Problem Statement:

You are given two arrays nums1 and nums2.

nums1 is a subset of nums2.

For each element in nums1, find the next greater element
in nums2. The next greater element of a number x is the
first greater number to its right in nums2.

If no greater element exists, return -1 for that element.

Return the answers in the same order as nums1.

---------------------------------------

Pattern Used and Why:

Pattern Used:
Monotonic Stack + HashMap

Why?

We need to find the next greater element on the RIGHT side.

Using brute force would take O(n²).

Instead we use a monotonic stack to process nums2
efficiently and store the next greater element
in a HashMap for fast lookup.

---------------------------------------

Key Idea:

1. Traverse nums2 from right to left.
2. Maintain a stack that keeps possible greater elements.
3. Remove elements smaller than or equal to current element.
4. The top of the stack becomes the next greater element.
5. Store the mapping in HashMap.
6. Finally overwrite nums1 using the HashMap.

---------------------------------------

Algorithm / Process:

1. Create a stack and a HashMap.
2. Start from the last element of nums2.
3. Push it into the stack and map it to -1.
4. Traverse nums2 from right to left.
5. For each element:
   - Remove all elements from stack that are <= current element.
   - If stack top exists → it is the next greater element.
   - Otherwise store -1.
6. Push current element into the stack.
7. After processing nums2, traverse nums1.
8. Replace each element with its mapped next greater value.

---------------------------------------

Code:
*/

import java.util.*;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(nums2[n2 - 1], -1);
        s.push(nums2[n2 - 1]);

        for (int i = n2 - 1; i >= 0; i--) {

            int curr = nums2[i];

            if (s.peek() > curr) {
                map.put(curr, s.peek());
                s.push(curr);
            }
            else {

                while (!s.isEmpty()) {

                    if (s.peek() > curr) {
                        map.put(curr, s.peek());
                        s.push(curr);
                        break;
                    }
                    else {
                        s.pop();
                    }
                }

                if (s.isEmpty()) {
                    map.put(curr, -1);
                    s.push(curr);
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            int ans = map.get(nums1[i]);
            nums1[i] = ans;
        }

        return nums1;
    }
}

/*
---------------------------------------

Time Complexity:

O(n2 + n1)

Explanation:

Each element of nums2 is pushed and popped
from the stack at most once → O(n2).

Then nums1 is traversed once → O(n1).

---------------------------------------

Space Complexity:

O(n2)

Explanation:

HashMap stores next greater element for nums2.

---------------------------------------

Example:

Input:

nums1 = [4,1,2]
nums2 = [1,3,4,2]

Processing nums2:

1 → 3
3 → 4
4 → -1
2 → -1

Map:

1 → 3
3 → 4
4 → -1
2 → -1

Output:

[-1,3,-1]

---------------------------------------

Explanation:

"I used a monotonic stack to compute the next greater
element for every element in nums2 while traversing
from right to left. The results were stored in a HashMap.
Then I simply replaced each element in nums1 using the
precomputed map values."

---------------------------------------
*/
