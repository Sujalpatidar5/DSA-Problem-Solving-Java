/*
========================================
Problem: 560. Subarray Sum Equals K
========================================

Problem Statement:

Given an integer array nums and an integer k,

return the total number of continuous subarrays
whose sum is exactly equal to k.

----------------------------------------
Pattern Used:
Prefix Sum + HashMap

Why:
- We need to find the sum of continuous subarrays.
- Brute force would take O(n^2).
- Prefix Sum + HashMap solves it in O(n).

----------------------------------------
Key Idea:

Suppose:

prefixSum = sum of elements from the beginning
up to the current index.

We want a subarray with sum = k.

If an earlier prefix sum was:

prefixSum - k

then:

current prefixSum - previous prefixSum = k

So we check whether:

prefixSum - k

already exists in the HashMap.

The HashMap stores:

prefix sum -> how many times this prefix sum has appeared

----------------------------------------
Important:

map.put(0, 1);

This means:

A prefix sum of 0 has appeared once.

It is necessary for subarrays that start from index 0.

----------------------------------------
Algorithm / Process:

1. Create a HashMap.

2. Put:

      map.put(0, 1);

3. Keep a running prefixSum.

4. For every number:

      prefixSum += num;

5. Calculate:

      req = prefixSum - k;

6. If req exists in the map:

      count += map.get(req);

7. Store the current prefixSum:

      map.put(prefixSum,
              map.getOrDefault(prefixSum, 0) + 1);

8. Return count.

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {

            prefixSum += num;

            int req = prefixSum - k;

            if (map.containsKey(req)) {
                count += map.get(req);
            }

            map.put(prefixSum,
                    map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(n)

We visit every element only once.

HashMap operations are O(1) on average.

Space Complexity:
O(n)

The HashMap can store up to n different prefix sums.

----------------------------------------
Example

Input:

nums = [1, 1, 1]
k = 2

Output:

2

The two subarrays are:

[1, 1] -> sum = 2
[1, 1] -> sum = 2

----------------------------------------
Dry Run

nums = [1, 1, 1]
k = 2

Initially:

map = {0=1}
prefixSum = 0
count = 0

--------------------------------
Step 1:

num = 1

prefixSum = 1

req = prefixSum - k
    = 1 - 2
    = -1

-1 is not in map.

So:

count = 0

Store prefixSum:

map = {0=1, 1=1}

--------------------------------
Step 2:

num = 1

prefixSum = 2

req = 2 - 2
    = 0

0 exists in map.

map.get(0) = 1

So:

count = 0 + 1
      = 1

Store prefixSum:

map = {0=1, 1=1, 2=1}

We found:

[1,1]

--------------------------------
Step 3:

num = 1

prefixSum = 3

req = 3 - 2
    = 1

1 exists in map.

map.get(1) = 1

So:

count = 1 + 1
      = 2

Store prefixSum:

map = {0=1, 1=1, 2=1, 3=1}

We found the second:

[1,1]

--------------------------------
Final Answer:

count = 2

----------------------------------------
Why prefixSum - k works

This is the most important part.

Suppose:

current prefixSum = 10

and:

k = 3

We need a subarray whose sum is 3.

We know:

current prefixSum
-
previous prefixSum
=
subarray sum

So:

10 - previous prefixSum = 3

Therefore:

previous prefixSum = 10 - 3
                   = 7

So if prefixSum 7 appeared earlier,

the elements between that old position and the current position
have sum exactly 3.

That's why we calculate:

req = prefixSum - k

and search for req in the HashMap.

----------------------------------------
Why do we store the frequency?

We don't only store whether a prefix sum exists.

We store how many times it appeared.

Example:

nums = [1, -1, 1]
k = 1

Prefix sums:

1
0
1

The prefix sum 1 appears twice.

When the current prefix sum is 1,

we need:

1 - 1 = 0

If a prefix sum 0 occurred multiple times,
each occurrence can create a different valid subarray.

Therefore:

map.get(req)

gives the number of valid subarrays ending at the current index.

----------------------------------------
Why map.put(0, 1)?

This is very important.

Consider:

nums = [3]
k = 3

Initially:

map = {0=1}

After processing 3:

prefixSum = 3

req = 3 - 3
    = 0

0 exists in the map.

So:

count += 1

This represents the subarray:

[3]

which starts from index 0.

Without:

map.put(0, 1);

we would miss subarrays that start from the beginning.

----------------------------------------
Simple Understanding

Think of prefixSum as:

"How much sum have I collected until now?"

Now suppose I have collected 10.

I want a subarray with sum 3.

Then I need to have collected 7 before starting that subarray.

Because:

10 - 7 = 3

So I simply check:

"Have I seen prefix sum 7 before?"

If yes, that creates a subarray with sum 3.

In general:

needed prefix = current prefix - k

The HashMap helps us quickly find how many times
that needed prefix has appeared.

----------------------------------------
Why not use Sliding Window?

Sliding Window generally works well when the values have properties
that allow us to safely move the window based on its sum,
such as all numbers being positive.

Here, nums can contain negative numbers.

For example:

[1, -1, 1]

Because negative values can decrease the sum,
we cannot reliably decide whether to move the left or right pointer.

Prefix Sum + HashMap works even when negative numbers are present.

----------------------------------------
Interview Explanation

I use Prefix Sum with a HashMap.

The prefix sum represents the total sum from the beginning
up to the current index.

For every element, I calculate:

required = prefixSum - k

If this required prefix sum has appeared before,
then the difference between that previous prefix sum
and the current prefix sum is exactly k.

The HashMap stores the frequency of every prefix sum,
so if the required prefix appears multiple times,
I add its frequency to the answer.

I initialize the map with:

0 -> 1

to handle subarrays that start from index 0.

The solution takes O(n) time and O(n) space.

----------------------------------------
Short Memory Trick

// Prefix Sum + HashMap
// Need: prefixSum - k
// If found -> add its frequency
// Then store current prefixSum
// map.put(0, 1) handles subarrays starting at 0
*/
