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

        int tc = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 0; i < tc; i++) {
            int[] alphabet = new int[26];

            Arrays.fill(alphabet, -1);

            String input = br.readLine();

            boolean flag = false;

            for (int j = 0; j < input.length(); j++) {
                int index = input.charAt(j) - 'a';
                if (alphabet[index] == -1 || alphabet[index] == j - 1) {
                    alphabet[index] = j;
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result++;
            }

        }

        bw.write(result + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
