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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] arr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j < (e - s + 1) / 2; j++) {
                int temp = arr[s + j];
                arr[s + j] = arr[e - j];
                arr[e - j] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
