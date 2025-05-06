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

    static int X;
    static int Y;
    static int TEST_CASE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] paper;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());
        TEST_CASE = Integer.parseInt(token.nextToken());

        paper = new int[Y][X];
        isVisited = new boolean[Y][X];

        for (int i = 0; i < TEST_CASE; i++) {
            token = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(token.nextToken());
            int startY = Integer.parseInt(token.nextToken());

            int endX = Integer.parseInt(token.nextToken());
            int endY = Integer.parseInt(token.nextToken());

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    paper[y][x] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (paper[y][x] == 0 && !isVisited[y][x]) {
                    result.add(bfs(x, y));
                    count++;
                }
            }
        }

        Collections.sort(result);
        System.out.println(count);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));

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

                if (nx >= 0 && ny >= 0 && nx < X && ny < Y) {
                    if (paper[ny][nx] == 0 && !isVisited[ny][nx]) {
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

