/*
GFG - Maximum Sum Subarray of Size K

Problem Statement:
Given an array of integers Arr of size N and an integer K,
find the maximum sum of any contiguous subarray of size K.

--------------------------------------------------

Pattern Used:
Sliding Window (Fixed Size)

--------------------------------------------------

Why this pattern?

- We are dealing with subarray (continuous elements).
- Window size K is fixed.
- We must consider exactly K elements every time.
- Brute force takes O(n²).
- Sliding Window reduces it to O(n).

--------------------------------------------------

Key Observation:

Instead of recalculating sum for every subarray of size K:

1) Build first window of size K.
2) Then slide the window:
   - Add next element
   - Remove first element of previous window

This keeps window size constant.

--------------------------------------------------

Approach:

1. If N < K → return 0.
2. Compute sum of first K elements.
3. Store it as initial answer.
4. Slide window from index K to N-1:
   - Add Arr[right]
   - Subtract Arr[right - K]
   - Update maximum
5. Return answer.

--------------------------------------------------

Algorithm:

1. windowSum = 0
2. For i = 0 to K-1:
       windowSum += Arr[i]
3. ans = windowSum
4. For right = K to N-1:
       windowSum += Arr[right]
       windowSum -= Arr[right - K]
       ans = max(ans, windowSum)
5. Return ans

--------------------------------------------------

Code:
*/

class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {

        if (N < K) return 0;

        long windowSum = 0;

        // Build first window
        for (int i = 0; i < K; i++) {
            windowSum += Arr.get(i);
        }

        long ans = windowSum;

        // Slide the window
        for (int right = K; right < N; right++) {

            windowSum += Arr.get(right);       // Add new element
            windowSum -= Arr.get(right - K);   // Remove old element

            ans = Math.max(ans, windowSum);
        }

        return ans;
    }
}

/*
--------------------------------------------------

Example:

Input:
Arr = [100, 200, 300, 400]
K = 2

Windows:
[100, 200] → 300
[200, 300] → 500
[300, 400] → 700

Output:
700

--------------------------------------------------

Time Complexity:
O(N)

Space Complexity:
O(1)

--------------------------------------------------
 Explanation :

"I used the Fixed Size Sliding Window technique.
Since K is fixed, I calculated the first window sum.
Then I kept sliding the window by adding one element
and removing one element.
This avoids recalculating sums and gives O(N) time."

--------------------------------------------------
*/
