import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String input = br.readLine();

        for (int i = 0; i < croatia.length; i++) {
            for (int j = 0; j < croatia.length; j++) {
                if (input.contains(croatia[j])) {
                    input = input.replace(croatia[j], "?");
                }
            }
        }

        bw.write(input.length() + "");


        br.close();
        bw.flush();
        bw.close();
    }
}
