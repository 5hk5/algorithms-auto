import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  +, - 사용한 연산에 괄호 활용해 최소값 구하기
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("(?=[+-])");

        int sum = Integer.parseInt(split[0]);
        for (int i=1;i<split.length;i++){
            if (Integer.parseInt(split[i-1])<0 && Integer.parseInt(split[i])>0){
                split[i] = split[i].replace("+","-");
            }
            sum += Integer.parseInt(split[i]);
        }

        System.out.println(sum);
    }

}
