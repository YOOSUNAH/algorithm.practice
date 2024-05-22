package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class Stack2 {

    static class Stack {

        LinkedList<Integer> list = new LinkedList();

        public boolean isEmpty() {
            if (list.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        public int top() {
            return list.getLast();
        }

        public void push(int X) {
            list.add(X);
        }

        public int pop() {
            int X = list.getLast();
            list.removeLast();
            return X;
        }

        // 더하기
        public void plus() {
            int x = pop();
            int y = pop();
            int result = x + y;
            push(result);
        }

        // 빼기
        public void minus() {
            int x = pop();
            int y = pop();
            int result;
            result = y - x; // 주의!
            push(result);
        }

        // 곱하기
        public void multiply() {
            int x = pop();
            int y = pop();
            int result = x * y;
            push(result);
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            for (int j = 0; j < command.length(); j++) {
                char[] arr = command.toCharArray();

                if (arr[j] == '+' || arr[j] == '-' || arr[j] == '*') {
                    if (arr[j] == '+') {
                        stack.plus();
                    }
                    if (arr[j] == '-') {
                        stack.minus();
                    }
                    if (arr[j] == '*') {
                        stack.multiply();
                    }
                } else {
                    stack.push(Integer.parseInt(String.valueOf(arr[j])));
                }
            }
            System.out.println(stack.top());
        }
    }
}
