/*
========================================
Problem: 744. Find Smallest Letter Greater Than Target
========================================

Problem Statement:

You are given a sorted array of characters letters and a target character.

Return the smallest character in the array that is strictly greater than target.

The letters wrap around.

This means if no character is greater than target,
return the first character of the array.

----------------------------------------
Pattern Used & Why:
Binary Search

Why:
- The array is already sorted.
- We need to find the first character greater than the target.
- Binary Search finds it in O(log n) time.

----------------------------------------
Key Idea:

Keep searching for a better answer.

If letters[mid] > target

- Store it as a possible answer.
- Search on the left side to find an even smaller valid character.

Otherwise

- Search on the right side.

Initialize answer as letters[0]
to handle the wrap-around case automatically.

----------------------------------------
Algorithm / Process:

1. low = 0

2. high = n - 1

3. ans = letters[0]

4. While low <= high

      mid = low + (high - low) / 2

      If letters[mid] > target

            ans = letters[mid]

            high = mid - 1

      Else

            low = mid + 1

5. Return ans.

----------------------------------------
Code:
*/

class Solution {

    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0;
        int high = letters.length - 1;

        char ans = letters[0];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {

                ans = letters[mid];
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(log n)

- Binary Search halves the search space in every iteration.

Space Complexity:
O(1)

- No extra space is used.

----------------------------------------
Example 1

Input:

letters = ['c','f','j']

target = 'a'

Output:

'c'

----------------------------------------
Example 2

Input:

letters = ['c','f','j']

target = 'c'

Output:

'f'

----------------------------------------
Example 3

Input:

letters = ['c','f','j']

target = 'j'

Output:

'c'

Because the letters wrap around.

----------------------------------------
Dry Run

Input:

letters = ['c','f','j']

target = 'd'

Initially

low = 0

high = 2

ans = 'c'

--------------------------------

mid = 1

letters[mid] = 'f'

'f' > 'd'

Possible answer = 'f'

Search left

high = 0

--------------------------------

low = 0

high = 0

mid = 0

letters[mid] = 'c'

'c' <= 'd'

Search right

low = 1

--------------------------------

low = 1

high = 0

Loop ends

Return 'f'

----------------------------------------
Explanation (Simple & Clear)

Since the array is sorted,

we use Binary Search.

Whenever we find a letter that is greater than the target,

it can be our answer.

But there may be another smaller valid letter on the left side.

So we store the current answer and continue searching on the left.

If the current letter is smaller than or equal to the target,

it cannot be the answer,

so we search on the right.

If no letter greater than the target exists,

the answer remains letters[0],

which automatically handles the wrap-around condition.

----------------------------------------
Pointer Visualization

letters = ['c','f','j']

target = 'd'

low          high

0              2

mid = 1

'f' > 'd'

ans = 'f'

Move high

----------------------

low   high

0       0

mid = 0

'c' <= 'd'

Move low

----------------------

low = 1

high = 0

Loop ends

Return 'f'

----------------------------------------
Interview Explanation

I use Binary Search because the array is sorted.

Whenever I find a character greater than the target,

I save it as a possible answer and continue searching on the left to find a smaller valid character.

If the current character is smaller than or equal to the target,

I move to the right.

I initialize the answer with the first character of the array so that if no greater character exists,

the wrap-around condition is handled automatically.

Time Complexity is O(log n) and Space Complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// Sorted array
// Find first character > target
// Save answer
// Search left for smaller valid answer
// If not found -> return first character
*/
