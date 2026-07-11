/*
========================================
Problem: 80. Remove Duplicates from Sorted Array II
========================================

Problem Statement:
Given a sorted array nums,

Remove duplicates in-place such that each unique
element appears at most two times.

Return the number of elements after removing the
extra duplicates.

Do not use extra space.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- One pointer (right) scans every element.
- One pointer (left) keeps the position where the
  next valid element should be placed.

Since the array is already sorted,
we only need to compare with the element
two positions before.

----------------------------------------
Key Idea:

Every number can appear at most twice.

Suppose we already kept:

1 1

Now if the next number is also 1,

compare with nums[left - 1]

If they are equal,

it means this would become the third occurrence,
so skip it.

Otherwise,
keep the number.

----------------------------------------
Algorithm / Process:

1. If array size ≤ 2
      return length

2. left = 1
3. right = 2
4. count = 2

5. While right < n

      If nums[right] != nums[left - 1]

            left++

            nums[left] = nums[right]

            count++

      right++

6. Return count

----------------------------------------
Code:
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) return nums.length;

        int left = 1;
        int right = 2;
        int count = 2;

        while (right < nums.length) {

            if (nums[right] != nums[left - 1]) {

                left++;
                nums[left] = nums[right];
                count++;
            }

            right++;
        }

        return count;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(n)

- Every element is visited once.

Space Complexity:
O(1)

- No extra array is used.

----------------------------------------
Example:

Input:

nums =

[1,1,1,2,2,3]

Output:

5

Modified array:

[1,1,2,2,3]

----------------------------------------
Dry Run:

Input:

[1,1,1,2,2,3]

Initially

left = 1
right = 2
count = 2

--------------------------------

nums[right] = 1

nums[left-1] = nums[0] = 1

Equal

Third occurrence

Skip

--------------------------------

right = 3

nums[right] = 2

nums[left-1] = 1

Different

left++

nums[2] = 2

count = 3

--------------------------------

right = 4

nums[right] = 2

nums[left-1] = nums[1] = 1

Different

left++

nums[3] = 2

count = 4

--------------------------------

right = 5

nums[right] = 3

nums[left-1] = nums[2] = 2

Different

left++

nums[4] = 3

count = 5

Finished.

Answer = 5

----------------------------------------
Explanation (Simple & Clear)

The array is already sorted, so duplicate numbers are always together.

We are allowed to keep each number at most two times.

The left pointer represents the last valid position in the modified array.

The right pointer scans every element.

For every new element, we compare it with nums[left - 1].

If both are the same, it means adding the current element would create a third occurrence.

So we skip it.

If they are different, the current element is valid.

We move the left pointer forward and place the current element there.

At the end, count represents the number of valid elements remaining in the array.

----------------------------------------
Why compare with nums[left - 1] ?

Suppose the current valid array is:

[1,1]

left = 1

Current number = 1

Compare:

nums[right] == nums[left - 1]

1 == 1

This means two 1's are already kept.

Keeping another 1 would make it appear three times.

So skip it.

Example:

Current valid array:

[1,1,2,2]

left = 3

Current number = 2

Compare:

nums[right] == nums[left - 1]

2 == 2

Already two 2's are present.

Skip the third one.

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

The right pointer scans every element, while the left pointer keeps track of the last valid position.

Since the array is sorted, I compare the current element with nums[left - 1].

If they are different, I keep the current element.

If they are equal, it would become the third occurrence, so I skip it.

This solution works in O(n) time and O(1) extra space.

----------------------------------------
Short Comment (for code memory):

// Compare with nums[left-1]
// Same = third occurrence → skip
// Different = keep
*/
