import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 100000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[MAX + 1];
        int[] maxPrimeFactor = new int[MAX + 1];
        
        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                    maxPrimeFactor[j] = i;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (maxPrimeFactor[i] <= K) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
