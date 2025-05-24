import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int col = 2 * N - 1;

        char[][] star = new char[N][col];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < col; j++) {
                star[i][j] = ' ';
            }
        }

        recursive(star, 0, N, col);

        for (int i = 0; i < star.length; i++) {
            int lastStarIndex = -1;

            for (int j = star[i].length - 1; j >= 0; j--) {
                if (star[i][j] == '*') {
                    lastStarIndex = j;
                    break;
                }
            }

            for (int j = 0; j <= lastStarIndex; j++) {
                bw.write(star[i][j]);
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void recursive(char[][] star, int start, int row, int end) {
        if (start > end) {
            return;
        }
        star[row - 1][start] = '*';
        star[row - 1][end - 1] = '*';

        recursive(star, start + 1, row - 1, end -1 );
    }
}