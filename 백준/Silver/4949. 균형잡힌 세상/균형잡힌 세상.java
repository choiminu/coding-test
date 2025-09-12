import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean ok = true;

            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') { ok = false; break; }
                    stack.pop();
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') { ok = false; break; }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) ok = false;
            sb.append(ok ? "yes\n" : "no\n");
        }

        System.out.print(sb.toString());
    }
}
