/*
========================================
Problem: 344. Reverse String
========================================

Problem Statement:
Given a character array s,

Reverse the array in-place.

Do not create another array.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- One pointer starts from the beginning.
- One pointer starts from the end.
- Swap both characters.
- Continue until pointers meet.

No extra array is needed.

----------------------------------------
Key Idea:

Swap

first ↔ last

Then move both pointers toward the center.

----------------------------------------
Algorithm / Process:

1. left = 0
2. right = n - 1
3. While left < right

      Swap s[left] and s[right]

      left++
      right--

4. Array becomes reversed.

----------------------------------------
Code:
*/

class Solution {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(n)

- Every character is swapped at most once.

Space Complexity:
O(1)

- Only one temporary variable is used.

----------------------------------------
Example:

Input:

['h','e','l','l','o']

Step 1:

Swap h ↔ o

[o,e,l,l,h]

Step 2:

Swap e ↔ l

[o,l,l,e,h]

Pointers meet.

Output:

['o','l','l','e','h']

----------------------------------------
Dry Run:

Input:

['a','b','c','d']

left = 0
right = 3

Swap

a ↔ d

[d,b,c,a]

left = 1
right = 2

Swap

b ↔ c

[d,c,b,a]

Pointers cross.

Finished.

----------------------------------------
Explanation (Simple & Clear)

The problem asks us to reverse the character array without creating another array.

So, I use the Two Pointer technique.

One pointer starts from the beginning of the array.

The other pointer starts from the end.

I swap both characters.

After swapping, I move the left pointer one step forward and the right pointer one step backward.

I continue this process until both pointers meet.

This reverses the array in-place without using any extra array.

----------------------------------------
Interview Explanation

I use the Two Pointer approach.

One pointer starts from the beginning and the other from the end.

In every iteration, I swap the two characters and move both pointers toward the center.

The process continues until the pointers meet.

This solution works in O(n) time and O(1) extra space.

----------------------------------------
Short Comment (for code memory):

// Swap first and last
// Move both pointers
// Reverse in-place
*/
