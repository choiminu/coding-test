import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[MAX + 1][2]; // 시간 % 2 로 홀짝 관리
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N][0] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sister = K + time * (time + 1) / 2;

            if (sister > MAX) {
                System.out.println(-1);
                return;
            }

            if (visited[sister][time % 2]) {
                System.out.println(time);
                return;
            }

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int now = cur[0];
                int t = cur[1];
                int nextT = t + 1;
                int parity = nextT % 2;

                int[] moves = {now - 1, now + 1, now * 2};
                for (int next : moves) {
                    if (next >= 0 && next <= MAX && !visited[next][parity]) {
                        visited[next][parity] = true;
                        queue.offer(new int[]{next, nextT});
                    }
                }
            }

            time++;
        }

        System.out.println(-1);
    }
}
