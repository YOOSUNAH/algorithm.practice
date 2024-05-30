package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Heap1_easy {

    static class MinHeap {

        private List<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<>();
        }

        public void insert(int e) {
            heap.add(e);
            upHeap(heap.size() - 1);
        }

        public int size() {
            return heap.size();
        }

        // isEmpty() : 힙이 비어 있으면 1, 비어 있지 않으면 0을 출력.
        public int isEmpty() {
            return heap.isEmpty() ? 1 : 0;
        }

        public void print() {
            if (heap.isEmpty()) {
                System.out.println(-1);
            } else {
                for (int num : heap) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }

        //[성질]
        //1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2
        //2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
        //3. 부모 노드 인덱스 = 자식 노드 인덱스 / 2
        private void upHeap(int idx) {
            while (idx > 0) { // : 루트 노드 도달할때까지 반복
                int parent = (idx - 1) / 2; // 부모 노드 계산
                if (heap.get(parent) <= heap.get(idx)) { // 현재 노드값이 부모 노드의 값보다 크거나 같으면
                    break;  // 중단
                }
                // 부모 노드값이 현재 노드값보다 크면, 두 노드 값을 교환
                Collections.swap(heap, parent, idx); // heap 리스트에 있는, 두 인덱스 값을 교환
                idx = parent;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 명령어의 개수
        Heap1_easy.MinHeap minHeap = new Heap1_easy.MinHeap();

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
                case "print":
                    minHeap.print();
                    break;
            }
        }
        sc.close();
    }
}




