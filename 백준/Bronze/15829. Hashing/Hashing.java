import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 해시 함수 => 임의 입력 받아 고정된 길이의 출력 내보냄
* 문자열/수열 -> 정수
* ∑(원소*31) % 1234567891
* 입력 1 : 문자열 길이
* 입력 2 : 문자열 (알파벳 소문자)
* 출력 : 해시 값 (정수)
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;
        for (int i=0;i<length;i++){
            sum += ((str.charAt(i) - 'a' +1) * Math.pow(31, i)) % 1234567891;
        }

        System.out.println(sum);
    }

}
