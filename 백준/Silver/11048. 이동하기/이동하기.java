import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C;

    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[R + 1][C + 1];
        dp[0][0] = map[0][0];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dp[i][j] = map[i][j] + Math.max((i > 0 ? dp[i - 1][j] : 0),        // 위
                        Math.max(
                                (j > 0 ? dp[i][j - 1] : 0),    // 왼쪽
                                (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0) // 대각선
                        )
                );
            }
        }

        System.out.println(dp[R - 1][C - 1]);

        br.close();
    }


}
