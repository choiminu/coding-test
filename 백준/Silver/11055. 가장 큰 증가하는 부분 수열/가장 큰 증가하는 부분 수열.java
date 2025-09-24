import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 수열의 크기를 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // 수열을 저장할 배열 선언.
        int[] A = new int[N];

        // 사용자에게 수열의 원소를 입력받아 배열에 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] : i번째 원소를 마지막으로 하는 부분 수열의 최대 합
        int[] dp = new int[N];
        dp[0] = A[0];

        for (int i = 1; i < N; i++) {
            int maxPrev = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    maxPrev = Math.max(maxPrev, dp[j]);
                }
            }
            dp[i] = A[i] + maxPrev;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        br.close();
        bw.flush();
        bw.close();
    }

}
