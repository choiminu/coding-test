import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;
        if(N >= 2) dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);

        br.close();
        bw.flush();
        bw.close();
    }


}

