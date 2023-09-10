import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // players 맵
        Map<Integer, String> playerKeyRank = new HashMap<>(); // rank:name
        Map<String, Integer> playerKeyName = new HashMap<>(); // name:rank
        for (int i=0;i<players.length;i++){
            playerKeyRank.put(i, players[i]);
            playerKeyName.put(players[i], i);
        }
        
        for (int i=0;i<callings.length;i++){
            int rank = playerKeyName.get(callings[i]);
            String player = playerKeyRank.get(rank);
            String playerAhead = playerKeyRank.get(rank-1);
            
            playerKeyName.put(player, rank-1);
            playerKeyName.put(playerAhead, rank);
            
            playerKeyRank.put(rank-1, player);
            playerKeyRank.put(rank, playerAhead);
        }
        
        for (int i=0;i<players.length;i++){
            players[i] = playerKeyRank.get(i);
        }
        
        return players;
    }
}