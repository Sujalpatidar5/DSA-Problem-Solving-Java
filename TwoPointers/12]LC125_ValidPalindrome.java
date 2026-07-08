/*
========================================
Problem: 125. Valid Palindrome
========================================

Problem Statement:
Given a string s,

Return true if it is a palindrome after:

- Removing all non-alphanumeric characters
- Ignoring uppercase and lowercase letters

Otherwise return false.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- Compare characters from both ends.
- Skip invalid characters.
- No extra string is required.

----------------------------------------
Key Idea:

Use two pointers:

left  → start
right → end

While moving:

1. Skip non-alphanumeric characters.
2. Convert both characters to lowercase.
3. Compare them.
4. If different → return false.
5. Otherwise move both pointers.

----------------------------------------
Algorithm / Process:

1. Initialize left = 0
2. Initialize right = n-1
3. While left < right

      Skip invalid left character

      Skip invalid right character

      Compare lowercase characters

      If different
           return false

      Move both pointers

4. Return true

----------------------------------------
Code:
*/

class Solution {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char lc = s.charAt(left);
            char rc = s.charAt(right);

            // Skip non-alphanumeric from left
            if (!Character.isLetterOrDigit(lc)) {
                left++;
                continue;
            }

            // Skip non-alphanumeric from right
            if (!Character.isLetterOrDigit(rc)) {
                right--;
                continue;
            }

            // Compare after converting to lowercase
            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
----------------------------------------
Time & Space Complexity:

Time Complexity:
O(n)

- Every character is visited at most once.

Space Complexity:
O(1)

- No extra data structure is used.

----------------------------------------
Example 1:

Input:
s = "A man, a plan, a canal: Panama"

After removing special characters:

amanaplanacanalpanama

Compare:

a == a
m == m
a == a
...

Output:
true

----------------------------------------
Example 2:

Input:
s = "race a car"

Processed string:

raceacar

Compare:

r == r
a != c

Output:
false

----------------------------------------
Dry Run:

Input:

"A man, a plan, a canal: Panama"

left = 'A'
right = 'a'

Compare:

a == a ✓

Move both

left = ' '
Skip

left = 'm'

right = 'm'

Compare

m == m ✓

Continue...

Pointers finally cross.

Return true.

----------------------------------------
Explanation (Simple & Clear)

A palindrome reads the same from left to right and from right to left.

The problem says that spaces, commas, colons, and other special characters should not be considered.

So instead of creating a new string, I use two pointers.

The left pointer starts from the beginning.

The right pointer starts from the end.

If any pointer is on a character that is not a letter or digit, I simply skip it.

When both pointers are on valid characters, I convert them to lowercase and compare them.

If they are different, the string cannot be a palindrome, so I return false.

If they are the same, I move both pointers toward the center.

If the loop finishes without finding any mismatch, the string is a valid palindrome.

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

One pointer starts from the beginning and the other from the end.

I ignore all non-alphanumeric characters and compare characters in lowercase to make the comparison case-insensitive.

If any pair of characters is different, I return false.

Otherwise, I continue until both pointers meet.

The solution runs in O(n) time and uses O(1) extra space.

----------------------------------------
Short Comment (for code memory):

// Skip special characters
// Compare lowercase characters
// Move both pointers
*/
