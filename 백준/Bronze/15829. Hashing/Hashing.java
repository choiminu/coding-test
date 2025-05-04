import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (long) ((input[i] - 'a' + 1) * Math.pow(31, i));
        }

        System.out.println(sum);
    }
}