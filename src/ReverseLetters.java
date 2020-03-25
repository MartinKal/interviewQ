import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ReverseLetters {
    public static String reverseOnlyLetters(String S) {
        Stack<Character> stackSubStrings = new Stack<Character>();

        char[] output = new char[S.length()];
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (isLetter(curr)) {
                stackSubStrings.push(curr);
            } else {
                while(!stackSubStrings.empty()) {
                    output[j++] = stackSubStrings.pop();
                }
                output[j++] = curr;
            }
        }

        while(!stackSubStrings.empty()) {
            output[j++] = stackSubStrings.pop();
        }

        return new String(output);
    }

    public static String reverseOnlyLetters2(String S) {
        char[] output = new char[S.length()];
        int start = 0;
        int end = S.length() - 1;
        for (; start <= end;) {
            char front = S.charAt(start);
            char back = S.charAt(end);
            if (isLetter(front) && isLetter(back)) {
                output[start++] = back;
                output[end--] = front;
            } else {
                if (!isLetter(front))
                    output[start++] = front;
                if (!isLetter(back))
                    output[end--] = back;
            }
        }
        return new String(output);
    }

    private static boolean isLetter(char c) {
        if (c  >= 'a' && c <='z')
            return true;
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    @Test
    void Test1() {
        String in = "ab-cd-";
        String rev = reverseOnlyLetters(in);
        Assertions.assertEquals("ba-dc-", rev);

    }

    @Test
    void Test2() {
        String in = "abc-de-";
        String rev = "edc-ba-";
        Assertions.assertEquals(rev, reverseOnlyLetters2(in));
    }
}
