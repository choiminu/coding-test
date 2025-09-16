import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 정수 N을 입력받는다.
        int n = Integer.parseInt(br.readLine());

        // 상태를 보관할 dp 배열 선언 (정수 n을 1로 만들기 위한 연산의 최소횟수)
        int[] dp = new int[n + 1];

        // dp[0] 과 dp[1]은 연산 횟수가 1이니 2부터 순회
        for (int i = 2; i < dp.length; i++) {

            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        bw.write(dp[n]+"");

        br.close();
        bw.flush();
        bw.close();
    }


}

