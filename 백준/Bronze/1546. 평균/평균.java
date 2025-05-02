import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;

            if (num > max) {
                max = num;
            }
        }

        double result = 0.0;
        for (int i = 0; i < arr.length; i++) {
            result += (double) arr[i] / max * 100;
        }

        bw.write(result / arr.length + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
