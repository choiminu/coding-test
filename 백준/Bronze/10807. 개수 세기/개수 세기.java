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

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());


        int result = 0;
        for (String s : input) {
            if (target == Integer.parseInt(s)) {
                result++;
            }
        }

        bw.write(result+"");


        br.close();
        bw.flush();
        bw.close();
    }
}
