import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 1 자리 -> 0개
        // 2 자리 -> [10]: 1개
        // 3 자리 -> [100] [101] : 2개
        // 4 자리 -> [1000, [1001], [101] 3개
        // 5 자리 -> [10000], [10001], [10010], [10100], [10101], 5개
        // dp[i] = dp[i - 1] + dp[i - 2]

        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5;

        for (int i = 6; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);

        br.close();
        bw.flush();
        bw.close();
    }
}

