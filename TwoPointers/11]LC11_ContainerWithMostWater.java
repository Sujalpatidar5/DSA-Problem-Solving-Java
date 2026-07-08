/*
========================================
Problem: 11. Container With Most Water
========================================

Problem Statement:
You are given an array height.

Each height[i] represents the height of a vertical line.

Find two lines that together can hold the maximum amount of water.

Return the maximum water area.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- Width depends on distance between pointers
- Height depends on smaller line

Brute Force:
- Check every pair
- O(n²)

Optimized:
- Two Pointers
- O(n)

----------------------------------------
Key Idea:

Area =
Minimum Height × Width

Area =
min(height[left], height[right])
×
(right - left)

Important Observation:

The smaller height always limits the water.

So after calculating area:

- Move the smaller height pointer
- Keep the larger height pointer

Because moving the larger height
can never increase the minimum height.

----------------------------------------
Algorithm / Process:

1. Place left pointer at start
2. Place right pointer at end
3. Calculate area
4. Update maximum answer
5. Move smaller height pointer
6. Repeat until pointers meet

----------------------------------------
Code:
*/

class Solution {

    public int maxArea(int[] height) {

        int lp = 0;
        int rp = height.length - 1;

        int maxWater = 0;

        while (lp < rp) {

            // calculate water area
            int ht = Math.min(height[lp], height[rp]);
            int width = rp - lp;

            int currWater = ht * width;

            maxWater = Math.max(maxWater, currWater);

            // update pointer
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(n)

- Every pointer moves at most n times

Space Complexity:
O(1)

----------------------------------------
Example:

Input:
height = [1,8,6,2,5,4,8,3,7]

Output:
49

----------------------------------------
Dry Run:

height =
[1,8,6,2,5,4,8,3,7]

left = 0
right = 8

Area =
min(1,7) × 8
= 8

Move left

--------------------------------

left = 1
right = 8

Area =
min(8,7) × 7
= 49

max = 49

Move right

--------------------------------

Continue...

No larger area found.

Answer = 49

----------------------------------------
Explanation (Simple & Clear)

The amount of water depends on two things:

1. Height
2. Width

Height is always decided by the smaller line.

Example:

Height = [8,7]

Even if one line has height 8,
water can only reach height 7.

So:

Area =
smaller height × width

Now suppose we calculate an area.

If the left height is smaller,
keeping it will never help.

Why?

Because width will decrease in the next step.

To get a larger area,
we need a chance of finding a taller height.

So we move the smaller pointer.

This is the main trick of the problem.

By doing this,
we check all useful possibilities in O(n) time.

----------------------------------------
Interview Explanation

I use the Two Pointer approach.

The water area is determined by the smaller height and the distance between pointers.

After calculating the area,
I move the pointer having the smaller height because it limits the current area.

Moving the larger height pointer cannot improve the minimum height.

This reduces the complexity from O(n²) to O(n).

----------------------------------------
Short Comment (for code memory):

// area = min height × width
// move smaller height pointer
*/
