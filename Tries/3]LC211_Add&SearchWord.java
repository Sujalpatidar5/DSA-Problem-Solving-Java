/*
===========================================================
🔹 Problem: Add and Search Word – LeetCode 211
===========================================================

Given:
Design a data structure that supports:
1. addWord(word)
2. search(word) where '.' can match ANY character

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Trie + DFS (Backtracking)

Why:
- Trie for efficient word storage
- DFS needed because '.' means multiple possible paths

===========================================================
🔹 Key Idea
===========================================================

- Normal characters → follow one path
- '.' → try ALL possible children (branching)

===========================================================
🔹 Algorithm / Process
===========================================================

addWord:
1. Start from root
2. Create nodes if not present
3. Mark end of word

search:
1. Call recursive helper
2. If character != '.':
   → go to specific child
3. If character == '.':
   → try all 26 children (DFS)
4. If reached end:
   → check endOfWord

===========================================================
🔹 Code
===========================================================
*/

class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    // add word (same as insert)
    public void addWord(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // search word
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    // DFS helper
    public boolean helper(String word, int i, Node curr) {

        // base case
        if (i == word.length()) {
            return curr.eow;
        }

        char ch = word.charAt(i);

        // normal character
        if (ch != '.') {

            int idx = ch - 'a';

            if (curr.children[idx] == null) return false;

            return helper(word, i + 1, curr.children[idx]);
        }

        // '.' wildcard
        else {

            for (int j = 0; j < 26; j++) {

                if (curr.children[j] != null) {

                    if (helper(word, i + 1, curr.children[j])) {
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
🔹 Time & Space Complexity
===========================================================

addWord → O(L)

search:
- Normal case → O(L)
- With '.' → O(26^L) worst case

Space → O(N * L)

===========================================================
🔹 Example
===========================================================

addWord("bad")
addWord("dad")
addWord("mad")

search("bad") → true
search(".ad") → true
search("b..") → true
search("pad") → false

===========================================================
🔹 Explanation 
===========================================================

I use Trie to store all words.

For addWord:
- I insert characters one by one
- Mark last node as end of word

For search:
- If normal character → go in one direction
- If '.' → I try all possible children (DFS)

If any path gives true → return true

===========================================================
*/
