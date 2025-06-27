import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Queue<long[]> queue = new LinkedList<>();
    static Set<Long> isVisited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int result = bfs();
        System.out.println(result);
        br.close();
    }

    public static int bfs() {
        queue.offer(new long[]{N, 1});
        isVisited.add((long) N);

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            long num = cur[0];
            int cnt = (int) cur[1];

            if (num == M) {
                return cnt;
            }

            long next1 = num * 2;
            long next2 = num * 10 + 1;

            if (next1 <= M && !isVisited.contains(next1)) {
                queue.offer(new long[]{next1, cnt + 1});
                isVisited.add(next1);
            }

            if (next2 <= M && !isVisited.contains(next2)) {
                queue.offer(new long[]{next2, cnt + 1});
                isVisited.add(next2);
            }
        }

        return -1;
    }
}
