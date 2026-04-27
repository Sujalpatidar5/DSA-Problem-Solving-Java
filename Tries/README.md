#  Trie (Prefix Tree)

-----------------------------------------------------

##  What is Trie?

Trie is a tree-based data structure used to store strings efficiently.

It is mainly used for:
- Prefix search
- Dictionary search
- Autocomplete systems
- Spell checkers

Each node represents a character.

-----------------------------------------------------

##  Key Idea

Instead of storing full words,
we store characters one by one in a tree.

Example:
Words → "cat", "car"

Trie structure:

        root
         |
         c
         |
         a
        / \
       t   r

-----------------------------------------------------

##  Trie Node Structure

Each node contains:
- children (array)
- eow (marks end of word)

Java:
class Node {
    Node[] children = new Node[26];
    boolean eow = false;
}

-----------------------------------------------------

##  Operations

### 1. Insert

- Start from root
- For each char:
  - Create node if not present
  - Move forward
- Mark last node as eow = true

-----------------------------------------------------

### 2. Search

- Traverse character by character
- If missing -> return false
- At end ->  check isEnd

-----------------------------------------------------

### 3. StartsWith

- Same as search
- No need to check eow

-----------------------------------------------------

##  Complexity

Insert → O(L)  
Search → O(L)  
StartsWith → O(L)  

Space → O(N * L)

-----------------------------------------------------

##  When to Use Trie?

- Prefix search
- Word dictionary
- Autocomplete
- Search suggestions
- Word break problems
- Predix matching

-----------------------------------------------------

##  Explanation

I use Trie to store strings character by character.

Each node represents a character and has links to next characters.

For insert:
- I create nodes if they don’t exist

For search:
- I traverse and check full word exists

For prefix:
- I just check path exists

This gives O(L) time complexity for all operations.

-----------------------------------------------------
