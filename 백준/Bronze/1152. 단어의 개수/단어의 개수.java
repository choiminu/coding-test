import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().trim().split(" ");

        if (input.length == 1 && input[0].isEmpty()) {
            bw.write("0");
        } else {
            bw.write(input.length + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

