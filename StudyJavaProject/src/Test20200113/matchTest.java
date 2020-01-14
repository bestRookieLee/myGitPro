package Test20200113;

import java.util.Stack;

public class matchTest {
    public static void main(String[] args) {
       boolean flag = isValid("{[()]}");
        System.out.println(flag);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] aArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++)
            if (aArray[i] == '(' || aArray[i] == '{' || aArray[i] == '[')
                stack.push(aArray[i]);
            else {

                if (stack.size() == 0)
                    return false;

                char c = stack.pop();
//                stack.pop();

                char match;
//                if (aArray[i] == ')') {
//                    match = '(';
//                } else if (aArray[i] == ']') {
//                    match = '[';
//                } else {
//                    match = '{';
//                }

                switch (aArray[i]){
                    case  ')':
                        match = '(';
                        break;
                    case ']':
                        match = '[';
                        break;
                    case '}':
                        match = '{';
                        break;
                    default:
                        match = '{';
                        break;
                }

                if (c != match) return false;
            }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }
}
