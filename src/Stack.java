import java.util.EmptyStackException;

/*
#3
For Step 2(BalancedBrackets), you could have used a Stack to implement the solution.
How would you implement a stack if you could not use any of the built-in Java libraries?
Stack.java

*/
public class Stack {
    private Character[] stack;
    private int top;

    public Stack(int capacity) {
        stack = new Character[capacity];
    }

    public void push(Character s) {
        if (top == stack.length) {
            // need to resize the backing array
            Character[] newArray = new Character[2 * stack.length];
            // copy from stack to newArray
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = s;
    }

    public Character pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Character s = stack[--top];
        stack[top] = null;
        return s;
    }

    public Character peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
