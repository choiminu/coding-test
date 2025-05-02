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

        int[][] arr = new int[9][9];

        int max = Integer.MIN_VALUE;
        String index = "";

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < arr[i].length; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                if (num > max) {
                    max = num;
                    index = (i + 1) + " " + (j + 1);
                }
            }
        }

        bw.write(max + "\n" + index);

        br.close();
        bw.flush();
        bw.close();
    }
}
