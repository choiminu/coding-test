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

        int[] alphabet = new int[26];

        int tc = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < tc; i++) {
            alphabet[token.nextToken().charAt(0) - 65]++;
        }

        int target = br.readLine().charAt(0) - 65;

        bw.write(alphabet[target] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}