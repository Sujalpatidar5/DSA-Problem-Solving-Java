/*
========================================
Problem: 283. Move Zeroes
========================================

Problem Statement:

Given an integer array nums,

Move all 0's to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be done in-place without making a copy of the array.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- One pointer (read) scans every element.
- One pointer (write) keeps track of where the next non-zero element should go.
- Whenever a non-zero element is found, swap it with the write position.

----------------------------------------
Key Idea:

read -> checks every element.

write -> points to the position where the next non-zero element should be placed.

If nums[read] == 0

Skip it.

If nums[read] != 0

Swap nums[read] and nums[write].

Move both pointers.

----------------------------------------
Algorithm / Process:

1. write = 0
2. read = 0

3. While read < n

      If nums[read] == 0

            read++

      Else

            Swap(nums[write], nums[read])

            write++
            read++

4. Array is modified in-place.

----------------------------------------
Code:
*/

class Solution {

    public void moveZeroes(int[] nums) {

        int n = nums.length;

        if (n <= 1) return;

        int write = 0;
        int read = 0;

        while (read < n) {

            if (nums[read] == 0) {

                read++;

            } else {

                int temp = nums[write];
                nums[write] = nums[read];
                nums[read] = temp;

                write++;
                read++;
            }
        }
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(n)

- Every element is visited exactly once.

Space Complexity:
O(1)

- No extra array is used.

----------------------------------------
Example

Input:

nums = [0,1,0,3,12]

Output:

[1,3,12,0,0]

----------------------------------------
Dry Run

nums = [0,1,0,3,12]

Initially

write = 0
read = 0

--------------------------------

read = 0

nums[0] = 0

Skip

read = 1

--------------------------------

read = 1

nums[1] = 1

Swap nums[0] and nums[1]

Array

[1,0,0,3,12]

write = 1

read = 2

--------------------------------

read = 2

nums[2] = 0

Skip

read = 3

--------------------------------

read = 3

nums[3] = 3

Swap nums[1] and nums[3]

Array

[1,3,0,0,12]

write = 2

read = 4

--------------------------------

read = 4

nums[4] = 12

Swap nums[2] and nums[4]

Array

[1,3,12,0,0]

write = 3

read = 5

Loop ends.

----------------------------------------
Explanation (Simple & Clear)

The read pointer checks every element one by one.

If the current element is 0,
we simply skip it because zero should be moved to the end.

If the current element is non-zero,
we swap it with the element at the write pointer.

The write pointer always points to the position where the next non-zero element should be placed.

This automatically pushes all zeros toward the end while keeping the order of non-zero elements the same.

The array is modified in-place, so no extra array is required.

----------------------------------------
Pointer Visualization

Initial

[0,1,0,3,12]

 W
 R

Skip 0

------------------------

[0,1,0,3,12]

 W
   R

Swap

[1,0,0,3,12]

   W
     R

------------------------

Skip 0

[1,0,0,3,12]

   W
       R

Swap

[1,3,0,0,12]

     W
         R

------------------------

Swap

[1,3,12,0,0]

        W

Finished

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

The read pointer scans every element in the array.

The write pointer always points to the position where the next non-zero element should be placed.

Whenever I find a non-zero element, I swap it with the write pointer position and move both pointers.

If I find a zero, I simply move the read pointer.

This moves all zeros to the end while preserving the order of non-zero elements.

Time Complexity is O(n) and Space Complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// read scans every element
// write stores next non-zero
// Skip zeros
// Swap non-zero with write position
*/
