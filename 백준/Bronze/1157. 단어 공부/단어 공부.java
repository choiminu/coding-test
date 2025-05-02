import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];

        char[] input = br.readLine().toUpperCase().toCharArray();
        for(char ch : input) {
            alphabet[ch - 'A']++;
        }

        char result = '?';
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < alphabet.length; i++) {

            if (alphabet[i] > max) {
                max = alphabet[i];
                result = (char)(i + 'A');
            } else if (alphabet[i] == max) {
                result = '?';
            }
        }
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
