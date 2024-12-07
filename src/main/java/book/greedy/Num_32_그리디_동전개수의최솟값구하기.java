package book.greedy;

import java.util.Scanner;

public class Num_32_그리디_동전개수의최솟값구하기 {
    /*
     * 가격이 큰 동전부터 내림차순으로 k보다 가격이 작거나 같은 동전이 나올 때까지 탐색
     * 탐색을 멈춘 동전의 가격으로 k를 나누너 몫은 동전 개수에 더하고, 나머지는 k값으로 갱신
     * 나머지가 0이 될때까지 반복.
     * 
     * N(동전 개수) K(목표 금액)
     * A(동전 데이터 배열)
     * 배열 선언 for(N만큼 반복하기){
     *   A배열 저장하기 
     * }
     * 
     * // 가치가 큰 동전부터 선택해야 개수를 최소로 구성할 수 있음
     * for (N만큼 반복 -> N - 1 ~ 0으로 역순으로 반복하기){
     *  if(현재 k보다 동전 가치가 작으면){
     *     동전 수 += 목표 금액 / 현재 동전 가치
     *     목표 금액 = 목표 금액 % 현재 동전 가치   
     * }
     * }
     * 누적된 동전 수 출력
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int K = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }

      int count = 0;
      for (int i = N - 1; i >= 0; i--) {
        if(A[i] <= K){ // 현재 k보다 동전 가치가 작으면
            count += (K / A[i]);
            K = K % A[i];  // k를 현재 동전을 사용하고 남은 금액으로 갱신 
          }
        }
      System.out.println(count);
    }
}
