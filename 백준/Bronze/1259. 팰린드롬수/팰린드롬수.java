import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            char[] input = br.readLine().toCharArray();
            String result = "yes";

            if (input.length == 1 && input[0] == '0') {
                break;
            }

            for (int i = 0; i < input.length / 2; i++) {
                if (input[i] != input[input.length - 1 - i]) {
                    result = "no";
                    break;
                }
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
