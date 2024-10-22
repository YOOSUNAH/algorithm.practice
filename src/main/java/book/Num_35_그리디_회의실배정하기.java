package book;

import java.util.Arrays;
// import java.util.Comparator;
import java.util.Scanner;

 /*
     * N(회의 개수) A(회의 정보 저장)
     * 
     * A 배열 정렬 수행하기 (종료 시간 기준으로 정렬, 종료 시간이 같으면 시작 시간 기준 정렬)
     * 
     * for(회의실의 개수만큼 반복하기){
     *   if(앞 회의의 종료 시간보다 시작 시간이 빠른 회의가 나온 경우){
     *      현재 회의의 종료 시간으로 종료 시간 업데이트 하기 
     *      진행할 수 있는 회의 수 1 증가 
     * }
     * }
     * 
     * 총 진행 가능한 회의 수 출력하기 
     */

public class Num_35_그리디_회의실배정하기 {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int N = sc.nextInt();
     int[][] A = new int[N][2];

     for (int i = 0; i < N; i++) {
        A[i][0] = sc.nextInt(); // 시작 시간
        A[i][1] = sc.nextInt(); // 종료 시간
     }

    // v1 -> 조금 더 빠름 (익명 클래스를 사용하여 Comparator 인터페이스를 구현하는 방식)
    //  Arrays.sort(A, new Comparator<int[]>() {
    //   @Override
    //   public int compare(int[] S, int[] E){
    //     if(S[1] == E[1]){ // 종료 시간이 같으면, 시작 시간 기준 정렬
    //       return S[0] - E[0];
    //     }
    //     return S[1] - E[1]; 
    //   }
    //  });

    // v2 (람다식)
    // Arrays.sort(A, (S, E) -> {
    //   if (S[1] == E[1]) {
    //       return S[0] - E[0];  // 종료 시간이 같으면 시작 시간 기준 정렬
    //   }
    //   return S[1] - E[1];  // 종료 시간 기준으로 정렬
    // });

    // v3 -> 제일 느림 (하지만 큰 차이나는건 아님)
    Arrays.sort(A, (S, E) -> (S[1] == E[1]) ? S[0] - E[0]: S[1] - E[1]);
    // S[1] == E[1] 종료시간이 같으면,  S[0] - E[0] 시작 시간을 기준으로 정렬, 아니면  S[1] - E[1] 종료 시간을 기준으로 정렬
  
     int count = 0;
     int end = -1;
     for (int i = 0; i < N; i++) {
      if(A[i][0] >= end){  // A 의 i번째 회의의 0 시작 시간, end는 이전 회의의 종료시간
        // 이전회의의 종료시간(end) 보다 시작시간[i][0]이 늦거나 같으면, 
        // 현재 회의를 이전회의가 끝난 뒤에 시작할 수 있는지
        // 즉, 회의가 겹치지 않는 경우를 확인하는 것 (회의가 겹치지 않으면 -> 숫자가 더 크면)
        end = A[i][1];     // 현재 회의의 종료시간A[i][1]으로 종료시간(end) 업데이트 하기 
        count++;           // 진행할 수 있는 회의 수 1 증가 
      }
     }

     System.out.println(count);
    }
}
