import java.io.*;
import java.util.Arrays;

public class Main {

    final static int MOD = 10_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            int suffix = 0; 
            for (int j = 9; j >= 0; j--) {
                suffix = (suffix + dp[i - 1][j]) % MOD;
                dp[i][j] = suffix;
            }
        }

        int ans = 0;
        for (int v : dp[N]) ans = (ans + v) % MOD;
        System.out.println(ans);

        br.close();
    }
}
