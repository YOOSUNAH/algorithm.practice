package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

// enqueue(X) : 정수 X를 큐의 뒤에 삽입. 큐가 가득차서 넣을 수 없는 경우 'Full'을 출력한다. (단, 입력되는 숫자 X는 1 ∼ 9의 자연수이다.)
// size() : 큐에 저장되어있는 정수의 개수를 출력.
// isEmpty() : 큐가 비어 있으면 1, 비어 있지 않으면 0을 출력.
public class Queue1_easy {

    static class Queue {

        LinkedList<Integer> list = new LinkedList();

        public void enqueue(int X) {
            list.add(X);
        }

        public int size() {
            return list.size();
        }

        public int isEmpty() {
            if (list.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        Queue stack = new Queue();

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();

        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            if (command.startsWith("enqueue")) {
                int M = Integer.parseInt(command.split(" ")[1]);

                if (stack.size() == size) {
                    System.out.println("FULL");
                } else {
                    stack.enqueue(M);
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("isEmpty")) {
                System.out.println(stack.isEmpty());
            }
        }
    }
}

