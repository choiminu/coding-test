import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 연산의 최소 횟수를 보관한다.
        int[] dp = new int[N + 1];

        if (N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= N; i++) {
            // 현재 숫자에서 1을 빼면 [i - 1] 값이 되기 때문에 이전 연산 횟수에 1을 더해준다.
            dp[i] = dp[i - 1] + 1;

            // 현재 숫자가 2로 나뉘어 떨어진다면?
            if (i % 2 == 0) {
                // 현재 숫자에서 1을 뺀 연산 횟수와 2로 나눌때 연산 횟수 중에 더 작은 값을 저장한다.
                // 1을 뺀 연산은 위에서 이미 +1로 연산 횟수를 기록하였기 때문에 2으로 나누는 경우에도 +1로 연산횟수를 기록한다.
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 현재 숫자가 3로 나뉘어 떨어진다면?
            if (i % 3 == 0) {
                // 현재 숫자에서 1을 뺀 연산 횟수와 3로 나눌때 연산 횟수 중에 더 작은 값을 저장한다.
                // 1을 뺀 연산은 위에서 이미 +1로 연산 횟수를 기록하였기 때문에 3으로 나누는 경우에도 +1로 연산횟수를 기록한다.
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);

        br.close();
        bw.flush();
        bw.close();
    }


}

