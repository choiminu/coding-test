import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Function<String, String> isVPS = str -> {
            Stack<Character> stack = new Stack<>();

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {

                    if (stack.isEmpty()) {
                        return "NO\n";
                    }

                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty() ? "YES\n" : "NO\n";
        };

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N --> 0) {
            String input = br.readLine();
            sb.append(isVPS.apply(input));
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

