import java.io.*;

public class Main {

    static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;
        if (N >= 2) dp[2] = 2;

        /**
         * N=1 (1)
         * N=2 (11, 00)
         * N=3 (111, 100, 001)
         * N=4 (1111, 0000, 1001, 1100, 0011)
         * 길이가 i인 타일 수열의 수 = {
         *  길이 i-1 수열 뒤에 1 붙이기
         *  길이가 i-2 수열 뒤에 00 붙이기
         *  }
         */

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        System.out.println(dp[N]);

        br.close();
        bw.flush();
        bw.close();
    }

}
