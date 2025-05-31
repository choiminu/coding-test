import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[] A;
    static char[] R;
    static boolean[] isVisited;

    static LinkedHashSet<String> result = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        A = new char[M];
        R = new char[N];
        isVisited = new boolean[M];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            A[i] = token.nextToken().charAt(0);
        }

        Arrays.sort(A);

        dfs(0, 0);

        for (String s : result) {
            bw.write(s + "\n");
        }

        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int start, int depth) {

        if (depth == N) {
            int vowel = 0;
            int consonant = 0;
            for (char c : R) {
                if ("aeiou".contains(String.valueOf(c))) {
                    vowel++;
                } else {
                    consonant++;
                }
            }

            if (vowel >= 1 && consonant >= 2) {
                result.add(new String(R));
            }
            return;
        }

        for (int i = start; i < M; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                R[depth] = A[i];
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }

    }



}
