import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BiFunction<int[], Integer, Integer> lowwerBound = (arr, target) -> {
            int left = 0;
            int right = arr.length;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;

                if (arr[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        };

        BiFunction<int[], Integer, Integer> upperBound = (arr, target) -> {
            int left = 0;
            int right = arr.length;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;

                if (arr[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        };

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {

            int num = Integer.parseInt(st.nextToken());
            int low = lowwerBound.apply(arr, num);
            int high = upperBound.apply(arr, num);

            sb.append(high - low).append(" ");

        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

