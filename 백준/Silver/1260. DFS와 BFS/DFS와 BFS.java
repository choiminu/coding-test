import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static StringBuilder bfs = new StringBuilder();
    static StringBuilder dfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        isVisited = new boolean[N + 1];
        dfs(V);

        isVisited = new boolean[N + 1];
        bfs(V);

        System.out.println(dfs.toString());
        System.out.println(bfs.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.append(node).append(" ");

            for (int next : graph.get(node)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void dfs(int node) {
        isVisited[node] = true;
        dfs.append(node).append(" ");

        for (int next : graph.get(node)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                dfs(next);
            }
        }
    }


}

