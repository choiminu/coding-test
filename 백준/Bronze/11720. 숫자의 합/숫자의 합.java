import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int range = Integer.parseInt(br.readLine());

        char[] nums = br.readLine().toCharArray();

        int sum = 0;
        for (char ch : nums) {
            sum += ch - '0';
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
