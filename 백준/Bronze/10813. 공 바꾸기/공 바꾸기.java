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

        int[] basket = new int[range];

        for (int i = 0; i < basket.length; i++) {
            basket[i] = i+1;
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int temp = basket[start];
            basket[start] = basket[end];
            basket[end] = temp;
        }

        bw.write(Arrays.stream(basket).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        br.close();
        bw.flush();
        bw.close();
    }
}
