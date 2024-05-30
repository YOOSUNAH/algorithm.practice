package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Heap2_easy {

    static class MinHeap {

        private int[] heap;
        private int size;

        public MinHeap(int capacity) {
            heap = new int[capacity + 1];
            size = 0;
        }

        public void insert(int value) {
            heap[++size] = value; // 현재 힙의 크기를 1 증가, 증가된 크기를 인덱스로 사용해서 배열에 삽입
            upHeap(size); // heap 속성 유지
        }

        private void upHeap(int idx) {
            while (idx > 1 && heap[idx] < heap[idx / 2]) { // 힙은 보통 배열의 인덱스를 1부터 사용, 부모가 더 크면
                swap(idx, idx / 2); // 부모랑 자식이랑 교환
                idx = idx / 2;
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public int getP(int p){
            return heap[p];
        }

        public int[] toSortedArray(){
            int[] sortedArray = Arrays.copyOfRange(heap, 1, size + 1); // heap 배열 1부터 끝까지 복사
            Arrays.sort(sortedArray); // 정렬
            return sortedArray;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 개수 T

        for (int i = 0; i < T; i++) {
           int N = sc.nextInt(); // 입력받을 숫자의 개수 N
           int p = sc.nextInt(); // p
           MinHeap minHeap = new MinHeap(N);
           int[] numbers = new int[N];
            for (int j = 0; j < N; j++) { // N개의 숫자 입력
                int num = sc.nextInt(); // 8 4 6 2 3 10
                numbers[i] = num; // 배열에 저장
                minHeap.insert(num); // heap에 저장
            }
            // 첫 번째 줄에는 최소힙(Min-Heap)을 전체적으로 위쪽에서 아래쪽으로, 각 level 별로 왼쪽에서 오른쪽으로 읽었을 때, p번째 값을 출력한다.
            System.out.println(minHeap.getP(p));

            //두 번째 줄에는 정렬 기준에 따라 오름차순으로 정렬된 결과에서 p번째 값을 출력한다
            int[] sortedArray = minHeap.toSortedArray();
            System.out.println(sortedArray[p - 1]);
        }
        sc.close();
    }
}




