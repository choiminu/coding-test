import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());

        int[] A = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() < i - L + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && A[deque.peekLast()] > A[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            bw.write(A[deque.peekFirst()] + " ");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
