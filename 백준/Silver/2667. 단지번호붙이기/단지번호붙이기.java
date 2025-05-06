import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {

    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        int total = 0;
        List<Integer> result = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1 && !isVisited[y][x]) {
                    result.add(bfs(x, y));
                    total++;
                }
            }
        }

        Collections.sort(result);
        System.out.println(total);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining("\n")));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        isVisited[y][x] = true;

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[ny][nx] == 1 && !isVisited[ny][nx]) {
                        queue.offer(new int[]{nx, ny});
                        isVisited[ny][nx] = true;
                        area++;
                    }
                }

            }
        }
        return area;
    }
}

