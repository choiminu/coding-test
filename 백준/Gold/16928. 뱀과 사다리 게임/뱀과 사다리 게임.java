import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[] map = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        for (int i = 0; i < N + M; i++) {
            token = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());

            map[u] = v;
        }

        int result = bfs();

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int cnt = cur[1];

            if (now == 100) {
                return cnt;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) {
                    continue;
                }

                if (map[next] == 0 && !visited[next]) {
                    queue.offer(new int[]{next, cnt + 1});
                    visited[next] = true;
                }

                if (map[next] != 0 && !visited[next] && !visited[map[next]]) {
                    queue.offer(new int[]{map[next], cnt + 1});
                    visited[next] = true;
                    visited[map[next]] = true;
                }
            }
        }
        return -1;
    }

}