import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        s = s.replace("DKSH","?");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                result++;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}