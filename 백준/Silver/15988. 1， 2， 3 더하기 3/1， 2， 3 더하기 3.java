import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int mod = 1_000_000_009;

        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i-1]) % mod;
        }

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n] % mod);
        }

        br.close();
    }

}
