import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;


public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "civic";

        PalindromeStrategy strategy = new StackStrategy();


        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.executeStrategy(input);

        System.out.println("Input : " + input);
        System.out.println("Strategy Used : " + strategy.getClass().getSimpleName());
        System.out.println("Is Palindrome? : " + result);
    }
}


interface PalindromeStrategy {
    boolean check(String input);
}


class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}


class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.check(input);
    }
}