import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] region;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        region = new int[N][N];

        int maxHeight = 0;

        for (int y = 0; y < N; y++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int h = Integer.parseInt(token.nextToken());
                region[y][x] = h;
                maxHeight = Math.max(maxHeight, h);
            }
        }

        int maxArea = 0;

        for (int h = 0; h <= maxHeight; h++) {
            isVisited = new boolean[N][N];
            int area = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!isVisited[y][x] && region[y][x] > h) {
                        bfs(x, y, h);
                        area++;
                    }
                }
            }

            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    private static void bfs(int x, int y, int height) {
        queue.offer(new int[]{x, y});
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!isVisited[ny][nx] && region[ny][nx] > height) {
                        isVisited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
