package book.greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Num_34_그리디_수를묶어서최댓값만들기 {
    /*
     * N (카드 묶음 개수)
     * plusPq(양수 우선순위 큐), minus(음수 우선순위 큐)
     * one(1의 개수 카운트) zero (0의 개수 카운트)
     * 배열 선언 for(N만큼 반복하기)
     *{ 데이터를 4개의 그룹에 분리 저장하기 
     * }
     * 
     * while(양수 우선순위 큐 크기가 2보다 작을 때까지){
     *   수 2개를 큐에서 뽑음(remove 연산)
     *   2개의 수를 곱한 값을 결괏값에 더함
     * }
     * 양수 우선순위 큐에 데이터가 남아 있으면
     * 이 데이터를 결괏값에 더함
     * 
     * while(음수 우선순위 큐 크기가 2보다 작을 때까지){
     *  수 2개를 큐에서 뽑음 (remove 연산)
     *   2개의 수를 곱한 값을 결괏값에 더함
     * }
     * 음수 우선순위 큐에 데이터가 남아 있고, 데이터 0이 1개도 없으면 
     * 이 데이터를 결괏값에 더함
     * 
     * 숫자 1의 개수를 결괏값에 더함
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
          int data = sc.nextInt();
          if (data > 1) {
            plusPq.add(data);
          }
          else if( data == 1){
            one++;
          }
          else if( data == 0){
            zero++;
          }
          else{
            minusPq.add(data);
          }
        }

        int sum = 0;

        // 양수 우선순위 큐 크기가 2보다 작을 때까지 = 1, 0 // 1보다 크면 계속하기 
        while(plusPq.size() > 1){
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum += first * second;
        }
        
       // 양수 우선순위 큐에 데이터가 남아 있으면, 더하기 
       if(!plusPq.isEmpty()){
        sum += plusPq.remove();
       }

       while(minusPq.size() > 1){
        int first = minusPq.remove();
        int second = minusPq.remove();
        sum += first * second;
       }

       if(!minusPq.isEmpty()){
          //데이터 0이 1개도 없으면 
          if( zero == 0){
            sum += minusPq.remove();
          }
          // 0이 있으면 음수랑 0이랑 곱하면 0이 되니, sum에 음수를 더하지않는다. 
       }
        
       sum += one; 
       System.out.println(sum);
    }
}
