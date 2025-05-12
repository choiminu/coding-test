import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

            int floor = (N % H == 0) ? H : N % H;
            int number = (N % H == 0) ? (N / H) : (N / H) + 1;

            bw.write(String.format("%d%02d\n", floor, number));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
