class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int time = 0;
        int cnt = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int attackDamage = attack[1];
            
            while (time + 1 < attackTime) {
                time++;
                cnt++;
                
                if (hp < health) {
                    hp += bandage[1];
                    hp = Math.min(health, hp);
                }
                
                if (cnt == bandage[0]) {
                    hp += bandage[2];
                    hp = Math.min(health, hp);
                    cnt = 0;
                }
            }
            time = attackTime;
            hp -= attackDamage;
            if (hp <= 0) return -1;
            cnt = 0;
        }
        
        return hp;
    }
}