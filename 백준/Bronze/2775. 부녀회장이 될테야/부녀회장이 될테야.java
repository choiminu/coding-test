import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k + 1][n];

            for (int y = 0; y < k + 1; y++) {
                for (int x = 0; x < n; x++) {
                    apt[y][0] = 1;
                    apt[0][x] = x + 1;
                }
            }

            for (int y = 1; y < k + 1; y++) {
                for (int x = 1; x < n; x++) {
                    apt[y][x] = apt[y - 1][x] + apt[y][x - 1];
                }
            }

            System.out.println(apt[k][n-1]);

        }
    }
}

