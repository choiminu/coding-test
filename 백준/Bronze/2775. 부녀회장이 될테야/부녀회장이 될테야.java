import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.BiFunction;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] apart = new int[15][15];
        for (int i = 0; i < apart.length; i++) {
            if (i == 0) {
                for (int j = 0; j < apart[i].length; j++) {
                    apart[i][j] = j+1;
                }
            } else {
                for (int j = 0; j < apart[i].length; j++) {
                    if (j == 0) {
                        apart[i][j] = 1;
                    }else {
                        apart[i][j] = apart[i - 1][j] + apart[i][j-1];
                    }
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int y = Integer.parseInt(br.readLine());
            int x = Integer.parseInt(br.readLine());

            bw.write(apart[y][x-1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

}

