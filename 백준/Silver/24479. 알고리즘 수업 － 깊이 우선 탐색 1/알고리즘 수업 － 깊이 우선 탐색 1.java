import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());

        visited = new int[N + 1];

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

        cnt = 1;
        dfs(R);

        for (int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int r) {
        visited[r] = cnt;

        for (int i = 0; i < graph.get(r).size(); i++) {
            int node = graph.get(r).get(i);
            if (visited[node] == 0) {
                cnt++;
                dfs(node);
            }
        }
    }

}