import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static int[] dy = {-2, -2, 0, 0, 2, 2};

    static int[][] board;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        board = new int[N][N];
        isVisited = new boolean[N][N];

        token = new StringTokenizer(br.readLine());
        int chessY = Integer.parseInt(token.nextToken());
        int chessX = Integer.parseInt(token.nextToken());
        int targetY = Integer.parseInt(token.nextToken());
        int targetX = Integer.parseInt(token.nextToken());

        int result = bfs(chessX, chessY, targetX, targetY);

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(int chessX, int chessY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{chessX, chessY, 0});
        isVisited[chessY][chessX] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if (cx == targetX && cy == targetY) {
                return cnt;
            }

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (isVisited[ny][nx]) {
                    continue;
                }

                queue.offer(new int[]{nx, ny, cnt + 1});
                isVisited[ny][nx] = true;
            }
        }

        return -1;

    }


}
