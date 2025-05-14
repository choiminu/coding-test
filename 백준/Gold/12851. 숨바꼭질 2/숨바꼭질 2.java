import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int x;
    static int target;
    static Queue<Integer> queue = new LinkedList<>();

    static final int MAX = 100000;
    static final int[] time = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        x = Integer.parseInt(token.nextToken());
        target = Integer.parseInt(token.nextToken());

        String result = bfs();

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    public static String bfs() {
        queue.offer(x);
        time[x] = 0;

        int shortestDistance = -1;
        int caseCount = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == target) {

                if (shortestDistance == -1) {
                    shortestDistance = time[now];
                }

                if (time[now] == shortestDistance) {
                    caseCount++;
                }

            }

            int[] nextPositions = {now - 1, now + 1, now * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && (time[next] == 0 || time[next] == time[now] + 1)) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
        return shortestDistance + "\n" + caseCount;
    }
}

