/*
Problem: 75. Sort Colors (LeetCode)

-----------------------------------------------------

Problem Statement

Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent.

Color Mapping:
0 → Red
1 → White
2 → Blue

-----------------------------------------------------

Pattern Used & Why

Pattern: Dutch National Flag Algorithm

Why:
We need single pass + constant space sorting.
3 pointers divide array into 3 regions.

-----------------------------------------------------

Key Idea

Maintain 3 regions:
[0 ... low-1] → 0
[low ... mid-1] → 1
[mid ... high] → unknown
[high+1 ... n-1] → 2

-----------------------------------------------------

Algorithm / Process

1. Initialize:
   low = 0, mid = 0, high = n-1

2. While mid <= high:
   - If nums[mid] == 0:
        swap(low, mid)
        low++, mid++

   - If nums[mid] == 1:
        mid++

   - If nums[mid] == 2:
        swap(mid, high)
        high--

-----------------------------------------------------

Code
*/

class Solution {

    public void sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                // 0 → left side
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // 1 → correct position
                mid++;
            } 
            else {
                // 2 → right side
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
[2,0,2,1,1,0]

Output:
[0,0,1,1,2,2]

-----------------------------------------------------

Explanation :

3 pointers use kiye (low, mid, high).
0 ko left bheja, 2 ko right bheja,
1 automatically middle me set ho gaya.

*/
