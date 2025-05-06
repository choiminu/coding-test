import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(token.nextToken()); // 총 층 수
        int S = Integer.parseInt(token.nextToken()); // 시작 층
        int G = Integer.parseInt(token.nextToken()); // 목표 층
        int U = Integer.parseInt(token.nextToken()); // 올라가는 층 수
        int D = Integer.parseInt(token.nextToken()); // 내려가는 층 수

        if (S == G) {
            System.out.println(0);
            return;
        }

        int[] count = new int[F + 1];
        boolean[] visited = new boolean[F + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int floor = queue.poll();

            for (int next : new int[]{floor + U, floor - D}) {
                if (next >= 1 && next <= F && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count[next] = count[floor] + 1;

                    if (next == G) {
                        System.out.println(count[next]);
                        return;
                    }
                }
            }
        }

        System.out.println("use the stairs");
    }
}
