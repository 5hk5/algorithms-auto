import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 정수 N => 연산들을 통해 1로 만들 때, 연산 수 최소값 구하기 (1<=N<=10^6)
* 연산:
* X가 3으로 나누어 떨어지면, 3으로 나눈다.
* X가 2로 나누어 떨어지면, 2로 나눈다.
* 1을 뺀다.
*
* 입력값 : N
* 출력값 : 연한 횟수 최소값
* */
public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(calculate(N));
    }

    private static int calculate(int N) {
        if (dp[N] == null){
            if (N % 6 == 0) {
                dp[N] = Math.min(calculate(N - 1), Math.min(calculate(N / 3), calculate(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(calculate(N / 3), calculate(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(calculate(N / 2), calculate(N - 1)) + 1;
            } else {
                dp[N] = calculate(N - 1) + 1;
            }
        }

        return dp[N];
    }

}
