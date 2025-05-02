import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[100][100];

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            for (int j = 100 - (y + 10); j < 100 - y; j++) {
                for (int k = x; k < x + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);

        br.close();
        bw.flush();
        bw.close();
    }
}
