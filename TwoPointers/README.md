# Two Pointers Pattern

## What is Two Pointers?
Two pointers technique uses two indices/pointers to traverse an array or string
from different positions to reduce time complexity.

## When to use?
- Array / String /LL problems
- Sorted data
- Pair / triplets / quadruple / subarray / subsets
- Merge / Remove duplicates / rearrange
- Reduce O(n²) to O(n)

## Common Pointer Types
- Left & Right
- Slow & Fast
- Start & End

Pointers may start from :
1. 0, n-1
2. 0, 1
3. 0, 0
4. -1, 0
5. n-2, n-1
6. n-1, n-1

## Template

int left = 0, right = n-1;
while (left < right ) {
   //logic 
   if (condition) {
      left++;
   } else {
      right--
   }
}











