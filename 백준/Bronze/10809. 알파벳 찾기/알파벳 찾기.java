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

        Arrays.fill(alphabet, -1);

        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (alphabet[input[i] - 'a'] == -1) {
                alphabet[input[i] - 'a'] = i;
            }
        }

        for (int i : alphabet) {
            bw.write(i + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
