import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];

            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();

                if (input[i - 1] == '(') {
                    cnt += stack.size();
                } else {
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);

        br.close();
        bw.flush();
        bw.close();
    }

}
