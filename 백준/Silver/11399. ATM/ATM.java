
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* ATM 대기인원 당 대기시간 최소 합산값 구하기
* => 오름차순 정렬 후 누적값 각자 합하기
* 입력값 1 : 대기 인원
* 입력값 2 : 대기인당 인출 시간
* 출력값 : 대기시간 최소 누적값
* */
public class Main {

    public static void main(String[] args) throws IOException {
        int[] counting = new int[1001]; // 카운팅 정렬

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];

        for (int i=0;i<num;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            counting[arr[i]]++;
        }

        int answer = 0;
        int sum = 0;
        for (int i=1;i<=1000;i++){
            while (counting[i]-- > 0){
                answer += sum + i;
                sum += i;
            }
        }

        System.out.println(answer);
    }

}
