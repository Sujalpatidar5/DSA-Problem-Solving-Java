/*
========================================
Problem: 42. Trapping Rain Water
========================================

Problem Statement:
Given an array height where each element represents
the height of a bar,

Return the total amount of rainwater that can be trapped
after raining.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- Water trapped at an index depends on:
      min(leftMax, rightMax)

- Instead of storing prefix and suffix arrays,
  we maintain leftMax and rightMax using two pointers.

- This reduces extra space from O(n) to O(1).

----------------------------------------
Key Idea:

Water trapped at every index:

water =
min(leftMax, rightMax) - currentHeight

If current height is already greater than or equal to
the minimum boundary,
then no water is trapped.

----------------------------------------
Algorithm / Process:

1. left = 0
2. right = n - 1
3. leftMax = 0
4. rightMax = 0
5. water = 0

6. While left < right

      If height[left] < height[right]

            Update leftMax

            If leftMax > height[left]
                  Add trapped water

            Move left

      Else

            Update rightMax

            If rightMax > height[right]
                  Add trapped water

            Move right

7. Return total water

----------------------------------------
Code:
*/

class Solution {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(n)

- Every pointer moves at most n times.

Space Complexity:
O(1)

- Only a few variables are used.

----------------------------------------
Example:

Input:

height =

[0,1,0,2,1,0,1,3,2,1,2,1]

Output:

6

----------------------------------------
Dry Run:

height =

[4,2,0,3,2,5]

left = 0
right = 5

leftMax = 0
rightMax = 0

--------------------------------

height[left] < height[right]

leftMax = 4

Move left

--------------------------------

height[left] = 2

Water =
4 - 2 = 2

--------------------------------

height[left] = 0

Water =
4 - 0 = 4

Total = 6

--------------------------------

height[left] = 3

Water =
4 - 3 = 1

Total = 7

--------------------------------

height[left] = 2

Water =
4 - 2 = 2

Total = 9

--------------------------------

Move until pointers meet.

Final Answer = 9

----------------------------------------
Explanation (Simple & Clear)

Rainwater can only be stored if there is a taller bar on both the left and the right side.

For every position, the amount of water depends on the smaller of the highest bar on the left and the highest bar on the right.

Formula:

Water =
min(leftMax, rightMax) - currentHeight

Instead of creating two extra arrays to store leftMax and rightMax, we use two pointers.

The left pointer starts from the beginning and the right pointer starts from the end.

We also keep track of the tallest bar seen so far from the left (leftMax) and from the right (rightMax).

If the left height is smaller, then the left side decides the trapped water because the right side already has a taller boundary.

So:

- Update leftMax if needed.
- Otherwise, trap water using leftMax.
- Move the left pointer.

Similarly,

If the right height is smaller or equal,

- Update rightMax if needed.
- Otherwise, trap water using rightMax.
- Move the right pointer.

We continue this until both pointers meet.

The total trapped water is stored in the variable water.

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

I maintain two pointers from both ends and keep track of the maximum height seen from the left and the right.

Whichever side has the smaller height is processed first because that side determines the maximum water that can be trapped at that position.

If the current height is smaller than its maximum boundary, I add the difference to the answer.

This solution works in O(n) time and O(1) extra space.

----------------------------------------
Short Comment (for code memory):

// Water = min(leftMax, rightMax) - current height
// Process the smaller height side first
*/
