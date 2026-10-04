import java.util.*;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                openStack.push(i);
            }
            else if (s.charAt(i) == '*') {
                starStack.push(i);
            }
            else {
                // First try to match ')' with '('
                if (!openStack.isEmpty()) {
                    openStack.pop();
                }
                // Otherwise use '*' as '('
                else if (!starStack.isEmpty()) {
                    starStack.pop();
                }
                else {
                    return false;
                }
            }
        }

        // Use '*' as ')' to match remaining '('
        while (!openStack.isEmpty() && !starStack.isEmpty()) {

            if (openStack.peek() < starStack.peek()) {
                openStack.pop();
                starStack.pop();
            }
            else {
                return false;
            }
        }

        return openStack.isEmpty();
    }
}