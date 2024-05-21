import java.util.Scanner;

//### 문제
//정수를 저장하는 단일 링크드 리스트를 생성하고, 다음의 명령어들을 처리하는 프로그램을 작성하시오.
//명령어는 다음과 같이 총 4가지이다.
//[] addFront(X) : 정수 X를 리스트의 가장 앞에 삽입. (단, 1 ≤ X ≤ 100,000).
//[] removeFront() : 리스트에서 가장 앞에 있는 정수를 삭제하고, 삭제된 수를 출력. 만약 리스트가 비어 있는 경우, -1을 출력.
//[X] front() : 리스트의 가장 앞에 저장된 정수를 출력. 만약 리스트가 비어 있는 경우, -1을 출력.
//[X] empty() : 리스트가 비어 있으면 1, 비어 있지 않으면 0을 출력.

public class LinkedList1 {

    static class Node{
        int element;
        Node nextNode;

        public Node(int element, Node nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        public int getElement() {
            return element;
        }

        public Node getNextNode() {
            return nextNode;
        }
    }

    static class LinkedList{
        private Node head;
        private Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        // addFront(X) : 정수 X를 리스트의 가장 앞에 삽입. (단, 1 ≤ X ≤ 100,000).
        public void addFront(int element) {
            Node newNode = new Node(element, head);
            head = newNode;

            if (tail == null) {
                tail = head;
            }
        }

        // removeFront() : 리스트에서 가장 앞에 있는 정수를 삭제하고, 삭제된 수를 출력. 만약 리스트가 비어 있는 경우, -1을 출력.
        public int removeFront() {
            if (isEmpty()) {
                return -1;
            }
            int keep = head.getElement();
            head = head.getNextNode();
            if (head == null) {
                tail = null;
            }
            return keep;
        }

        // front() : 리스트의 가장 앞에 저장된 정수를 출력. 만약 리스트가 비어 있는 경우, -1을 출력.
        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return head.getElement();
        }

        // empty() : 리스트가 비어 있으면 1, 비어 있지 않으면 0을 출력.
        public int empty() {
            return isEmpty()? 1 : 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 제거

        LinkedList answerList = new LinkedList();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            if(command.startsWith("addFront")){
                int M = Integer.parseInt(command.split(" ")[1]);
                answerList.addFront(M);
            }
            else if(command.startsWith("removeFront")){
                System.out.println(answerList.removeFront());
            }
            else if(command.startsWith("front")){
                System.out.println(answerList.front());
            }
            else if(command.startsWith("empty")){
                System.out.println(answerList.empty());
            }
        }
        sc.close();
    }

}
