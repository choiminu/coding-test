import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] chess = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < chess.length; i++) {
            int count = Integer.parseInt(token.nextToken());
            chess[i] -= count;
        }

        bw.write(Arrays.stream(chess).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        br.close();
        bw.flush();
        bw.close();
    }
}
