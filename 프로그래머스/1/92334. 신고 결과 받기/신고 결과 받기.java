import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, List<String>> send = new HashMap<>();
        HashMap<String, Integer> receive = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();

        for (String id : id_list) {
            receive.put(id, 0);
        }
        
        for (String rep : report) {
            String sender = rep.split(" ")[0];
            String receiver = rep.split(" ")[1];
            
            send.putIfAbsent(sender, new ArrayList<>());
            if (!send.get(sender).contains(receiver)) {
                send.get(sender).add(receiver);
                receive.put(receiver, receive.getOrDefault(receiver, 0) + 1);
            }
        }
        
        List<String> blockUser = new ArrayList<>();
        for (Map.Entry<String, Integer> user : receive.entrySet()) {
            if (receive.get(user.getKey()) >= k) {
                blockUser.add(user.getKey());
            }
        }
    
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int mail = 0;
            
            if (send.containsKey(id_list[i])) {
                List<String> reportList = send.get(id_list[i]);
                for (String list : reportList) {
                    if (blockUser.contains(list)) {
                        mail++;
                    }
                }   
            }
            
            answer[i] = mail;
        }
        
        
        
        return answer;
    }
}