import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static final int MAX = 100000;

    static boolean[] visited;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        visited = new boolean[MAX + 1];
        graph = new int[MAX + 1];

        int bfs = bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(graph[index]);
            index = graph[index];
        }

        bw.write(bfs + "\n");

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 1});
        visited[N] = true;
        graph[N] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int current = cur[0];
            int time = cur[1];

            if (current == K) {
                return time - 1;
            }

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next < 0 || next > MAX ||visited[next]) {
                    continue;
                }
                queue.offer(new int[]{next, time + 1});
                visited[next] = true;
                graph[next] = current;

            }
        }
        return -1;
    }


}
