import java.util.HashMap;
import java.util.Stack;

/*
#1 Balanced Parentheses
Write a function that takes in a string and returns true or false
depending on whether that string has balanced parentheses.
A string has balanced parentheses if every opening parenthesis
"(" has a matching closing parenthesis ")" that closes
the corresponding opening parenthesis.

For the purposes of this problem, you only need to worry about
parentheses “(“and “)”, not other opening-and-closing marks,
like curly brackets, square brackets, or angle brackets.

Similar problem: https://www.codewars.com/kata/52774a314c2333f0a7000688/

#2
Write a function that takes in a string and returns true or false
based on whether the string’s opening-and-closing marks
(that is, brackets) are balanced. Account for the following bracket types:
Parentheses: (  )
Curly Braces: { }
Square Brackets: [ ]
Angle Brackets: < >

The string doesn't need to have all four types of brackets,
but if an open bracket appears, the pair should also be closed correctly.
Assume you can use any libraries in Java needed.

Similar problem: https://leetcode.com/problems/valid-parentheses/

#3


 */
public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedParentheses("()"));
        System.out.println(balancedParentheses(")"));
        System.out.println(balancedParentheses("("));
        System.out.println(balancedParentheses("())"));
        System.out.println(balancedParentheses("32423(table)")); //true
        System.out.println(balancedParentheses("(java))2432")); //false

        System.out.println();
        System.out.println(balancedBrackets("()"));
        System.out.println(balancedBrackets(")"));
        System.out.println(balancedBrackets("("));
        System.out.println(balancedBrackets("())"));
        System.out.println(balancedBrackets("32423(table)")); //true
        System.out.println(balancedBrackets("(java))2432")); //false
        System.out.println();
        System.out.println(balancedBrackets("(}")); //false
        System.out.println(balancedBrackets("()[]{}")); //true
        System.out.println(balancedBrackets("<]")); //false
        System.out.println(balancedBrackets("{<()>[{{}}]()<>}")); //true
    }

    private static boolean balancedParentheses(String str) {
        int openCounter = 0;
        int closeCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openCounter++;
            } else if (str.charAt(i) == ')') {
                closeCounter++;
            }
            if (closeCounter > openCounter) {
                return false;
            }
        }
        return closeCounter - openCounter == 0;
    }

    private static boolean balancedBrackets(String str) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');
        hm.put('>', '<');

        Stack<Character> stack = new Stack<>();
        char ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (hm.containsValue(ch)) { //open
                stack.add(ch);
            } else if (hm.containsKey(ch)) { //close
                if (stack.isEmpty()) {
                    return false;
                } else if (hm.get(ch) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
