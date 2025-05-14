import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        boolean[] isVisited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int loc = cur[0];
            int dist = cur[1];

            if (loc == end) {
                bw.write(dist+"");
                break;
            }

            int[] nextPositions = {loc - 1, loc + 1, loc * 2};
            for (int nextPosition : nextPositions) {
                if (nextPosition >= 0 && nextPosition <= 100000 && !isVisited[nextPosition]) {
                    queue.offer(new int[] {nextPosition, dist + 1});
                    isVisited[nextPosition] = true;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

