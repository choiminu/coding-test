import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BiConsumer<Stack<Integer>, Integer> push = (stack, value) -> {
            stack.push(value);
        };

        Function<Stack<Integer>, Integer> pop = stack -> {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.pop();
        };

        Function<Stack<Integer>, Integer> size = stack -> {
            return stack.size();
        };

        Function<Stack<Integer>, Integer> empty = stack-> {
            return stack.isEmpty() ? 1 : 0;
        };

        Function<Stack<Integer>, Integer> top = stack-> {
            return stack.isEmpty() ? -1 : stack.peek();
        };

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            String command = input[0];

            switch (command) {
                case "push":
                    push.accept(stack, Integer.parseInt(input[1]));
                    break;
                case "pop":
                    sb.append(pop.apply(stack)).append("\n");
                    break;
                case "size":
                    sb.append(size.apply(stack)).append("\n");
                    break;
                case "empty":
                    sb.append(empty.apply(stack)).append("\n");
                    break;
                case "top":
                    sb.append(top.apply(stack)).append("\n");
                    break;
            }
        };

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

