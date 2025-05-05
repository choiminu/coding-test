import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.plaf.IconUIResource;

class Main {

    static int low;
    static int col;
    static int kimchi;

    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {

            StringTokenizer token = new StringTokenizer(br.readLine());

            col = Integer.parseInt(token.nextToken());
            low = Integer.parseInt(token.nextToken());
            kimchi = Integer.parseInt(token.nextToken());

            map = new int[low][col];
            isVisited = new boolean[low][col];

            for (int j = 0; j < kimchi; j++) {
                token = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());

                map[y][x] = 1;
            }


            int count = 0;
            for (int j = 0; j < low; j++) {
                for (int k = 0; k < col; k++) {
                    if (map[j][k] == 1 && !isVisited[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static void bfs(int x, int y) {

        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < low && ny < col) {
                    if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
    }


}