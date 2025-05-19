import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(dfsResult.toString().trim());

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(bfsResult.toString().trim());
    }

    static void dfs(int node) {
        visited[node] = true;
        dfsResult.append(node).append(" ");

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.append(node).append(" ");

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
