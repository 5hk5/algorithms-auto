import java.util.*;

/*
* 입력 : today "2022.02.20", terms : 약관 유효기간 ["A 6"], privacies : 약관 정보 ["2021.05.02 A"] (약관 번호=index+1)
* 출력 : 파기해야 할 약관 번호 = [1,2]
* (매월 28일에 끝나는 것으로 가정) 
*/
class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
                
        // terms Map으로 변경
        Map<String, String> termsMap = new HashMap<>();
        for (String term : terms){
            String[] newTerm = term.split(" ");
            termsMap.put(newTerm[0], newTerm[1]);
        }
        
        // 날짜 형식 String -> int
        int now = changeDate(today);
        
        // 약관 정보 탐색 -> 만료일자 계산 및 정답 배열에 대입
        for (int i=0;i<privacies.length;i++){
            String[] newPrivacy = privacies[i].split(" ");
            int monthsToAdd = Integer.parseInt(termsMap.get(newPrivacy[1])); // 유효 개월 수
            String signedDate = newPrivacy[0]; // 약관 동의 일자
                        
            int expireDate = getExpireDate(changeDate(signedDate), monthsToAdd);
            
            if (now > expireDate) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 문자열 -> 숫자로 날짜 변환
    private int changeDate(String date){
        String[] ymd = date.split("\\.");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        
        return year * 10000 + month * 100 + day;
    }
    
    // 동의일자 + 유효 개월수 => 만료일자 구하기
    private int getExpireDate(int date, int monthsToAdd){
        int year = date / 10000;
        int month = (date % 10000) / 100;
        int day = date % 100;
        
        month += monthsToAdd;
        year += month / 12;
        month %= 12;
        
        if (day == 1) {
            day = 28;
            month--;
        } else {
            day--;
        }
        
        if (month == 0) {
            month = 12;
            year--;
        }
        
        
        return year * 10000 + month * 100 + day;    
    }
    
}