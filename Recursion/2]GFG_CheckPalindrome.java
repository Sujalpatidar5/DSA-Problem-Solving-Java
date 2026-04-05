/*
Problem: Check if String is Palindrome (GFG)

-----------------------------------------------------

Problem Statement

Given a string s, check whether it is a palindrome or not.

A palindrome is a string that reads the same forward and backward.

-----------------------------------------------------

Pattern Used & Why

Pattern: Recursion (Two Pointers)

Why:
- Compare characters from start and end
- Reduce problem size in each step

-----------------------------------------------------

Key Idea

- Compare s[left] with s[right]
- If equal → move inward
- If not equal → return false

-----------------------------------------------------

Algorithm / Process

1. Start with left = 0, right = n-1
2. If left >= right → return true
3. If characters not equal → return false
4. Otherwise:
      check for (left+1, right-1)

-----------------------------------------------------

Code
*/

class Solution {

    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private boolean isCheck (String s, int low, int high) {
        int len = high - low  + 1;
        
        if (len == 0 || len == 1) {
            return true;
        }
        
        if (s.charAt(low) != s.charAt(high)) {
            return false;
        }
        
        return isCheck(s, low+1, high-1);
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
s = "madam"

Output:
true

-----------------------------------------------------

Short Interview Explanation

Compare first and last characters recursively.
If all match → palindrome.
*/
