import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int idx = 1;

        while (T --> 0) {
            int target = Integer.parseInt(br.readLine());


            while (idx <= target) {
                stack.push(idx++);
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb = new StringBuilder();
                sb.append("NO\n");
                break;
            }
        }

        br.close();
        System.out.println(sb.toString());
    }

}
