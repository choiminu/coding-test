import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int next = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (!stack.isEmpty() && stack.peek() > num) {
                sb = new StringBuilder("NO");
                break;
            }

            while (next <= num) {
                stack.push(next++);
                sb.append("+").append("\n");
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

