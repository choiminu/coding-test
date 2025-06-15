import java.util.HashMap;

class Solution {

    public static final HashMap<Character, int[]> direction = new HashMap<>() {{
        put('E', new int[]{1, 0});   
        put('W', new int[]{-1, 0}); 
        put('S', new int[]{0, 1});   
        put('N', new int[]{0, -1}); 
    }};

    public int[] solution(String[] park, String[] routes) {
        int[] startPos = new int[2]; // [x, y]

        for (int y = 0; y < park.length; y++) {
            for (int x = 0; x < park[y].length(); x++) {
                if (park[y].charAt(x) == 'S') {
                    startPos[0] = x; // x (열)
                    startPos[1] = y; // y (행)
                }
            }
        }

        for (String route : routes) {
            String[] op = route.split(" ");
            char dir = op[0].charAt(0);
            int dist = Integer.parseInt(op[1]);

            int dx = direction.get(dir)[0];
            int dy = direction.get(dir)[1];

            boolean blocked = false;

            for (int i = 1; i <= dist; i++) {
                int tx = startPos[0] + dx * i;
                int ty = startPos[1] + dy * i;

                if (tx < 0 || ty < 0 || tx >= park[0].length() || ty >= park.length) {
                    blocked = true;
                    break;
                }

                if (park[ty].charAt(tx) == 'X') {
                    blocked = true;
                    break;
                }
            }

            if (!blocked) {
                startPos[0] += dx * dist;
                startPos[1] += dy * dist;
            }
        }

        return new int[] { startPos[1], startPos[0] };
    }
}
