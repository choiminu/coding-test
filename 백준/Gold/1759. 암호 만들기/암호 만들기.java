import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] chars;
    static char[] password;
    static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        chars = new char[C];
        password = new char[L];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = token.nextToken().charAt(0);
        }

        Arrays.sort(chars); // 사전순 정렬
        dfs(0, 0, bw);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int start, int depth, BufferedWriter bw) throws IOException {
        if (depth == L) {
            if (isValidPassword(password)) {
                bw.write(password);
                bw.newLine();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = chars[i];
            dfs(i + 1, depth + 1, bw);
        }
    }

    public static boolean isValidPassword(char[] pw) {
        int vowel = 0, consonant = 0;
        for (char c : pw) {
            if (vowels.contains(c)) vowel++;
            else consonant++;
        }
        return vowel >= 1 && consonant >= 2;
    }
}
