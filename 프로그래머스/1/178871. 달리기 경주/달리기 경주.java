import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
          String temp;
        
        
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i); // 플레이어랑 순위 해시맵에 매핑
        }
        
        for(int j = 0; j < callings.length; j++) {
            int currRank = rank.get(callings[j]); //여기서 호출된 선수의 순위를 get
    
            temp = players[currRank];       // 배열에서 직접 순위대로 자리 바꿔주기
            players[currRank] = players[currRank - 1];
            players[currRank - 1] = temp;
    
            // HashMap 업데이트
            rank.put(callings[j], currRank - 1);
            rank.put(players[currRank], currRank);
        }
        return players;
    }
}




