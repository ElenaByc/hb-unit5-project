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


 */
public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedParentheses("()"));
        System.out.println(balancedParentheses(")"));
        System.out.println(balancedParentheses("("));
        System.out.println(balancedParentheses("())"));
        System.out.println(balancedParentheses("32423(table)")); //true
        System.out.println(balancedParentheses("(java))2432")); //false
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
}
