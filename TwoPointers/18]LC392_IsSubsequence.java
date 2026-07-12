/*
========================================
Problem: 392. Is Subsequence
========================================

Problem Statement:

Given two strings s and t,

Return true if s is a subsequence of t,
otherwise return false.

A subsequence is a sequence that can be formed by deleting some (or no) characters from another string without changing the order of the remaining characters.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- One pointer scans string s.
- Another pointer scans string t.
- Whenever characters match, move both pointers.
- Otherwise, move only the pointer of t.

----------------------------------------
Key Idea:

i -> points to current character of s.

j -> points to current character of t.

If s[i] == t[j]

Both characters are matched,
so move both pointers.

Otherwise

Current character of t cannot be used,
so move only j.

At the end,

If i reaches the end of s,

all characters of s were found in order.

----------------------------------------
Algorithm / Process:

1. Initialize

      i = 0
      j = 0

2. While i < s.length() AND j < t.length()

      If s[i] == t[j]

            i++
            j++

      Else

            j++

3. Return

      i == s.length()

----------------------------------------
Code:
*/

class Solution {

    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s.length();
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(n)

n = length of string t

Each character of t is visited at most once.

Space Complexity:
O(1)

No extra space is used.

----------------------------------------
Example

Input:

s = "abc"

t = "ahbgdc"

Output:

true

----------------------------------------
Dry Run

s = "abc"

t = "ahbgdc"

Initially

i = 0
j = 0

--------------------------------

Compare

a and a

Match

i = 1

j = 1

--------------------------------

Compare

b and h

No match

j = 2

--------------------------------

Compare

b and b

Match

i = 2

j = 3

--------------------------------

Compare

c and g

No match

j = 4

--------------------------------

Compare

c and d

No match

j = 5

--------------------------------

Compare

c and c

Match

i = 3

j = 6

Loop ends.

i == s.length()

Return true.

----------------------------------------
Another Example

s = "axc"

t = "ahbgdc"

Compare

a ✓

x ✗

Keep moving j

End of t reached

i != s.length()

Return false.

----------------------------------------
Explanation (Simple & Clear)

The first pointer (i) checks the current character of string s.

The second pointer (j) checks the current character of string t.

If both characters are the same,
it means we found one required character.

So we move both pointers.

If they are different,
the current character in t is not useful.

So we ignore it and move only j.

At the end,

if i reaches the end of string s,

it means every character of s was found in the correct order.

Otherwise,

s is not a subsequence of t.

----------------------------------------
Pointer Visualization

s = "abc"

t = "ahbgdc"

a b c
↑
i

a h b g d c
↑
j

Match

------------------------

a b c
  ↑
  i

a h b g d c
  ↑
  j

No Match

Move j

------------------------

a b c
  ↑
  i

a h b g d c
    ↑
    j

Match

------------------------

a b c
    ↑
    i

a h b g d c
      ↑
      j

Keep moving j

------------------------

a b c
      ↑
      i

a h b g d c
          ↑
          j

Match

Finished

Return true

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

One pointer traverses string s and the other traverses string t.

Whenever the characters match, I move both pointers because one required character has been found.

If the characters do not match, I move only the pointer of string t to continue searching.

At the end, if all characters of s have been matched, then s is a subsequence of t.

Time Complexity is O(n) and Space Complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// i -> string s
// j -> string t
// Match -> move both
// No match -> move j
// i reaches end -> true
*/
