import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static List<List<Integer>> parent = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        isVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i <= N; i++) {
            parent.add(new ArrayList<>());
        }


        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }


        dfs(1);

        for (int i = 2; i < parent.size(); i++) {
            System.out.println(parent.get(i).get(0));
        }

        br.close();
    }

    public static void dfs(int node) {
        isVisited[node] = true;
        for (int next : list.get(node)) {
            if (!isVisited[next]) {
                parent.get(next).add(node);
                dfs(next);
            }
        }
    }

}
