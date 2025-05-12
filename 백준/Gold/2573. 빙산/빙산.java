import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int row;
    static int col;

    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());

        map = new int[row][col];

        for (int y = 0; y < row; y++) {
            token = new StringTokenizer(br.readLine());
            for (int x = 0; x < col; x++) {
                map[y][x] = Integer.parseInt(token.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int count = countIcebergs();

            if (count >= 2) {
                System.out.println(year);
                break;
            }

            if (count == 0) {
                System.out.println(0);
                break;
            }

            melt();
            year++;
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void melt() {
        int[][] meltAmount = new int[row][col];

        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (map[y][x] > 0) {
                    int sea = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < col && ny < row) {
                            if (map[ny][nx] == 0) sea++;
                        }
                    }
                    meltAmount[y][x] = sea;
                }
            }
        }

        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                map[y][x] = Math.max(0, map[y][x] - meltAmount[y][x]);
            }
        }
    }


    public static int countIcebergs() {
        isVisited = new boolean[row][col];
        int count = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (map[y][x] > 0 && !isVisited[y][x]) {
                    bfs(x,y);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < col && ny < row) {
                    if (map[ny][nx] > 0 && !isVisited[ny][nx]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[ny][nx] = true;
                    }
                }
            }
        }
    }
}

