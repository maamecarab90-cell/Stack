import java.util.Stack;

public class StackExercises {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("JavaScript");
        stack.push("Go");

        System.out.println("Top element (Peek): " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Remaining stack: " + stack);

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("\n--- String Reversal ---");
        String original = "Hello World";

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < original.length(); i++) {
            charStack.push(original.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversed.append(charStack.pop());
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed.toString());

        System.out.println("\n--- Balanced Brackets ---");
        String balanced = "({[()]})";
        String unbalanced = "({[})";

        System.out.println("String 1 (" + balanced + ") is balanced: " + isBalanced(balanced));
        System.out.println("String 2 (" + unbalanced + ") is balanced: " + isBalanced(unbalanced));
    }

    public static boolean isBalanced(String str) {
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                bracketStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (bracketStack.isEmpty()) {
                    return false;
                }
                char top = bracketStack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return bracketStack.isEmpty();
    }
}