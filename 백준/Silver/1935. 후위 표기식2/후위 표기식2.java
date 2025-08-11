import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (char ch : input.toCharArray()) {

            if (ch == '*') {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y * x);
            } else if (ch == '+') {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y + x);
            } else if (ch == '/') {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y / x);
            } else if (ch == '-') {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y - x);
            } else {
                stack.push(Double.parseDouble(String.valueOf(nums[ch - 'A'])));
            }
        }

        System.out.printf("%.2f", stack.pop());


        br.close();
        bw.flush();
        bw.close();
    }

}


