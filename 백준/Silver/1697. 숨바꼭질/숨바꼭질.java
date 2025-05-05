import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N,M;
    static int[] time;
    static Queue<Integer> queue = new LinkedList<>();
    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        time = new int[MAX];
        queue.offer(N);
        bfs();

    }


    public static void bfs() {
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (now == M) {
                System.out.println(time[now]);
                break;
            }

            int[] nextPositions = {now - 1, now + 1, now * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next < MAX && time[next] == 0) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                }
            }

        }
    }

}