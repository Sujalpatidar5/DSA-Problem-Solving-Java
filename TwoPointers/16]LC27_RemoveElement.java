/*
========================================
Problem: 27. Remove Element
========================================

Problem Statement:

Given an integer array nums and an integer val,

Remove all occurrences of val in-place.

The order of the remaining elements does not matter.

Return the number of elements that are NOT equal to val.

Do not use extra space.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- One pointer (right) scans every element.
- One pointer (left) stores only the valid elements.
- Every element equal to val is skipped.

----------------------------------------
Key Idea:

Keep only the elements that are NOT equal to val.

right → checks every element.

left → stores the next valid element.

Whenever nums[right] != val

Copy it to nums[left]
Move left forward.

If nums[right] == val

Simply skip it.

----------------------------------------
Algorithm / Process:

1. left = 0
2. right = 0
3. count = 0

4. While right < n

      If nums[right] == val

            right++
            continue

      nums[left] = nums[right]

      left++
      right++
      count++

5. Return count

----------------------------------------
Code:
*/

class Solution {

    public int removeElement(int[] nums, int val) {

        int n = nums.length;

        int count = 0;
        int left = 0;
        int right = 0;

        while (right < n) {

            if (nums[right] == val) {
                right++;
                continue;
            }

            nums[left] = nums[right];
            count++;
            left++;
            right++;
        }

        return count;
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(n)

- Every element is visited once.

Space Complexity:
O(1)

- No extra array is used.

----------------------------------------
Example

Input:

nums = [3,2,2,3]
val = 3

Output:

2

Modified array:

[2,2]

----------------------------------------
Dry Run

Input:

nums = [3,2,2,3]

val = 3

Initially

left = 0
right = 0
count = 0

--------------------------------

right = 0

nums[right] = 3

Equal to val

Skip

right = 1

--------------------------------

right = 1

nums[right] = 2

Valid element

nums[left] = 2

left = 1

count = 1

right = 2

--------------------------------

right = 2

nums[right] = 2

Valid element

nums[left] = 2

left = 2

count = 2

right = 3

--------------------------------

right = 3

nums[right] = 3

Equal to val

Skip

right = 4

Loop ends.

Answer = 2

----------------------------------------
Explanation (Simple & Clear)

The right pointer checks every element one by one.

If the current element is equal to val,
we don't want to keep it.

So we simply move right forward.

If the current element is NOT equal to val,
it is a valid element.

We copy it to the left pointer position.

Then we move both pointers forward.

In this way,

all valid elements are collected at the beginning of the array.

The variable count stores how many valid elements remain.

----------------------------------------
Pointer Visualization

Original

[3,2,2,3]

 L
 R

3 is not needed

Skip

----------------------

[3,2,2,3]

 L
   R

2 is valid

Copy to left

[2,2,2,3]

   L
     R

----------------------

Next 2

Copy

[2,2,2,3]

     L
       R

----------------------

3

Skip

Finished

Answer = 2

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

The right pointer scans every element.

Whenever the current element is not equal to val,
I copy it to the left pointer position.

The left pointer always points to the next position where a valid element should be placed.

Elements equal to val are simply skipped.

This removes all occurrences in-place without using extra space.

Time Complexity is O(n) and Space Complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// right scans every element
// left stores valid elements
// Skip val
// Keep everything else
*/
