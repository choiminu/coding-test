import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        while (tc --> 0) {
            int max = 0;
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N];
            int[][] dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if (N > 1) {
                dp[0][1] = dp[1][0] + stickers[0][1];
                dp[1][1] = dp[0][0] + stickers[1][1];
            }

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
            }

            bw.write(Math.max(dp[0][N - 1], dp[1][N - 1]) + "\n");

        }

        br.close();
        bw.flush();
        bw.close();
    }

}

