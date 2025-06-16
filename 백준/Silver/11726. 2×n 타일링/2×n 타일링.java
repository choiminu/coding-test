import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        if (N >= 3) dp[3] = 3;
        if (N >= 4) dp[4] = 5;

        for (int i = 5; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        bw.write(dp[N] + "");

        br.close();
        bw.flush();
        bw.close();

    }
}
