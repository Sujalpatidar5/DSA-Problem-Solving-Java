/*
===========================================================
🔹 Problem: Longest Common Prefix – LeetCode 14
===========================================================

Given:
Find the longest common prefix string among an array of strings.

If no common prefix → return ""

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Sorting + Greedy

Why:
- After sorting, most different strings go to ends
- So only first and last string comparison is enough

===========================================================
🔹 Key Idea
===========================================================

- Sort the array
- Compare first and last string
- Build prefix until mismatch

===========================================================
🔹 Algorithm / Process
===========================================================

1. Sort the array
2. Take first and last string
3. Compare character by character
4. Stop at mismatch
5. Build answer

===========================================================
🔹 Code
===========================================================
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < first.length(); i++) {

            if (first.charAt(i) != last.charAt(i)) {
                break;
            }

            result.append(first.charAt(i));
        }

        return result.toString();
    }
}

/*
===========================================================
🔹 Time & Space Complexity
===========================================================

Sorting → O(N log N)
Comparison → O(L)

Total → O(N log N)

Space → O(1)

===========================================================
🔹 Example
===========================================================

Input: ["club", "clap", "clove"]

Sorted:
["clap", "clove", "club"]

Compare:
clap vs club → "cl"

Output: "cl"

===========================================================
🔹 Explanation (Your Style)
===========================================================

I sort the array first.

Then I compare only first and last string
because they are most different.

I check character by character:
- If same → add to result
- If different → stop

That built string is my longest common prefix.

===========================================================


===========================================================
🔹 Comparison with Trie Approach (Old Code)
===========================================================

Trie Approach:
- Build full Trie
- Traverse until branching

Time → O(N * L)
Space → O(N * L)

Problems:
❌ Extra memory
❌ Complex
❌ Overkill for this problem

-----------------------------------------------------------

Sorting Approach (Current):
- No extra DS
- Very simple
- Only compare 2 strings

Time → O(N log N)
Space → O(1)

Advantages:
✅ Easy to code
✅ Easy to explain
✅ Interview preferred

-----------------------------------------------------------

 Final Conclusion:

- Trie → Good for learning
- Sorting → Better for interviews
- Best → Horizontal scan (even simpler)

===========================================================
*/
