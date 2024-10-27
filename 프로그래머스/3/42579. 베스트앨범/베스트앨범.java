import java.util.*;

class Solution {
    
    /* 
    * play 총합 기준 내림차순 정렬해 genre -> 장르 내 play 횟수 top2 정렬 
    * (play 횟수 동일하면 index 오름차순 정렬)
    * 입력 : 장르 배열, play 횟수 배열
    * 출력 : 정렬된 index 배열
    */
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // genre별 play 횟수 총합 (classic : 1450,)
        Map<String, Integer> playCount = new HashMap<>();
        
        // 출력 위한 정보 map (genre, index, play)
        // genre : {index : play}  ({classic : {1:1100}, {2:200}})
        Map<String, Map<Integer, Integer>> info = new HashMap<>();
        
        for (int i=0;i<genres.length;i++){
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0)+plays[i]);
            
            if (!info.containsKey(genres[i])){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                info.put(genres[i], map);
            } else {
                info.get(genres[i]).put(i, plays[i]);
            }
        }
        
        // play 총합 기준으로 genre 내림차순 sort
        List<String> sortedGenre = new ArrayList<>(playCount.keySet());
        Collections.sort(sortedGenre, 
                         (v1, v2) -> playCount.get(v2).compareTo(playCount.get(v1)));
        
        // 장르 play 총합 내림차순으로 각 장르 top2 play index 출력
        for (String key : sortedGenre){
            Map<Integer, Integer> eachPlayCount = info.get(key);
            List<Integer> eachPlayCountList = new ArrayList<>(eachPlayCount.keySet());
                
            Collections.sort(eachPlayCountList, 
                        (v1, v2) -> eachPlayCount.get(v2).compareTo(eachPlayCount.get(v1)));
                
            answer.add(eachPlayCountList.get(0));

            if (eachPlayCount.size()>1) answer.add(eachPlayCountList.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}