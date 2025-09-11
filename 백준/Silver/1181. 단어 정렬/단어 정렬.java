import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (strings[i].length() > strings[j].length()) {
                    String temp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = temp;
                } else if (strings[i].length() == strings[j].length()) {
                    int idx = strings[i].compareTo(strings[j]);
                    if (idx > 0) {
                        String temp = strings[j];
                        strings[j] = strings[i];
                        strings[i] = temp;
                    }
                }
            }
        }

        Set<String> result = new LinkedHashSet<>();
        for (String string : strings) {
            result.add(string);
        }

        for (String s : result) {
            bw.write(s + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }


}

