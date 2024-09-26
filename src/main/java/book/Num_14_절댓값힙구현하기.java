package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Num_14_절댓값힙구현하기 {
    /*
     * 우선순위 큐를 이용한 풀이 
     * 
     * 절댓값 힙 : 다음과 같은 연산을 지원하는 자료구조
     * 1. 배열에 정수 x(x는 0이 아님)을 넣는다. 
     * 2. 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다. 
     *    절댓값이 가장 작은 값이 여러 개일 경우에는 그 중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.   
     * 
     * 데이터가 새로 삽입될때마다 절댓값과 관련된 정렬이 필요하므로 우선순위 큐로 문제를 쉽게 해결할 수 있다. 
     * 단, 절댓값 정렬이 필요하므로 우선순위 큐의 정렬 기준을 직접 정의해야 함
     * 예제의 절댓값이 같을 때는 음수를 우선하여 출력해야 한다.
     *
     * X = 0일때,
     *      큐가 비어있을 때는 0을 출력하고, 
     *      비어 있지 않을 때는 절대삾이 최소인 값을 출력한다. 
     *      단, 절댓값이 같다면 음수를 우선하여 출력한다. 
     * X = 1일때, 
     *      add로 큐에 새로운 값을 추가하고, 우선순위 큐 정렬 기준으로 자동 정렬한다.
     */

    public static void main(String[] args) throws IOException{
        /*
         * N(질의 요청 개수)
         * 우선순위 큐 선언
         * - 절댓값 기준으로 정렬되도록 설정하기 
         * - 단, 절댓값이 같으면 음수 우선 정렬하기 
         * 
         * for(N만큼 반복)
         * {
         *   요청이 0일때 : 큐가 비어 있으면 0, 
         *                비어있지 않으면 큐의 front 값 출력하기 (poll())
         *   요청이 1일때 : 새로운 데이터를 우선순위 큐에 더하기 (add())
         * }
         */
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());

         // 절댓값이 가장 작은 값을 출력
         PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
               return o1 > o2 ? 1 : -1;  // 절댓값이 같으면 음수 우선 정렬하기
            else
               return first_abs - second_abs; // 절댓값을 기준으로 정렬하기
         });

         for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
               if(MyQueue.isEmpty())
                  System.out.println("0");
               else
                  System.out.println(MyQueue.poll());  // 절댓값이 최소인 값을 출력 
            }else{           
               MyQueue.add(request); // 새로운 값을 추가하고, 우선순위 큐 정렬 기준으로 자동 정렬
            }
            
         }
    }
}
