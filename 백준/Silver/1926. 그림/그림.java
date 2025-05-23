import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
        isVisited = new boolean[row][col];

        for (int y = 0; y < row; y++) {
            token = new StringTokenizer(br.readLine());
            for (int x = 0; x < col; x++) {
                map[y][x] = Integer.parseInt(token.nextToken());
            }
        }

        int max = 0;
        int total = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (map[y][x] == 1 && !isVisited[y][x]) {
                    int count = dfs(x, y);
                    max = Math.max(max, count);
                    total++;
                }
            }
        }

        bw.write(total + "\n" + max);

        br.close();
        bw.flush();
        bw.close();
    }

    static public int dfs(int x, int y) {
        isVisited[y][x] = true;
        int cnt = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= col || ny >= row) {
                continue;
            }
            if (map[ny][nx] == 0 || isVisited[ny][nx]) {
                continue;
            }

            isVisited[ny][nx] = true;
            cnt += dfs(nx, ny);
        }

        return cnt;
    }
}

