import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] changes = {25, 10, 5, 1};
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int[] result = new int[4];
            int num = Integer.parseInt(br.readLine());

            for (int j = 0; j < changes.length; j++) {
                result[j] = num / changes[j];
                num = num % changes[j];
                bw.write(result[j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
