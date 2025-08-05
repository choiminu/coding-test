import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> left = new LinkedList<>();
        LinkedList<Character> right = new LinkedList<>();

        char[] arr = br.readLine().toCharArray();
        for (char ch : arr) {
            left.add(ch);
        }

        int N = Integer.parseInt(br.readLine());

        int index = left.size();

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            char command = token.nextToken().charAt(0);
            char input = token.hasMoreTokens() ? token.nextToken().charAt(0) : '?';

            switch (command) {
                case 'P':
                    left.add(input);
                    break;
                case 'L':
                    if (left.size() - 1 >= 0) {
                        right.addFirst(left.removeLast());
                    }
                    break;
                case 'D':
                    if (right.size() - 1 >= 0) {
                        left.addLast(right.remove());
                    }
                    break;
                case 'B':
                    if (left.size() - 1 >= 0) {
                        left.removeLast();
                    }
                    break;
            }
        }

        for (char ch : left) {
            bw.write(ch);
        }

        for (char ch : right) {
            bw.write(ch);
        }

        bw.close();
        br.close();
    }


}
