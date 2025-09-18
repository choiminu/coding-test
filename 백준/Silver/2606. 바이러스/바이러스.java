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

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N + 1];

        int S = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < S; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(bfs(1));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : graph.get(cur)) {
                if (isVisited[next]) continue;
                isVisited[next] = true;
                queue.offer(next);
                cnt++;
            }
        }

        return cnt;
    }


}

