import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int d = 0; d <= 9; d++) {
                if (d > 0) dp[i][d] += dp[i - 1][d - 1];
                if (d < 9) dp[i][d] += dp[i - 1][d + 1];
                dp[i][d] = dp[i][d] % MOD;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % MOD;
        }

        System.out.println(answer);


        br.close();
    }

}