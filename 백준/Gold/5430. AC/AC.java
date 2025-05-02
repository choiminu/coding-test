import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            Deque<Integer> deque = new ArrayDeque<>();

            char[] instructions = br.readLine().toCharArray();

            int size = Integer.parseInt(br.readLine());

            String[] nums = br.readLine().replace("[", "").replace("]", "").trim().split(",");

            for (int j = 0; j < size; j++) {
                deque.add(Integer.parseInt(nums[j]));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char ch : instructions) {

                if (ch == 'R') {
                    isReversed = !isReversed;
                }

                if (ch == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.removeLast();
                        } else {
                            deque.remove();
                        }
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
            } else {
                bw.write("[");
                if (!deque.isEmpty()) {
                    if (isReversed) {
                        bw.write(String.valueOf(deque.removeLast()));
                        while (!deque.isEmpty()) {
                            bw.write("," + deque.removeLast());
                        }
                    } else {
                        bw.write(String.valueOf(deque.remove()));
                        while (!deque.isEmpty()) {
                            bw.write("," + deque.remove());
                        }
                    }
                }
                bw.write("]\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
