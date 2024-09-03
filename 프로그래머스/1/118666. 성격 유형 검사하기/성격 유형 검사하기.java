import java.util.*;

/*
* 성격 유형 테스트 (mbti와 유사)
* R or T / C or F / J or M / A or N ex. RFMN
* 검사지에는 7개의 선택지 있음 ex. 매우 비동의, 비동의, 약간 비동의, 모르겠음 .. 매우 동의
* => 선택지에 따라 정반대 지표에 각각 3 2 1 0 1 2 3 점 추가됨 ex. R+3 .. 0 T+1 T+2 T+3
* 출력 : 최종 성격 유형 4글자 ex. "RCJA"
*/
class Solution {
    /*
    * survey : 성격 지표 두글자 (첫글자는 비동의, 두번째 글자는 동의 시 점수 추가) ex. "RT"
    * choices : 선택지 (1 매우 비동의 ~ 4 모르겠음 ~ 7 매우 동의)
    */
    public String solution(String[] survey, int[] choices) {
        String[][] types = {{"R","T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        
        int choiceLength = choices.length;
        
        // choices 배열 점수화
        for (int i=0;i<choiceLength;i++){
            choices[i] -= 4;
        }
        
        // choices 선택지 탐색
        // 음수면 첫글자 value에, 양수면 두번째 글자 value에 |점수|++
        Map<String, Integer> result = new HashMap<>();
        for (int i=0;i<choiceLength;i++){
            String first = survey[i].charAt(0) + "";
            String second = survey[i].charAt(1) + "";
            
            if (choices[i] < 0){
                result.put(first, result.getOrDefault(first,0) + Math.abs(choices[i]));
            } else {
                result.put(second, result.getOrDefault(second,0) + choices[i]);                   }
        }
        
        StringBuilder answer = new StringBuilder();
        for (String[] type : types){
            int firstScore = result.getOrDefault(type[0], 0);
            int secondScore = result.getOrDefault(type[1], 0);
            
            if (firstScore > secondScore){
                answer.append(type[0]);
            } else if (secondScore > firstScore) {
                answer.append(type[1]);
            } else {
                answer.append(type[0]);
            }
        }
        
        return answer.toString();
    }
}