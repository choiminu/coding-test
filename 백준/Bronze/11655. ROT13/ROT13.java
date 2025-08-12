import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : input[i].toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    sb.append((char)(((ch - 'A' + 13) % 26) + 'A'));
                } else if (Character.isLowerCase(ch)) {
                    sb.append((char)(((ch - 'a' + 13) % 26) + 'a'));
                } else {
                    sb.append(ch);
                }
            }
            input[i] = sb.toString();
        }

        for (String result : input) {
            bw.write(result + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}


