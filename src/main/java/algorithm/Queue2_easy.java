package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Queue2_easy {

    static class Queue {

        LinkedList<Integer> list = new LinkedList();

        public void add(int X) {
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

        public boolean empty() {
            return list.isEmpty();
        }

        public int dequeue() {
            int first = list.getFirst();
            list.removeFirst();
            return first;
        }

        public int comparePoint(int p1Point, int p2Point) {
            if (p1Point > p2Point) {
                return 1;
            } else if (p1Point < p2Point) {
                return 2;
            }
            else
              return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            sc.nextLine();

            String number1 = sc.nextLine();
            String number2 = sc.nextLine();
            Queue queue1 = new Queue();
            Queue queue2 = new Queue();

            addToQueue(number1, queue1);
            addToQueue(number2, queue2);

            int p1Point = 0;
            int p2Point = 0;

            while (!queue1.empty() && !queue2.empty()) {
                // 비교하기
                int p1 = queue1.dequeue();
                int p2 = queue2.dequeue();

                if (p1 > p2) {
                    p1Point++;
                } else if (p1 < p2) {
                    p2Point++;
                }
            }
            System.out.println(queue1.comparePoint(p1Point, p2Point));
        }
    }

    public static void addToQueue(String number, Queue queue) {
        String[] arrS1 = number.split(" ");
        List<Integer> numberList = new ArrayList<>();
        for (String s : arrS1) {
            numberList.add(Integer.parseInt(s));
        }
        for (int n : numberList) {
            queue.add(n);
        }

    }
}



