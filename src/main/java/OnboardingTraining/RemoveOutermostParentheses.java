package OnboardingTraining;

import java.util.Stack;

/**
 * The number of "(" and ")" must be equal in a valid parentheses.
 * We use stack to find each primitive.
 */

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {

        StringBuffer result = new StringBuffer();
        Stack<String> stack = new Stack<>();

        int start = 0; // The start point of each valid parentheses string
        int end = 0;  //  The end point of each valid parentheses string

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push("(");
            } else {
                stack.pop();
                end = i;
            }

            if (stack.isEmpty()) {
                result.append(S.substring(start + 1, end));
                start = end + 1;
            }

        }

        return result.toString();

    }
}
