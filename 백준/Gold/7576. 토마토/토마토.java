import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int col, low;
    static int[][] box;
    static boolean[][] isVisited;

    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        col = Integer.parseInt(token.nextToken());
        low = Integer.parseInt(token.nextToken());

        box = new int[low][col];
        isVisited = new boolean[low][col];

        for (int i = 0; i < low; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                box[i][j] = Integer.parseInt(token.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i ,j});
                }
            }
        }

        bfs();

        boolean flag = false;
        int max = 0;

        for (int[] x : box) {

            if (flag){
                break;
            }

            for (int y : x) {
                if (y == 0) {
                    flag = true;
                    break;
                }

                if (max < y) {
                    max = y;
                }
            }
        }

        System.out.println(flag ? -1 : max - 1);

    }

    private static int bfs() {

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < low && ny < col) {
                    if (box[nx][ny] == 0 && !isVisited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                        box[nx][ny] = box[cx][cy] + 1;
                    }
                }
            }
        }
        return 1;
    }
}