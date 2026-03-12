/*
LeetCode 1189 - Maximum Number of Balloons

Problem Statement:
Given a string text, return the maximum number of times
the word "balloon" can be formed using the characters of text.

Each character in text can be used only once.

---------------------------------------

Pattern Used:
Hashing / Frequency Counting

Why this pattern?

We only need to count how many times each character
appears in the string and then check how many complete
"balloon" words can be formed from those counts.

---------------------------------------

Key Idea:

The word "balloon" contains the characters:

b a l l o o n

Important observation:
- 'l' appears twice
- 'o' appears twice

So when counting frequencies:
countL = freq['l'] / 2
countO = freq['o'] / 2

The answer will be the minimum count among
b, a, l, o, n.

---------------------------------------

Approach:

1. Traverse the string and store frequency of each character
   using a HashMap.
2. Extract frequency of characters required for "balloon".
3. Since 'l' and 'o' appear twice in the word,
   divide their counts by 2.
4. The maximum number of "balloon" words we can form
   is the minimum among all required character counts.

---------------------------------------

Algorithm:

1. Create a HashMap to store character frequencies.
2. Traverse the string and update frequency.
3. Get counts of:
      b, a, l, o, n
4. Divide count of 'l' and 'o' by 2.
5. Return minimum of all counts.

---------------------------------------

Code:
*/

import java.util.HashMap;

class Solution {

    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int countB = freq.getOrDefault('b', 0);
        int countA = freq.getOrDefault('a', 0);
        int countL = freq.getOrDefault('l', 0) / 2;
        int countO = freq.getOrDefault('o', 0) / 2;
        int countN = freq.getOrDefault('n', 0);

        int ans = Math.min(
                    Math.min(countB, countA),
                    Math.min(Math.min(countL, countO), countN)
                 );

        return ans;
    }
}

/*
---------------------------------------

Example:

Input:
text = "loonbalxballpoon"

Output:
2

Explanation:
We can form "balloon" twice.

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation :

"I count the frequency of each character in the string.
Since the word 'balloon' requires two 'l' and two 'o',
I divide their frequencies by 2.
The answer is the minimum frequency among the required
characters b, a, l, o, n."

---------------------------------------
*/
