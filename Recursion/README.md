#  Recursion Pattern

-----------------------------------------------------

##  What is Recursion?

Recursion is a technique where a function calls itself to solve a smaller subproblem.

-----------------------------------------------------

##  Core Idea

Break problem into smaller parts until base case is reached.

-----------------------------------------------------

## 📌 Basic Structure

void func() {

    // base case (stop condition)

    // work

    func(); // recursive call
}

-----------------------------------------------------

##  MOST IMPORTANT

Base case is mandatory → otherwise infinite recursion.

-----------------------------------------------------

##  Key Components

1. Base Case → stopping condition  
2. Recursive Call → function calls itself  
3. Work → processing at each step  

-----------------------------------------------------

##  Example

void print(int n) {
    if (n == 0) return;

    System.out.println(n);
    print(n - 1);
}

-----------------------------------------------------

##  Call Stack Concept

Each recursive call is stored in stack memory.

Flow:
func(3) → func(2) → func(1) → func(0) → return

-----------------------------------------------------

##  Time Complexity

Depends on number of recursive calls.

Example:
- Linear → O(n)
- Binary → O(2^n)

-----------------------------------------------------

##  Short Interview Explanation

Recursion solves problems by breaking them into smaller subproblems until a base case is reached.

-----------------------------------------------------

##  Memory Line

Recursion = Function calling itself + Base Case

-----------------------------------------------------
