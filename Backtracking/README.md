#  Backtracking Pattern

-----------------------------------------------------

##  What is Backtracking?

Backtracking is a technique where we:
- Try all possibilities
- Undo the choice (backtrack)
- Explore next option

-----------------------------------------------------

##  Core Idea

Include -> Backtrack (Undo) -> Exclude

-----------------------------------------------------

##  Pattern

for (choices) {

    choose
  
    undo (backtrack)

    exclude (recursion)
}

-----------------------------------------------------

##  Key Difference

Recursion → just calls itself  
Backtracking → recursion + undo step

-----------------------------------------------------

##  Example Structure

void func(...) {

    if (base case) {
        add answer
        return;
    }

    for (choice) {

        // choose
        add

        // backtrack (undo)
        remove

        // explore
        func(...)
    }
}

-----------------------------------------------------

##  Time Complexity

Usually exponential:
O(2^n), O(n!), etc.

-----------------------------------------------------

##  Short Interview Explanation

Backtracking tries all possibilities using recursion and removes the choice after exploring each path.

-----------------------------------------------------

##  Memory Line

Backtracking = Recursion + Undo

-----------------------------------------------------
