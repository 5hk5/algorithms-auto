import java.util.*;
import java.time.*;

/*
* fees = [기본시간(분), 기본요금, 단위시간(분), 단위요금] 
* => 각각 1<=a<=1,439 / 0<=b<=100,000 / 1<=c<=1,439 / 1<=d<=10,000
* records = ["시각 차량번호 입/출차", "HH:MM 1234 입차", ...] 
* => 하루 동안의 입출차 기록, 시각 기준 오름차순
*/
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량번호-주차시각 정리
        Map<String, List<String>> parkingTimeList = new TreeMap<>();
        for (String r : records){
            String[] splitedStr = r.split(" ");
            String time = splitedStr[0];
            String carNumber = splitedStr[1];
            
            if (!parkingTimeList.containsKey(carNumber)){
                parkingTimeList.put(carNumber, new ArrayList<String>());
            }
            parkingTimeList.get(carNumber).add(time);
        }
        
        // 주차시간 계산
        int carNum = parkingTimeList.size();
        int[] time = new int[carNum];  
        int index = 0;
        for (String car : parkingTimeList.keySet()){
            List<String> times = parkingTimeList.get(car);
            
            // List size 홀수면 23:59 행 추가
            if (times.size() % 2 == 1) {
                times.add("23:59");
            }
            
            // 시간 계산
            for (int j=0;j<times.size();j+=2){
                time[index] += Duration.between(
                    LocalTime.parse(times.get(j)), 
                    LocalTime.parse(times.get(j+1))
                ).toMinutes();
            }
            
            index++;
        }
        
        //차량별 요금 계산
        int[] answer = new int[carNum];  
        index = 0;
        for (String car : parkingTimeList.keySet()){
            answer[index] = calculateFee(fees, time[index]);
            index++;
        }

        return answer;
    }
    
    // 기본요금 + [초과시간 / 단위시간](올림) * 단위요금
    private static int calculateFee(int[] fees, int realTime){ // 총 시간 (분)
        int basicTime = fees[0];
        int basicFee = fees[1];
        int baseTime = fees[2];
        int baseFee = fees[3];
        
        if (realTime <= basicTime) {
            return basicFee;     
        }
        
        return basicFee + (int) Math.ceil((double)(realTime - basicTime) / baseTime) * baseFee;

    }
}