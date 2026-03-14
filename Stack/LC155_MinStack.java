/*
Problem: 155. Min Stack
-----------------------------------------------------

Problem Statement
Design a stack that supports push, pop, top, and retrieving the minimum
element in constant time.

Implement the MinStack class:

MinStack()      → initializes the stack
push(val)       → pushes element val onto the stack
pop()           → removes the element on top of the stack
top()           → gets the top element
getMin()        → retrieves the minimum element in the stack

All operations must run in O(1) time.

-----------------------------------------------------

Pattern Used & Why
Pattern: Stack + Auxiliary Stack

Why:
We maintain an additional stack (minStack) that keeps track of the
minimum value at each stage of the main stack.

This allows us to retrieve the minimum element in O(1) time.

-----------------------------------------------------

Key Idea

Two stacks are used:

1. mainStack → stores all elements
2. minStack  → stores minimum elements

Rules:
• When pushing a value:
  If minStack is empty OR val <= current minimum,
  push val into minStack.

• When popping:
  If popped value == minStack.peek(),
  pop from minStack also.

Thus the top of minStack always stores the minimum element.

-----------------------------------------------------

Algorithm / Process

push(val):
    push val into mainStack
    if minStack empty OR val <= minStack.peek()
        push val into minStack

pop():
    remove element from mainStack
    if removed element == minStack.peek()
        pop minStack

top():
    return mainStack.peek()

getMin():
    return minStack.peek()

-----------------------------------------------------

Code
*/

import java.util.*;

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    // constructor
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // push operation
    public void push(int val) {

        mainStack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // pop operation
    public void pop() {

        int removed = mainStack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // top operation
    public int top() {
        return mainStack.peek();
    }

    // get minimum operation
    public int getMin() {
        return minStack.peek();
    }
}

/*
-----------------------------------------------------

Time Complexity
push   → O(1)
pop    → O(1)
top    → O(1)
getMin → O(1)

-----------------------------------------------------

Space Complexity
O(n)

Two stacks are used to store elements.

-----------------------------------------------------

Example

Input
push(5)
push(3)
push(7)
getMin()

Stack
mainStack = [5,3,7]
minStack  = [5,3]

Output
3

-----------------------------------------------------

Explanation :

Use two stacks. One stack stores all elements while the other stores
the minimum values. Whenever a new minimum appears, push it into the
minStack. When removing elements, update minStack accordingly. This
ensures getMin() always returns the minimum in O(1) time.
*/
