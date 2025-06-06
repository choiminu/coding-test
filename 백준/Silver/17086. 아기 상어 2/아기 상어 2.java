import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int row;
    static int col;

    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        row = Integer.parseInt(token.nextToken());
        col = Integer.parseInt(token.nextToken());
        map = new int[row][col];

        for (int y = 0; y < row; y++){
            token = new StringTokenizer(br.readLine());
            for (int x = 0; x < col; x++) {
                map[y][x] = Integer.parseInt(token.nextToken());

                if (map[y][x] == 1) {
                    queue.offer(new int[] {x, y, 1});
                }
            }
        }

        bfs();

        int max = 0;

        for (int[] ints : map) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if (map[ny][nx] != 0) continue;

                queue.offer(new int[]{nx, ny, dist + 1});
                map[ny][nx] = dist;
            }

        }
    }
}
