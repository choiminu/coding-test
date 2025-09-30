import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;

    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(bfs());
        
        br.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int dist = cur[1];

            if (cx == end) {
                return dist;
            }

            for (int next : graph.get(cx)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(new int[] {next, dist + 1});
                }
            }
        }

        return -1;
    }
}
