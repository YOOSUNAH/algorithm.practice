package algorithm;

// ### 문제
//강인하는 본인이 개발한 링크드 리스트에서 첫번째 노드를 head, 맨 마지막 노드를 tail이라고 부른다.
//강인하는 tail과 head 를 연결시켜 환형 링크드 리스트를 만들었다.
//이때, 아래와 같이 주어진 삭제 명령들을 수행해 보자.
//- 명령 1 - Delete 8 → head로부터 8칸 떨어진 노드 삭제. .
//- 명령 2 - Delete 4 → head로부터 4칸 떨어진 노드 삭제.
//- 명령 3 - Delete 5 → head로부터 5칸 떨어진 노드 삭제.
//- head가 삭제되는 경우, head의 다음 노드였던 노드가 head가 된다.
//- Tail이 삭제되는 경우, tail의 이전 노드였던 노드가 tail이 된다.

import java.util.Scanner;

public class LinkedList2 {

    static class Node {

        int element;
        LinkedList2.Node nextNode;

        public Node(int element, LinkedList2.Node nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        public int getElement() {
            return element;
        }

        public LinkedList2.Node getNextNode() {
            return nextNode;
        }
    }

    static class LinkedList {

        private LinkedList2.Node head;
        private LinkedList2.Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void add(int element) {
            Node newNode = new Node(element, null);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                tail.nextNode = head;
            } else {
                tail.nextNode = newNode;
                newNode.nextNode = head;
                tail = newNode;
            }
        }

        public void delete(int index) {
            if (isEmpty()) {
                return;
            }

            Node currentNode = head;
            Node prevNode = tail;

            for (int i = 0; i < index; i++) {
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }

            // head가 삭제되는 경우, head의 다음 노드였던 노드가 head가 된다.
            if (currentNode == head) {
                head = head.nextNode;
                tail.nextNode = head;  // tail -> head 가리킴

                // Tail이 삭제되는 경우, tail의 이전 노드였던 노드가 tail이 된다.
            } else if (currentNode == tail) {
                tail = prevNode;
                tail.nextNode = head;

                // 이전 NextNode 를 그다음 Node으로 변경하기
            } else {
                prevNode.nextNode = currentNode.nextNode;
            }

            // 만약 리스트에 노드가 하나도 없으면
            if (isEmpty()) {
                head = null;
                tail = null;
            }
        }

        public void showList() {
            if (isEmpty()) {
                return;
            }
            LinkedList2.Node currentNode = head;

            // 원형을 출력하는 것이니, 일단 한번 출력하고 head로 돌아오면 멈춘다.
            do {
                System.out.print(currentNode.element);
                currentNode = currentNode.nextNode;
                if (currentNode != null) {  // 마지막 값이 null이면 공백이 출력되지 않게 아닐때만 공백
                    System.out.print(" ");
                }
            } while (currentNode != head);

            System.out.println();  // 다음 명령어로 잘 넘어가기 위해서 추가

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 제거

        for (int i = 0; i < N; i++) {
            String[] elements = sc.nextLine().split(" ");
            LinkedList2.LinkedList answerList = new LinkedList2.LinkedList();
            for (String e : elements) {
                answerList.add(Integer.parseInt(e));
            }

            for (int j = 0; j < 3; j++) {
                String command = sc.nextLine();
                if (command.startsWith("Delete")) {
                    int M = Integer.parseInt(command.split(" ")[1]);
                    answerList.delete(M);
                }
            }
            answerList.showList();
        }
        sc.close();
    }
}
