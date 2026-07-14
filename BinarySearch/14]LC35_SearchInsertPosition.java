/*
========================================
Problem: 35. Search Insert Position
========================================

Problem Statement:

Given a sorted array of distinct integers nums and a target value,

Return the index if the target is found.

If the target is not found,

Return the index where it should be inserted to keep the array sorted.

----------------------------------------
Pattern Used & Why:
Binary Search

Why:
- The array is already sorted.
- Binary Search helps us search in O(log n) time.
- We can also find the correct insertion position if the target does not exist.

----------------------------------------
Key Idea:

Use Binary Search.

If nums[mid] == target

Return mid.

If nums[mid] < target

Search in the right half.

If nums[mid] > target

Search in the left half.

When the loop ends,

left will point to the correct insertion position.

----------------------------------------
Algorithm / Process:

1. left = 0

2. right = n - 1

3. While left <= right

      mid = left + (right - left) / 2

      If nums[mid] == target

            return mid

      Else if nums[mid] < target

            left = mid + 1

      Else

            right = mid - 1

4. Return left.

----------------------------------------
Code:
*/

class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return left;
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(log n)

- Binary Search halves the search space every iteration.

Space Complexity:
O(1)

- No extra space is used.

----------------------------------------
Example

Input:

nums = [1,3,5,6]

target = 5

Output:

2

----------------------------------------
Example 2

Input:

nums = [1,3,5,6]

target = 2

Output:

1

Because 2 should be inserted before 3.

----------------------------------------
Dry Run

Input:

nums = [1,3,5,6]

target = 2

Initially

left = 0

right = 3

--------------------------------

mid = 1

nums[mid] = 3

3 > 2

Search left half

right = 0

--------------------------------

left = 0

right = 0

mid = 0

nums[mid] = 1

1 < 2

Search right half

left = 1

--------------------------------

left = 1

right = 0

Loop ends.

Return left = 1

----------------------------------------
Explanation (Simple & Clear)

Since the array is already sorted,

we use Binary Search.

If the middle element is equal to the target,

we immediately return its index.

If the target is greater than the middle element,

it must be present on the right side,

so we move the left pointer.

If the target is smaller,

it must be present on the left side,

so we move the right pointer.

If the target is not found,

the loop ends.

At that moment,

the left pointer is exactly at the position where the target should be inserted.

So we simply return left.

----------------------------------------
Pointer Visualization

nums = [1,3,5,6]

target = 2

left         right

0              3

mid = 1

3 > 2

Move right

-----------------------

left   right

0        0

mid = 0

1 < 2

Move left

-----------------------

left = 1

right = 0

Loop ends

Return 1

----------------------------------------
Interview Explanation

I solve this problem using Binary Search because the array is sorted.

I compare the target with the middle element.

If they are equal, I return the index.

If the target is greater, I search in the right half.

If the target is smaller, I search in the left half.

If the target is not found, the left pointer will automatically point to the correct insertion position after the loop ends.

So I return left.

Time Complexity is O(log n) and Space Complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// Sorted array
// Binary Search
// Found -> return index
// Not found -> return left (insert position)
*/
