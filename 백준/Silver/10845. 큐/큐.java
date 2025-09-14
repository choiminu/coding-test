import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.IntSupplier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new LinkedList<>();

        IntSupplier pop = () -> q.isEmpty() ? -1 : q.poll();
        IntSupplier size = () -> q.size();
        IntSupplier empty = () -> q.isEmpty() ? 1 : 0;
        IntSupplier front = () -> q.isEmpty() ? -1 : q.peek();
        IntSupplier back = () -> q.isEmpty() ? -1 : q.peekLast();

        Map<String, IntSupplier> cmd = new HashMap<>();
        cmd.put("pop", pop);
        cmd.put("size", size);
        cmd.put("empty", empty);
        cmd.put("front", front);
        cmd.put("back", back);

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                String[] temp = line.split(" ");
                q.add(Integer.parseInt(temp[1]));
            } else {
                IntSupplier supplier = cmd.get(line);
                sb.append(supplier.getAsInt()).append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

