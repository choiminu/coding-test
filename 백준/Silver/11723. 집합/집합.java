import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int bit = 0;
        while (T --> 0) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "add":
                    bit |= 1 << Integer.parseInt(input[1]);
                    break;
                case "remove":
                    bit &= ~(1 << Integer.parseInt(input[1]));
                    break;
                case "check":
                    sb.append((bit & 1 << Integer.parseInt(input[1])) != 0 ? "1" : "0").append("\n");
                    break;
                case "toggle":
                    bit ^= 1 << Integer.parseInt(input[1]);
                    break;
                case "all":
                    bit = (1 << 21) - 1;
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }

        bw.write(sb.toString());


        br.close();
        bw.flush();
        bw.close();
    }

}

