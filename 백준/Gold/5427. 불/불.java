import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int COL;
    static int LOW;

    static char[][] map;
    static int[][] userTime;
    static int[][] fireTime;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            COL = Integer.parseInt(token.nextToken());
            LOW = Integer.parseInt(token.nextToken());

            map = new char[LOW][COL];
            userTime = new int[LOW][COL];
            fireTime = new int[LOW][COL];

            Queue<int[]> userQueue = new LinkedList<>();
            Queue<int[]> fireQueue = new LinkedList<>();

            for (int low = 0; low < LOW; low++) {
                char[] chars = br.readLine().toCharArray();
                for (int col = 0; col < COL; col++) {
                    map[low][col] = chars[col];
                    userTime[low][col] = -1;
                    fireTime[low][col] = -1;

                    if (chars[col] == '@') {
                        userQueue.offer(new int[] {col, low});
                        userTime[low][col] = 0;
                    }

                    if (chars[col] == '*') {
                        fireQueue.offer(new int[] {col, low});
                        fireTime[low][col] = 0;
                    }
                }
            }

            while (!fireQueue.isEmpty()) {
                int[] cur = fireQueue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < COL && ny < LOW) {
                        if (map[ny][nx] != '#' && fireTime[ny][nx] == -1) {
                            fireQueue.offer(new int[]{nx, ny});
                            fireTime[ny][nx] = fireTime[cy][cx] + 1;
                        }
                    }

                }
            }

            boolean isEscape = true;

            while (!userQueue.isEmpty()) {
                int[] cur = userQueue.poll();
                int cx = cur[0];
                int cy = cur[1];

                if (cx == 0 || cx == COL - 1 || cy == 0 || cy == LOW - 1) {
                    System.out.println(userTime[cy][cx] + 1);
                    isEscape = false;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < COL && ny < LOW) {
                        if (map[ny][nx] != '#' && userTime[ny][nx] == -1) {
                            if ((fireTime[ny][nx] == -1 || userTime[cy][cx] + 1 < fireTime[ny][nx])) {
                                userQueue.offer(new int[]{nx, ny});
                                userTime[ny][nx] = userTime[cy][cx] + 1;
                            }
                        }
                    }
                }

            }

            if (isEscape) {
                System.out.println("IMPOSSIBLE");
            }

        }
    }




}