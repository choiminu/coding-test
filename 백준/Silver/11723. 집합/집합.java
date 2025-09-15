import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        Consumer<Integer> add = (key) -> {
            if (!map.containsKey(key)) {
                map.put(key, key);
            }
        };

        Consumer<Integer> remove = (key) -> {
            map.remove(key);
        };

        Consumer<Integer> check = (key) -> {
            sb.append(map.containsKey(key) ? "1" : 0).append("\n");
        };

        Consumer<Integer> toggle = (key) -> {
            if (map.containsKey(key)) {
                map.remove(key);
            } else {
                map.put(key, key);
            }
        };

        Runnable all = () -> {
            for (int i = 1; i <= 20; i++) {
                map.put(i, i);
            }
        };

        Runnable empty = () -> {
            for (int i = 1; i <= 20; i++) {
                map.remove(i);
            }
        };

        int N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "add":
                    add.accept(Integer.parseInt(input[1]));
                    break;
                case "remove":
                    remove.accept(Integer.parseInt(input[1]));
                    break;
                case "check":
                    check.accept(Integer.parseInt(input[1]));
                    break;
                case "toggle":
                    toggle.accept(Integer.parseInt(input[1]));
                    break;
                case "all":
                    all.run();
                    break;
                case "empty":
                    empty.run();
                    break;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

