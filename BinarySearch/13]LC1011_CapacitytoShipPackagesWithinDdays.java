/*
Problem: 1011. Capacity To Ship Packages Within D Days

-----------------------------------------------------

Problem Statement

Given an array weights and an integer days,
return the minimum capacity of ship required
to deliver all packages within given days.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search on Answer

Why:
- Answer is in a range (capacity)
- We can check if a capacity is valid or not
- If valid → try smaller
- If not → increase capacity

-----------------------------------------------------

Key Idea

- Minimum capacity = max(weights)
- Maximum capacity = sum(weights)

Binary search between this range.

For each capacity:
- Check how many days it takes
- If days <= given → valid

-----------------------------------------------------

Algorithm / Process

1. Find max weight and total sum
2. Apply binary search on range [max, sum]
3. For each mid (capacity):
   - Calculate required days
4. If days > allowed → increase capacity
5. Else → store answer and try smaller

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int max = -1;
        long sum = 0;

        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        long left = max, right = sum;
        long capacity = -1;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            long neededDays = findDays(weights, mid);

            if (neededDays > days) {
                left = mid + 1;
            } else {
                capacity = mid;
                right = mid - 1;
            }
        }

        return (int) capacity;
    }

    private long findDays(int[] weights, long capacity) {

        long days = 1;
        long curr = 0;

        for (int w : weights) {

            if (curr + w > capacity) {
                days++;
                curr = 0;
            }

            curr += w;
        }

        return days;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log(sum))

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5

Output:
15

-----------------------------------------------------

Explanation 

I use Binary Search on answer.

The capacity must lie between:
- max weight (minimum possible)
- sum of weights (maximum possible)

For a guessed capacity:
- I simulate shipping
- Count how many days it takes

If days required is more:
- Capacity is too small → increase it

If days required is within limit:
- It is valid → try smaller capacity

Finally, I return the minimum valid capacity.
*/
