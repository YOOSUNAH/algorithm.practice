package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Num_07_주몽의명령{ //백준에서는 Main으로 class명을 설정해야함.
    /*
     * 투 포인터 이동 원칙
     * A[i] + A[j] > M: j--;  번호의 합이 M보다 크므로 큰 번호 index를 내립니다.
     * A[i] + A[j] < M: i++;  번호의 합이 M보다 작으므로 작은 번호 index를 올립니다.
     * A[i] + A[j] == M: i++; j--; count++;  양쪽 포인터를 모두 이동시키고 count를 증가시킵니다.
     * 
     * 슈도코드
     * N (재료의 개수), M(갑옷이 되는 번호) 저장하기
     * for(N만큼 반복){
     *   재료 배열 저장하기 
     * }
     * 재료 배열 정렬하기 
     * while(i > j){
     *   if(재료 합 < M) 작은 번호 재료를 한 칸 위로 변경하기 
     *   else if(재료 합 > M) 큰 번호 재료를 한 칸 아래로 변경하기 
     *   else 경우의 수 증가, 양쪽 index 각각 변경하기 
     * }
     * count 출력하기 
     */
    public static void main(String[] args) throws IOException{ 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 재료의 개수 
        int M = Integer.parseInt(bf.readLine()); // 갑옷이 완성되는 번호의 합
        int[]A = new int[N]; // 재료들
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N - 1;

        while (i < j) { // 투 포인터 이동 원칙 따라 포인터를 이동하며 처리 
            if(A[i]+ A[j] < M){
                i++;
            } else if(A[i] + A[j] > M){
                j--;
            } else{
                count++;
                i++;
                j--;
            }            
        }
        System.out.println(count);
        bf.close();
    }
}
