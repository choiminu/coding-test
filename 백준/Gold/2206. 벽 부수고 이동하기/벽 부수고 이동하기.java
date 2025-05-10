import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int row;
    static int col;

    static int[][] map;
    static boolean[][][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());

        map = new int[row][col];
        isVisited = new boolean[row][col][2];

        for (int y = 0; y < row; y++) {
            char[] chars = br.readLine().toCharArray();
            for (int x = 0; x < col; x++) {
                map[y][x] = chars[x] - '0';
            }
        }

        int result = bfs();

        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1}); // x, y, broken, distance
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int broken = cur[2];
            int dis = cur[3];

            if (cx == col - 1 && cy == row - 1) {
                return dis;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < col && ny < row) {

                    if (map[ny][nx] == 0 && !isVisited[ny][nx][broken]) {
                        isVisited[ny][nx][broken] = true;
                        queue.offer(new int[]{nx, ny, broken, dis + 1});
                    }

                    if (map[ny][nx] == 1 && broken == 0 && !isVisited[ny][nx][1]) {
                        isVisited[ny][nx][1] = true;
                        queue.offer(new int[]{nx, ny, 1, dis + 1});
                    }

                }
            }
        }
        return -1;
    }

}

