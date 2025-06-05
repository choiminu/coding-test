import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int row;
    static int col;

    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};

    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());
        map = new int[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, bfs(j, i));
            }
        }

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited = new boolean[row][col];
        queue.offer(new int[] {x, y, 0});
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (map[cy][cx] == 1) {
                return dist;
            }

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if (isVisited[ny][nx]) continue;

                queue.offer(new int[] {nx, ny, dist + 1});
                isVisited[ny][nx] = true;
            }
        }

        return -1;

    }
}
