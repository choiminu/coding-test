import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] picture;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        isVisited = new boolean[N][N];

        // 입력 읽기
        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().toCharArray();
        }

        // 정상인의 구역 개수
        int cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!isVisited[y][x]) {
                    cnt++;
                    bfs(x, y, false); // 정상인 기준 탐색
                }
            }
        }
        System.out.println(cnt);

        // 적록색약의 구역 개수
        isVisited = new boolean[N][N]; // 방문 배열 초기화
        cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!isVisited[y][x]) {
                    cnt++;
                    bfs(x, y, true); // 색약 기준 탐색
                }
            }
        }
        System.out.println(cnt);

        br.close();
        bw.flush();
        bw.close();
    }

    /**
     * BFS로 연결된 같은 구역 모두 방문 처리
     * @param x 시작 x좌표 (열)
     * @param y 시작 y좌표 (행)
     * @param isBlind 적록색약 모드(true면 R/G 동일하게 처리)
     */
    public static void bfs(int x, int y, boolean isBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[y][x] = true;

        char startColor = picture[y][x]; // 시작 칸의 색을 기준으로 연결 판단

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                // 이미 방문했으면 스킵
                if (isVisited[ny][nx]) {
                    continue;
                }

                // 연결 여부 판단
                if (!isBlind) {
                    // 정상인의 경우: 색이 정확히 같아야 연결
                    if (picture[ny][nx] != startColor) {
                        continue;
                    }
                } else {
                    // 적록색약인 경우:
                    // 시작색이 'B'이면 인접도 'B'여야 함
                    if (startColor == 'B') {
                        if (picture[ny][nx] != 'B') continue;
                    } else {
                        // 시작색이 R 또는 G이면 인접은 'B'가 아니면 연결(R/G 모두 허용)
                        if (picture[ny][nx] == 'B') continue;
                    }
                }

                // 연결 가능한 칸이면 방문 표시하고 큐에 추가
                isVisited[ny][nx] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
