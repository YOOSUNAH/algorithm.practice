package algorithm;

import java.util.Scanner;

public class Heap1_hard {

    static class MinHeap {

        private int[] heap;
        private int size;

        public MinHeap(int capacity) {
            heap = new int[capacity + 1];
            size = 0;
        }

        public void insert(int e) {
            if (size >= heap.length - 1) { // heap 가득차면, insert 할 수 없다.
                return;
            }
            heap[++size] = e; // 현재 힙의 크기를 1 증가, 증가된 크기를 인덱스로 사용해서 배열에 삽입
            upHeap(size); // heap 속성 유지
        }

        private void upHeap(int idx) {
            while (idx > 1 && heap[idx] < heap[idx / 2]) { // 힙은 보통 배열의 인덱스를 1부터 사용, 부모가 더 크면
                swap(idx, idx / 2); // 부모랑 자식이랑 교환
                idx = idx / 2;
            }
        }
        // 힙에서 특정 노드의 인덱스를 i라고 할 때:
        // 부모 노드의 인덱스는 i / 2
        // 왼쪽 자식 노드의 인덱스는 2 * i
        // 오른쪽 자식 노드의 인덱스는 2 * i + 1

        public int size() {
            return size;
        }

        // isEmpty() : 힙이 비어 있으면 1, 비어 있지 않으면 0을 출력.
        public int isEmpty() {
            return size == 0 ? 1 : 0;
        }

        public int pop() {
            if (size == 0) {
                return -1; // 비어있으면 -1
            }
            int result = heap[1]; // 우선 순위 가장 높은 원소
            heap[1] = heap[size--]; // 마지막 요소를 최상단으로 옮겨서, (result) 제거
            downHeap(1); // heap 속성 유지
            return result;  // 우선 순위 가장 높은 원소 출력
        }

        private void downHeap(int idx) {
            while (2 * idx <= size) {
                int left = 2 * idx;
                int right = 2 * idx + 1;
                int child = left; // 우선 왼쪽 자식으로 가정
                if (right <= size && heap[right] < heap[left]) { // size보다 작다 heap 범위 내에 존재한다. 오른쪽 자식이 존재하고 & 오른쪽 자식이 왼쪽 자식보다 작으면
                    child = right; // 오른쪽 자식으로 설정
                }
                if (heap[idx] <= heap[child]) { // 현재 노드가, 자식보다 작으면 힙속성이 유지 되기 때문에
                    break; // 끝
                }
                swap(idx, child); // 아니라면 교환
                idx = child; // 현재 노드를 작은 자식의 위치로
            }
        }

        public int top() {
            if (size == 0) {
              return -1;
            } else
                return heap[1];
        }

        public void print() {
            if (size == 0) {
                System.out.println(-1);
                return;
            } else {
                for (int i = 0; i <= size; i++) {
                    System.out.print(heap[i] + " ");
                }
                System.out.println();
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 명령어의 개수
        MinHeap minHeap = new MinHeap(200000);

        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "insert":
                    int e = sc.nextInt();
                    minHeap.insert(e);
                    break;
                case "size":
                    System.out.println(minHeap.size());
                    break;
                case "isEmpty":
                    System.out.println(minHeap.isEmpty());
                    break;
                case "pop":
                    System.out.println(minHeap.pop());
                    break;
                case "top":
                    System.out.println( minHeap.top());
                    break;
                case "print":
                    minHeap.print();
                    break;
            }
        }
        sc.close();
    }
}




