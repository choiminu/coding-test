import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long min = 1;
        long max = Integer.MIN_VALUE;

        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            if (A[i] > max) {
                max = A[i];
            }
        }

        long result= 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            // 중간 길이로 랜선을 자른다.
            for (long i : A) {
                count += i / mid;
            }

            // 자른 랜선의 길이가 M보다 큰 경우 더 길게 자를 수 있는지 확인
            if (count >= M) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);

        br.close();
    }



}
