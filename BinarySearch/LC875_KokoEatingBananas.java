/*
8
Problem: 875. Koko Eating Bananas
Link: https://leetcode.com/problems/koko-eating-bananas/

-----------------------------------------------------

Problem Statement

Koko loves bananas. There are piles of bananas,
and each pile has some bananas.

Koko can decide her eating speed k (bananas/hour).

Each hour:
- She chooses a pile
- Eats k bananas from that pile

If pile < k → she eats all and moves next hour.

Return the minimum k such that she can eat all bananas
within h hours.

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search on Answer

Why:
We need minimum valid speed.
Search space = [1 → max(pile)]

-----------------------------------------------------

Key Idea

1. Try a speed (mid)
2. Calculate total hours needed
3. If hours > h → speed is slow → increase speed
4. Else → possible answer → try smaller speed

-----------------------------------------------------

Algorithm / Process

1. Find max pile → upper bound
2. low = 1, high = max
3. While low <= high:
      mid = guess speed
4. Calculate hours needed
5. If hours > h:
      increase speed
6. Else:
      store answer and try smaller
7. Return answer

-----------------------------------------------------

Code
*/

class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        int max = -1;

        // find max pile
        for (int i = 0; i < n; i++) {
            max = Math.max(piles[i], max);
        }

        int speed = -1;
        int low = 1, high = max;

        while (low <= high) {

            int guessSpeed = (low + high) / 2;

            long hours = findHours(piles, guessSpeed);

            if (hours > h) {
                // speed slow → increase
                low = guessSpeed + 1;
            } else {
                // possible answer
                speed = guessSpeed;
                high = guessSpeed - 1;
            }
        }

        return speed;
    }

    private int findHours(int[] piles, int guessSpeed) {

        long hoursTakingToEat = 0;

        for (int i = 0; i < piles.length; i++) {

            if (piles[i] <= guessSpeed) {
                hoursTakingToEat++;
            } else {

                hoursTakingToEat += (piles[i] / guessSpeed);

                if (piles[i] % guessSpeed != 0) {
                    hoursTakingToEat++;
                }
            }
        }

        return hoursTakingToEat;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log max)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
piles = [3,6,7,11], h = 8

Output:
4

-----------------------------------------------------

Short Interview Explanation

Binary search on speed.
Check if Koko can finish bananas within h hours.
If not → increase speed, else try smaller speed.
*/
