/*
Problem: 74. Search a 2D Matrix
Link: https://leetcode.com/problems/search-a-2d-matrix/

-----------------------------------------------------

Problem Statement

You are given an m x n matrix with the following properties:

1. Each row is sorted in ascending order
2. First element of each row is greater than last element of previous row

Given a target value, return true if it exists in the matrix.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search on Flattened Array

Why:
Matrix ko 1D sorted array ki tarah treat kar sakte hain.

-----------------------------------------------------

Key Idea

- Total elements = m * n
- Index ko map karte hain:

    row = index / n  
    col = index % n  

-----------------------------------------------------

Algorithm / Process

1. Treat matrix as 1D sorted array
2. low = 0, high = m*n - 1
3. Binary search apply karo
4. Mid ko (row, col) me convert karo
5. Compare with target

-----------------------------------------------------

Code
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m * n - 1;

        while (low <= high) {

            int guess = (low + high) / 2;

            int row = guess / n;
            int col = guess % n;

            if (matrix[row][col] == target) {
                return true;
            } 
            else if (matrix[row][col] < target) {
                low = guess + 1;
            } 
            else {
                high = guess - 1;
            }
        }

        return false;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(log(m*n))

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
matrix = [
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
], target = 3

Output:
true

-----------------------------------------------------

Explanation :

Treat matrix as sorted 1D array.
Use binary search.
Convert index to row & col using division and modulo.

*/
