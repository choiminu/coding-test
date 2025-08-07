import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        boolean insideTag = false;

        for (char ch : input) {
            if (ch == '<') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                insideTag = true;
                bw.write(ch);
            } else if (ch == '>') {
                insideTag = false;
                bw.write(ch);
            } else if (insideTag) {
                bw.write(ch);
            } else {
                if (ch == ' ') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(' ');
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
