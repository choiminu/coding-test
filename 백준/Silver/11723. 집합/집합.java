import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MySet set = new MySet();

        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            String op = cmd[0];

            if (op.equals("add")) {
                set.add(Integer.parseInt(cmd[1]));
            } else if (op.equals("remove")) {
                set.remove(Integer.parseInt(cmd[1]));
            } else if (op.equals("check")) {
                bw.write(set.check(Integer.parseInt(cmd[1])) + "\n");
            } else if (op.equals("toggle")) {
                set.toggle(Integer.parseInt(cmd[1]));
            } else if (op.equals("all")) {
                set.all();
            } else if (op.equals("empty")) {
                set.empty();
            }
        }

        bw.flush();
        bw.close();
    }

    static class MySet {
        boolean[] data = new boolean[21];

        void add(int x) {
            data[x] = true;
        }

        void remove(int x) {
            data[x] = false;
        }

        int check(int x) {
            return data[x] ? 1 : 0;
        }

        void toggle(int x) {
            data[x] = !data[x];
        }

        void all() {
            Arrays.fill(data, true);
        }

        void empty() {
            Arrays.fill(data, false);
        }
    }
}
