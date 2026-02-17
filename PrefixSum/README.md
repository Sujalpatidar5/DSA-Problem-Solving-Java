# Prefix Sum Pattern

---------------------------------------

## Definition:

Prefix Sum is a technique where we store running (cumulative) sum of array elements.

prefix[i] = sum of elements from index 0 to i

---------------------------------------

## When To Use Prefix Sum?

Use this pattern when question has:

- Subarray / continuous elements
- Sum of subarrays
- Sum(i…j)
- Sum(i…j) = K
- Sum(i…j) % K = 0
- Pivot / equilibrium index
- Negative numbers present

Important:
If negative numbers are present,
Sliding Window may fail -> Prefix Sum works.

---------------------------------------

## Prefix & Suffix Concept :

- Prefix -> sum from left side
- Suffix -> sum from right side

- prefix[i] = prefix[i-1] + nums[i-1]
- suffix[i] = suffix[i+1] + nums[i+1]

- totalSum = nums[0] + nums[1] + ... + nums[i] + nums[i+1] + ... + nums[n-1]

---------------------------------------

## Flow Logic (TEMPLATE):

Prefix Data Structure -> Loop over array -> Update Prefix -> Check Condition -> Store / Count / Update Answer

---------------------------------------

## Explanation :

"I maintain a running prefix sum.
At every index, I check if there exists
a previous prefix such that their difference
equals the target. This helps solve
subarray sum problems in O(n)."

---------------------------------------
