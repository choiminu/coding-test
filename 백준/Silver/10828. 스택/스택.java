import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push" :
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    bw.write(stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty" :
                    bw.write(stack.isEmpty() + "\n");
                    break;
                case "top" :
                    bw.write(stack.top() + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Stack {
        int[] arr = new int[10000];
        int top = 0;

        public void push(int data) {
            arr[top++] = data;
        }

        public int pop() {
            if (isEmpty() == 1) {
                return  -1;
            }
            return arr[--top];
        }

        public int size() {
            return top;
        }

        public int isEmpty() {
            return top == 0 ? 1 : 0;
        }

        public int top() {
            if (isEmpty() == 1) {
                return  -1;
            }
            return arr[top - 1];
        }

    }

}
