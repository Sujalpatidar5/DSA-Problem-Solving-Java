/*
LeetCode 88 - Merge Sorted Array

Problem Statement:
You are given two sorted integer arrays nums1 and nums2.

nums1 has length = m + n
where first m elements are valid
and last n elements are empty (0).

nums2 has length = n.

Merge nums2 into nums1 such that
nums1 becomes a single sorted array.

The result must be stored inside nums1.

---------------------------------------

Pattern Used:
Two Pointers (Backward Merge)

Why this pattern?

Both arrays are already sorted.

Instead of shifting elements in nums1,
we fill the array from the back.

This avoids overwriting elements.

---------------------------------------

Key Observation:

nums1 has extra space at the end.

So we start filling from the LAST index.

We compare the largest elements
from both arrays and place the larger one.

---------------------------------------

Approach:

1. Set pointer i = m - 1
   (last valid element of nums1)

2. Set pointer j = n - 1
   (last element of nums2)

3. Set pointer k = m + n - 1
   (last index of nums1)

4. Compare nums1[i] and nums2[j]

5. Put the larger value at nums1[k]

6. Move pointer accordingly

7. Continue until nums2 elements are placed

---------------------------------------

Algorithm:

1. i = m - 1
2. j = n - 1
3. k = m + n - 1

4. While j >= 0:

   If i >= 0 AND nums1[i] > nums2[j]
       nums1[k] = nums1[i]
       i--

   Else
       nums1[k] = nums2[j]
       j--

   k--

---------------------------------------

Code:
*/

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;        // last element of nums1
        int j = n - 1;        // last element of nums2
        int k = m + n - 1;    // last index of nums1

        while (j >= 0) {

            if (i >= 0 && nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];
                i--;

            } else {

                nums1[k] = nums2[j];
                j--;

            }

            k--;
        }
    }
}

/*
---------------------------------------

Example:

Input:
nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3

Output:
[1,2,2,3,5,6]

---------------------------------------

Step Example:

Compare from back:

3 vs 6 → put 6
3 vs 5 → put 5
3 vs 2 → put 3
2 vs 2 → put 2
2 vs remaining → continue

---------------------------------------

Time Complexity:

O(m + n)

Because we traverse both arrays once.

---------------------------------------

Space Complexity:

O(1)

No extra array used.
Merge is done inside nums1.

---------------------------------------

Explanation :

"I used two pointers from the end of both arrays.
Since nums1 has extra space at the back,
I compared the largest elements and filled nums1
from the last index. This avoids shifting elements
and keeps the time complexity linear."

---------------------------------------
*/
