import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.plaf.IconUIResource;

class Main {

    static int N;

    static char[][] picture;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        picture = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                picture[i][j] = input[j];
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                char color = picture[i][j];

                if (picture[i][j] == 'R' && !isVisited[i][j]) {
                    bfs(i, j, color);
                    count++;
                }

                if (picture[i][j] == 'G' && !isVisited[i][j]) {
                    bfs(i, j, color);
                    count++;
                }

                if (picture[i][j] == 'B' && !isVisited[i][j]) {
                    bfs(i, j, color);
                    count++;
                }
            }
        }

        System.out.print(count + " ");


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'R' || picture[i][j] == 'G') {
                    picture[i][j] = 'R';
                }
            }
        }

        isVisited = new boolean[N][N];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                char color = picture[i][j];

                if (picture[i][j] == 'R' && !isVisited[i][j]) {
                    bfs(i, j, color);
                    cnt++;
                }


                if (picture[i][j] == 'B' && !isVisited[i][j]) {
                    bfs(i, j, color);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);




    }

    private static void bfs(int x, int y, char color) {

        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {

                    if (picture[nx][ny] == color && !isVisited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                    }

                }
            }
        }
    }


}