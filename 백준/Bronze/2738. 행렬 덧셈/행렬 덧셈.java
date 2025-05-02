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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int low = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[low][col];

        for (int i = 0; i < low * 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i % low][j] += Integer.parseInt(st.nextToken());
            }

        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.write("\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
