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

        String input = br.readLine();
        String[] result = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[i] = input.substring(i);
        }

        Arrays.sort(result);

        for (String str : result) {
            bw.write(str + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}


