package book;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num_13_카드게임 {
    /*
     * 큐의 선입선출을 이용한 풀이 
     * 
     * 1. poll을 수행하여 맨 앞의 카드를 버린다. 
     * 2. 과정 1에 이어 바로 add를 수행해 맨 앞에 있는 카드를 가장 아래로 옮긴다. 
     * 3. 큐의 크기가 1이 될때까지 1 ~ 2를 반복한 후 큐에 남은 원소를 추출한다. 
     */

    public static void main(String[] args) {
        /*
         * N (카드의 개수) myQueue(카드 저장 자료 구조)
         * for(카드의 개수만큼 반복)
         * {
         *   큐에 카드 저장하기 
         * }
         * 
         * while(카드가 1장 남을 때까지){
         *   맨 위의 카드를 버림 : poll()
         *   맨 위의 카드를 가장 아래의 카드 밑으로 이동 : poll() -> add()
         * }
         * 마지막으로 남은 카드 출력
         */
         Scanner sc = new Scanner(System.in);
         Queue<Integer> myQueue = new LinkedList<>();
         int N = sc.nextInt();
        
         for (int i = 1; i <= N; i++) {
            myQueue.add(i);
         }

         while(myQueue.size() > 1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
         }
         System.out.println(myQueue.poll());
    }
}
