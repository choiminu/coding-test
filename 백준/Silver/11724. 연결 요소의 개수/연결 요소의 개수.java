import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static boolean[] visited;

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        visited = new boolean[N + 1];
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

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();

    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            Integer newNode = graph.get(node).get(i);
            if (!visited[newNode]) {
                visited[newNode] = true;
                dfs(newNode);
            }
        }

    }


}