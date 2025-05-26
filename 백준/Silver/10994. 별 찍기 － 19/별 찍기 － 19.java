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
        int size = N * 4 - 3;

        char[][] star = new char[size][size];
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                star[i][j] = ' ';
            }
        }

        recursive(star, 0, star.length - 1);

        for (char[] st : star) {
            for (char ch : st) {
                System.out.print(ch);
            }
            System.out.println();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void recursive(char[][] star, int start, int end) {
        if (start > end) return;

        for (int i = start; i <= end; i++) {
            star[start][i] = '*';
            star[end][i] = '*';
            star[i][end] = '*';
            star[i][start] = '*';
        }

        recursive(star, start + 2, end - 2);

    }



}