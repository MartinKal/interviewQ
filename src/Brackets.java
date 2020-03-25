import java.util.Arrays;
import java.util.Stack;

public class Brackets {
    public static String bracket(String input) {
        Stack<Character> stackBrackets = new Stack<Character>();
        Stack<Integer> stackBracketPos = new Stack<Integer>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(') {
                stackBrackets.push(current);
                stackBracketPos.push(i);
            }
            else if (current == ')') {
                char top;
                if (stackBrackets.size() > 0) {
                    top = stackBrackets.peek();
                    if (top == '(') {
                        stackBrackets.pop();
                        stackBracketPos.pop();
                    } else {
                        stackBrackets.push(current);
                        stackBracketPos.push(i);
                    }
                }
                else {
                    stackBrackets.push(current);
                    stackBracketPos.push(i);
                }
            }
        }

        if (stackBracketPos.size() == 0)
            return input;

        char[] outputString = new char[input.length() - stackBracketPos.size()];
        int j = outputString.length - 1;

        for (int i = input.length() - 1; i >= 0; i--) {
            if (stackBracketPos.size() > 0) {
                int top = stackBracketPos.peek();
                if (top != i) {
                    outputString[j--] = input.charAt(i);
                } else {
                    stackBracketPos.pop();
                }
            }
            else
                outputString[j--] = input.charAt(i);
        }

        return new String(outputString);
    }

    public static void main(String[] args) {
        String input = "(12((34)(56))))";
        System.out.println(bracket(input));
        input = "))((123((";
        System.out.println(bracket(input));
        input = "23";
        System.out.println(bracket(input));
    }
}
