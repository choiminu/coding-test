import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] inputs = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;


        for (int i = 4; i <= max; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        for (int i : inputs) {
            System.out.println(dp[i]);
        }



        br.close();
    }

}

