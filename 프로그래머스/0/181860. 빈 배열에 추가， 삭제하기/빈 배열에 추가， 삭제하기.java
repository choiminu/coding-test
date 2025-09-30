import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        return IntStream.range(0, arr.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(arr[i], flag[i]))
                .reduce(
                    new ArrayList<Integer>(),
                    (list, entry) -> {
                        if (entry.getValue()) { 
                            List<Integer> add = IntStream.range(0, entry.getKey() * 2)
                                                         .mapToObj(j -> entry.getKey())
                                                         .collect(Collectors.toList());
                            list.addAll(add);
                        } else {
                            int size = list.size();
                            int removeCount = entry.getKey();
                            for (int j = 0; j < removeCount; j++) list.remove(size - j - 1);
                        }
                        return list;
                    },
                    (list1, list2) -> { list1.addAll(list2); return list1; } 
                )
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
