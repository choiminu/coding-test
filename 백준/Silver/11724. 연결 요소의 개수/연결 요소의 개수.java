import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());

        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        isVisited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 연결 요소의 개수
        int count = 0;

        // 그래프 탐색
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int node) {
        isVisited[node] = true;
        for (int next : graph.get(node)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                dfs(next);
            }
        }
    }
}
