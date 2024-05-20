import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 정해진 총액 이하 최대 예산 배정하기
* 1. 모든 요청 배정 가능하면 요청 금액 그대로 배정
* 2. 불가능하면 각 요청들에 일괄 적용할 기준(최대값) 구하여 *정수* 상한액 합산
* 입력값 1 : 지방 수 N (배정할 예산 개수)
* 입력값 2 : 각 지방 예산 요청 (N개)
* 입력값 3 : 총 예산
* 출력값 : 상한액 (정수)
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 지방 수

        int[] requestBudgets = new int[N]; // 각 지방 요청 예산
        int requestSum = 0; // 요청 예산 합
        int maxBudget = 0; // 최대 개별 예산

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            requestBudgets[i] = Integer.parseInt(st.nextToken());
            requestSum += requestBudgets[i];
            maxBudget = Math.max(maxBudget, requestBudgets[i]);
        }

        int totalBudget = Integer.parseInt(br.readLine()); // 총 예산

        // 상한액 구하기
        int answer = (totalBudget >= requestSum) ? maxBudget : binarySearch(requestBudgets, totalBudget);
        System.out.println(answer);
    }

    // 이분 탐색 => 중간값 계산해 최대 기준값 구하기 => 해당 금액 기준으로 다시 합산값 출력
    private static int binarySearch(int[] requestBudgets, int totalBudget) {
        int left = 0;
        int right = 1000000000; // 최대 범위
        int answer = 0;

        while (left<=right) {
            int mid = (left+right)/2;
            int currentSum = 0;

            for (int budget : requestBudgets){
                currentSum += Math.min(budget, mid);
            }

            if (currentSum <= totalBudget) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

}