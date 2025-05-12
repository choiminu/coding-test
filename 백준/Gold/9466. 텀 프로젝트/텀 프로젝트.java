import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int[] students;
    static boolean[] isVisited;
    static boolean[] isDone;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            int n = Integer.parseInt(br.readLine());

            students = new int[n + 1];
            isVisited = new boolean[n + 1];
            isDone = new boolean[n + 1];
            result = 0;

            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                students[j] = Integer.parseInt(token.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (isDone[j]) continue;
                dfs(j);
            }

            System.out.println(n - result);
        }


        br.close();
        bw.flush();
        bw.close();

    }

    private static void dfs(int index) {

        if (isDone[index]) {
            return;
        }

        if (isVisited[index]) {
            isDone[index] = true;
            result++;
        }

        isVisited[index] = true;
        dfs(students[index]);
        isDone[index] = true;
        isVisited[index] = false;
    }

}

