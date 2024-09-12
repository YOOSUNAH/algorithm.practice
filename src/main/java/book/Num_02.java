package book;

import java.util.Scanner;

public class Num_02 { //백준에서는 Main으로 class명을 설정해야함.

    // 최대값 = M
    //  모든 점수/M *100 으로 각 점수를 고침
    // (a/ M * 100 + b/M*100 + c/M *100 )/ 갯수
    // (a + b + c)/ M *100 / 갯수
    // sum * 100 / Max / N개

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] subjectList = new int[N];

        for (int i = 0; i < N; i++) {
            subjectList[i] = sc.nextInt();
        }
        
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if(subjectList[i] > max){
                max = subjectList[i];
            }

            sum = sum + subjectList[i];
        }
        System.out.println(sum *100.0 /max  /N);
        }
}
