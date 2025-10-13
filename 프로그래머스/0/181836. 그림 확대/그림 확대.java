import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        return Arrays.stream(picture)
                .flatMap(row -> {
                    String expandedRow = row.chars()
                            .mapToObj(ch -> String.valueOf((char) ch).repeat(k))
                            .collect(Collectors.joining());
                    return Collections.nCopies(k, expandedRow).stream();
                })
                .toArray(String[]::new);
    }
}
