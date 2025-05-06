import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int SIZE;
    static int[][] board;
    static boolean[][] isVisited;

    static int targetX;
    static int targetY;

    // 나이트가 이동할 수 있는 8가지 방향 (x, y)
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            SIZE = Integer.parseInt(br.readLine());

            board = new int[SIZE][SIZE];
            isVisited = new boolean[SIZE][SIZE];

            StringTokenizer token = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(token.nextToken());
            int startY = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(token.nextToken());
            targetY = Integer.parseInt(token.nextToken());

            bfs(startX, startY);

            System.out.println(board[targetY][targetX]);
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        isVisited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            if (cx == targetX && cy == targetY) return;

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE) {
                    if (!isVisited[ny][nx]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[ny][nx] = true;
                        board[ny][nx] = board[cy][cx] + 1;
                    }
                }
            }
        }
    }
}
