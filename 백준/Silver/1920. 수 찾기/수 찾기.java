import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    static BiPredicate<int[], Integer> p = (arr, target) -> {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            }

            if (arr[mid] > target) {
                right = mid - 1;
            }
        }

        return false;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(p.test(arr, Integer.parseInt(st.nextToken()))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

