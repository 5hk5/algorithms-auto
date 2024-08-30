import java.util.*;

/*
* 도넛, 막대, 8자 그래프 수 + 각 그래프들 연결하는 정점 번호 세기
* 도넛 : 크기 n 정점 n 간선 n / 막대 : 크기 n 정점 n 간선 n-1 / 8자 : 크기 n 정점 2n+1 간선 2n+2 
* 입력 : edges=[{a,b}, ..] => 간선 a->b로 항함 (1 ≤ a, b ≤ 1,000,000)
* 출력 : [생성한 정점 번호, 도넛 그래프 수, 막대 그래프 수, 8자 그래프 수]
*/
class Solution {    
    /*
    * 들어오는 간선, 나가는 간선 리스트 (in, out) => 규칙 찾아 정점, 그래프 수 찾기
    * 정점 => in 0 && out 2개 이상 (out 수 = 총 그래프 수)
    * 도넛 => out=1,in=2인 정점이 있음
    * 막대 => out=0인 정점이 있음
    * 8자 => in=2이상, out=2인 정점이 있음
    */
    public int[] solution(int[][] edges) { // edges = [[2, 3], [4, 3], [1, 1], [2, 1]]
        int[] answer = new int [4]; // 정점, 도넛, 막대, 8자
        
        Map<Integer, Integer> in = new HashMap<>(); // {정점 번호 : 들어오는 간선 수}
        Map<Integer, Integer> out = new HashMap<>(); // {정점 번호 : 나가는 간선 수}
        
        // in, out 배열 세팅
        for (int[] edge : edges){
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);

            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        // 정점 찾기 (in=0, out>=2) & 8자 그래프 수 찾기 (in>=2, out=2)
        for (int o : out.keySet()){
            if (out.get(o) >= 2) {
                if (!in.containsKey(o)){
                    answer[0] = o;
                } else {
                    answer[3]++;
                }
            }
        }
        
        // 막대그래프 수 찾기 (out=0)
        for (int i : in.keySet()){
            if (!out.containsKey(i)) answer[2]++;
        }
        
        // 도넛그래프 수 = 전체 - 막대 - 8자
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
    
}