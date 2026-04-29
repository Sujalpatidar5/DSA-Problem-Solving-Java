/*
===========================================================
🔹 Problem: Implement Magic Dictionary – LeetCode 676
===========================================================

Given:
- Build a dictionary using words
- Search a word such that:
  → EXACTLY ONE character must be different

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Trie + DFS (Backtracking)

Why:
- Trie stores words efficiently
- DFS helps us try all possible one-character modifications

===========================================================
🔹 Key Idea
===========================================================

- While searching:
  ✔ Try same character (no change)
  ✔ Try changing character (only once)

- Use a boolean flag "changed"
  → ensures ONLY one modification is allowed

===========================================================
🔹 Algorithm / Process (Step-by-Step)
===========================================================

Step 1: Build Trie
- Insert all dictionary words

Step 2: Search word using DFS

At each character:
1. Try SAME character → continue normally
2. If not changed yet:
   → try ALL other 25 characters

Step 3: Base case:
- If reached end:
  → return true ONLY if:
     ✔ word exists (eow = true)
     ✔ exactly one change happened

===========================================================
🔹 Code
===========================================================
*/

class MagicDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root;

    public MagicDictionary() {
        root = new Node();
    }

    // build dictionary
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    // insert in Trie
    private void insert(String word) {

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

    // search word
    public boolean search(String word) {
        return dfs(word, 0, root, false);
    }

    // DFS helper
    private boolean dfs(String word, int i, Node curr, boolean changed) {

        // base case
        if (i == word.length()) {
            return curr.eow && changed;
        }

        char ch = word.charAt(i);
        int idx = ch - 'a';

        //  Case 1: same character
        if (curr.children[idx] != null) {
            if (dfs(word, i + 1, curr.children[idx], changed)) {
                return true;
            }
        }

        //  Case 2: change character (only once)
        if (!changed) {

            for (int j = 0; j < 26; j++) {

                if (j != idx && curr.children[j] != null) {

                    if (dfs(word, i + 1, curr.children[j], true)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

/*
===========================================================
🔹 Time Complexity
===========================================================

Let L = length of word

Worst case:
- At each position → try 26 options (only once fully)

Time → O(26 * L) ≈ O(L)

(Practical case much faster due to pruning)

===========================================================
🔹 Space Complexity
===========================================================

Trie storage → O(N * L)
Recursion stack → O(L)

Total → O(N * L)

===========================================================
🔹 Example
===========================================================

Dictionary = ["hello", "hallo", "leetcode"]

search("hello") → true (change 'e' → 'a')
search("hhllo") → true
search("hell") → false
search("leetcodd") → true

===========================================================
🔹 Explanation 
===========================================================

I store all words in a Trie.

While searching:
- I try to match normally
- But I also allow ONE character change

I use a boolean "changed":
- If false → I can try changing character
- If true → I must match exactly

At the end:
- Word must exist AND
- Exactly one change should be used

===========================================================
*/
