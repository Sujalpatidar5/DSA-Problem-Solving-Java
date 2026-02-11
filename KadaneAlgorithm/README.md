# Kadane Algorithm Pattern

## Definition
Kadane’s Algorithm is used to find the **maximum sum of a contiguous subarray**
in an array in **linear time O(n)**.

It works by deciding at every index whether to:
- start a new subarray, or
- extend the previous subarray.

---

## When to Use Kadane Algorithm
Use this pattern when:
- Problem asks for **maximum subarray sum**
- Subarray must be **contiguous**
- max / min
- sum / product / frequency
- You need an **optimal O(n)** solution
- Array contains **positive and negative numbers**

---

## How to Identify Kadane Problems
Look for keywords like:
- Maximum subarray
- Largest sum
- Contiguous subarray
- Maximum absolute sum
- Maximum product subarray
- Subarray with at most / exactly one deletion

If brute force is O(n²), Kadane is usually expected.

---

## Core Idea
At each index, we decide:
- Start new subarray from current element
- OR continue previous subarray

---

## Basic Kadane Template (Maximum Subarray Sum)

```java
int curr = nums[0];
int maxSum = nums[0];

for (int i = 1; i < nums.length; i++) {
    curr = Math.max(nums[i], curr + nums[i]);
    maxSum = Math.max(maxSum, curr);
}
