package book;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;


public class Num_03_구간합구하기 { //백준에서는 Main으로 class명을 설정해야함.

    // 구간 합
    // S[i] = A[0] + A[1] + A[2] ... + A[i - 1] + A[i]
    // A[0] 부터 A[i] 까지의 합
    
    // 합 배열 S를 만드는 공식
    // S[i] = S[i - 1] + A[i]
    
    // 구간 합을 구하는 공식
    // S[j] - S[j -1]

    // 슈도코드 작성하기
    // suNo (숫자개수), quizNo(질의개수) 저장하기
    // for (숫자 개수만큼 반복하기){
    //  합 배열 생성하기 (S[i]) = S[i - 1] + A[i] }
    // for(질의 개수만큼 반복하기){
    // 질의 범위 받기 (i~ j)    
    // 구간 합 출력하기 (S[j] - S[i - 1]) }

    public static void main(String[] args) throws IOException{ 
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[suNo + 1];

        stringTokenizer = new StringTokenizer(bufferReader.readLine());
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
