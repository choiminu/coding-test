import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] lights;         // 불이 켜져있는지
    static boolean[][] visited;        // 방문했는지
    static List<int[]>[][] switchMap;  // 스위치 정보
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        lights = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        switchMap = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                switchMap[i][j] = new ArrayList<>();

        // 입력 받기
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            switchMap[y][x].add(new int[]{b, a});
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        lights[1][1] = true;
        visited[1][1] = true;
        queue.offer(new int[]{1, 1});
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];

            // 스위치를 켜기
            for (int[] next : switchMap[y][x]) {
                int ny = next[0];
                int nx = next[1];
                if (!lights[ny][nx]) {
                    lights[ny][nx] = true;
                    count++;

                    // 켠 방이 인접한 방문한 방이면 큐에 추가
                    for (int d = 0; d < 4; d++) {
                        int adjY = ny + dy[d];
                        int adjX = nx + dx[d];
                        if (isInBounds(adjX, adjY) && visited[adjY][adjX]) {
                            queue.offer(new int[]{ny, nx});
                            visited[ny][nx] = true;
                            break;
                        }
                    }
                }
            }

            // 인접한 불 켜진 방으로 이동
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (isInBounds(nx, ny) && lights[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

        return count;
    }

    static boolean isInBounds(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }
}
