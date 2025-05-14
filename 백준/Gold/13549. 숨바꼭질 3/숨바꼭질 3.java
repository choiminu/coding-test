import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int K;

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        System.out.println(bfs());

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Deque<int[]> deque = new LinkedList<>();
        boolean[] isVisited = new boolean[MAX + 1];

        deque.offer(new int[]{N, 0});
        isVisited[N] = true;

        int result = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int now = cur[0];
            int time = cur[1];

            if (now == K) {
                result = time;
                break;
            }

            int[] nextPositions = {now * 2, now - 1, now + 1};

            for (int i = 0; i < nextPositions.length; i++) {
                int next = nextPositions[i];

                if (next >= 0 && next <= MAX && !isVisited[next]) {
                    isVisited[next] = true;
                    if (i == 0) {
                        deque.offerFirst(new int[]{next, time});
                    } else {
                        deque.offerLast(new int[]{next, time + 1});
                    }
                }
            }

        }
        return result;
    }
}

