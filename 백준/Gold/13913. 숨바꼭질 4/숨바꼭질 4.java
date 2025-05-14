import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int K;

    static final int MAX = 100000;
    static int[] time = new int[MAX + 1];
    static int[] parent = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        bw.write(time[K] + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }


        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (now == K) {
                break;
            }

            int[] nextPositions = {now - 1, now + 1, now * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && time[next] == 0) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}

