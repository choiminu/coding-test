import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 현재 위치
        N = Integer.parseInt(st.nextToken());

        // 동생의 현재 위치
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        // 방문 가능한 위치는 동생의 현재 위치에서 + 1 더한 값이다.
        isVisited = new boolean[100001];

        int bfs = bfs(N);

        System.out.println(bfs);

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0}); // X 좌표와 이동한 시간 저장
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int time = cur[1];

            if (cx == K) {
                return time;
            }

            int[] nextPosition = {cx - 1, cx + 1, cx * 2};
            for (int nx : nextPosition) {
                if (nx < 0 || nx > 100000 || isVisited[nx]) {
                    continue;
                }
                isVisited[nx] = true;
                queue.offer(new int[]{nx, time + 1});
            }
        }
        return -1;
    }


}

