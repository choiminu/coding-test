import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        Queue<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            result.offer(queue.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N; i++) {
            if (i + 1 != N) {
                sb.append(result.poll()).append(", ");
            } else {
                sb.append(result.poll()).append(">");
            }
        }

        System.out.println(sb);


        br.close();
        bw.flush();
        bw.close();
    }

}

