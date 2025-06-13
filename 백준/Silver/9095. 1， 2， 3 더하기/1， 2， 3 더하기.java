import java.io.*;

public class Main {

    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 10; i++) {
            recur(i);
        }

        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

    }

    public static int recur(int n) {
        if (n == 1) return dp[n] = 1;
        if (n == 2) return dp[n] = 2;
        if (n == 3) return dp[n] = 4;

        if (dp[n] != 0) return dp[n];
        return dp[n] = recur(n - 1) + recur(n - 2) + recur(n - 3);
    }
}
