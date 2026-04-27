/*
===========================================================
🔹 Problem: Longest Common Prefix – LeetCode 14
===========================================================

Given:
Find the longest common prefix string among an array of strings.

If there is no common prefix → return ""

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Trie

Why:
- Common prefix = shared path from root
- Trie naturally stores prefix structure
- We can stop when branching happens

===========================================================
🔹 Key Idea
===========================================================

- Insert all words into Trie
- Traverse from root
- Keep moving while:
  ✔ only ONE child exists
  ✔ current node is NOT end of word

- Stop when:
  ❌ multiple branches OR
  ❌ end of any word

===========================================================
🔹 Algorithm / Process
===========================================================

1. Insert all strings into Trie
2. Start from root
3. For each node:
   - Count children
   - If count == 1 and not end of word:
        → move forward
        → add character
   - Else stop
4. Return prefix

===========================================================
🔹 Code
===========================================================
*/

class Solution {

    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root = new Node();

    // insert into Trie
    public void insert(String word) {

        Node curr = root;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public String longestCommonPrefix(String[] strs) {

        // build Trie
        for (String word : strs) {
            insert(word);
        }

        StringBuilder prefix = new StringBuilder();
        Node curr = root;

        while (true) {

            int count = 0;
            int index = -1;

            // count children
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    count++;
                    index = i;
                }
            }

            // stop condition
            if (count != 1 || curr.eow) break;

            curr = curr.children[index];
            prefix.append((char)(index + 'a'));
        }

        return prefix.toString();
    }
}

/*
===========================================================
🔹 Time & Space Complexity
===========================================================

Insert all words → O(N * L)
Traversal → O(L)

Total → O(N * L)

Space → O(N * L)

===========================================================
🔹 Example
===========================================================

Input: ["flower", "flow", "flight"]

Trie path:
f → l → (branch happens here)

Output: "fl"

===========================================================
🔹 Explanation (Simple)
===========================================================

I insert all strings into a Trie.

Then I start from root and move forward only if:
- There is exactly one child (no branching)
- Current node is not end of a word

As soon as:
- Multiple children appear OR
- A word ends

I stop, because prefix ends there.

The path I traveled is the longest common prefix.

===========================================================
*/
