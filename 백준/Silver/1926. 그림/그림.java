import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[][] paper;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        paper = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !isVisited[i][j]) {
                    int area = bfs(i, j);
                    count++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < n && ny < m && nx >= 0 && ny >= 0) {
                    if (paper[nx][ny] == 1 && !isVisited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                        area++;
                    }
                }
            }
        }

        return area;
    }
}