import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 층 수
        S = Integer.parseInt(st.nextToken()); // 시작 층
        G = Integer.parseInt(st.nextToken()); // 목표 층
        U = Integer.parseInt(st.nextToken()); // 위로 이동
        D = Integer.parseInt(st.nextToken()); // 아래로 이동

        isVisited = new boolean[F + 1];

        int result = bfs();

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{S, 0});
        isVisited[S] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int height = cur[0];
            int cnt = cur[1];

            if (height == G) {
                return cnt;
            }

            for (int next : new int[]{height + U, height - D}) {
                if (next < 1 || next > F || isVisited[next]) continue;

                isVisited[next] = true;
                queue.offer(new int[]{next, cnt + 1});
            }
        }

        return -1;
    }
}
