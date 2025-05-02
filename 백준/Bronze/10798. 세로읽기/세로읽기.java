import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[5][15];

        for (int i = 0; i < arr.length; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                arr[i][j] = input[j];
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                if (arr[row][col] != '\u0000') {
                    sb.append(arr[row][col]);
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
