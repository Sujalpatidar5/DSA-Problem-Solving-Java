/*
LeetCode 1423 - Maximum Points You Can Obtain from Cards

Problem Statement:
You are given an integer array cardPoints.

Each card has some points.

You can take exactly k cards.

You can take cards only from:
- the beginning of the array
OR
- the end of the array

Return the maximum score you can obtain.

---------------------------------------

Pattern Used:
Sliding Window

Why this pattern?

Instead of selecting k cards directly,
we observe an important idea.

If we take k cards from the ends,
that means we are leaving
(n - k) cards somewhere in the middle.

So the problem becomes:

Find the MINIMUM sum subarray
of size (n - k).

Then subtract it from total sum.

---------------------------------------

Key Idea:

Total Score = totalSum - minimumSubarraySum

Where:
subarray size = n - k

---------------------------------------

Approach:

1. Calculate total sum of array.

2. Window size = n - k.

3. Find the minimum sum subarray of size (n - k)
   using sliding window.

4. Answer = totalSum - minSum.

---------------------------------------

Algorithm:

1. Compute totalSum of all elements.

2. windowSize = n - k

3. If windowSize == 0
   return totalSum.

4. Compute first window sum.

5. Slide the window across array:
   Add next element
   Remove previous element.

6. Track minimum window sum.

7. Return totalSum - minSum.

---------------------------------------

Code:
*/

class Solution {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // Step 1: calculate total sum
        int totalSum = 0;
        for (int num : cardPoints) {
            totalSum += num;
        }

        // Step 2: window size
        int windowSize = n - k;

        // If we take all cards
        if (windowSize == 0) return totalSum;

        // Step 3: calculate first window sum
        int windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        // Step 4: slide window
        for (int i = windowSize; i < n; i++) {

            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];

            minSum = Math.min(minSum, windowSum);
        }

        // Step 5: answer
        int ans = totalSum - minSum;
        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
cardPoints = [1,2,3,4,5,6,1]
k = 3

Output:
12

Explanation:

Best choice:
Take 6 + 5 + 1 = 12

---------------------------------------

Time Complexity:

First loop → O(n)
Sliding window → O(n)

Total → O(n)

---------------------------------------

Space Complexity:

O(1)

No extra space used.

---------------------------------------

Explanation :

"Instead of directly picking k cards
from the front or back,
I observed that we are leaving
(n - k) cards in the middle.

So I found the minimum sum subarray
of size (n - k) using sliding window
and subtracted it from the total sum."

---------------------------------------
*/
