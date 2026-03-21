/*
Problem: Segregate 0s and 1s (GFG)

-----------------------------------------------------

Problem Statement

Given an array containing only 0s and 1s,
segregate them so that all 0s come before all 1s.

-----------------------------------------------------

Pattern Used & Why

Pattern: Two Pointers

Why:
We can place 0s on left and 1s on right in single pass.

-----------------------------------------------------

Key Idea

Agar left pe 0 hai → correct position → move forward  
Agar 1 mila → swap with right  

-----------------------------------------------------

Algorithm / Process

1. Initialize:
   left = 0, right = n-1

2. While left <= right:
   - If arr[left] == 0:
        left++
   - Else:
        swap(arr[left], arr[right])
        right--

-----------------------------------------------------

Code
*/

class Solution {

    void segregate0and1(int[] arr, int n) {

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            if (arr[left] == 0) {
                left++;   // correct position
            } 
            else {
                // swap 1 with right side
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                right--;
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
[0,0,1,1,0]

Output:
[0,0,0,1,1]

-----------------------------------------------------

Explanation :

Left pointer 0 ko skip karega.
Agar 1 mila → right side bhej denge.
Single pass me sorting ho jaati hai.

*/
