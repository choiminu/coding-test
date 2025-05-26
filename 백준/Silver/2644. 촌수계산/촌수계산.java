import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int T,K;

    static int result = -1;

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer token = new StringTokenizer(br.readLine());
        T = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        isVisited = new boolean[N + 1];
        dfs(T, 0);

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int node, int depth) {
        isVisited[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            int nextNode = graph.get(node).get(i);
            if (!isVisited[nextNode]) {
                if (nextNode == K) {
                    result = depth + 1;
                    break;
                }
                dfs(nextNode, depth + 1);
            }
        }

    }
}