package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

// empty() : 스택이 비어 있으면 1, 비어 있지 않으면 0을 출력.
// top() : 스택의 가장 위에 저장된 정수를 출력. 만약 스택이 비어 있는 경우, -1을 출력.
// push(X) : 정수 X를 스택에 삽입. (단, 1 ≤ X ≤ 10,000)
// pop() : 스택에서 가장 위에 있는 정수를 삭제하고, 삭제된 수를 출력. 만약 스택이 비어 있는 경우, -1을 출력.
// size() : 스택에 저장되어 있는 정수의 개수를 출력.

public class Stack1_hard {

    static class Stack {

        LinkedList<Integer> list = new LinkedList();

        public boolean isEmpty() {
            if (list.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        public int empty() {
            return isEmpty() ? 1 : 0;
        }

        public int top() {
            if (isEmpty()) {
                return -1;
            } else {
                return list.getLast();
            }
        }

        public void push(int X) {
            list.add(X);
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }else{
                int X = list.getLast();
                list.removeLast();
                return X;
            }
        }

        public int size(){
            return list.size();
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            if(command.equals("empty")){
                System.out.println(stack.empty());
            }
            if(command.equals("top")){
                System.out.println(stack.top());
            }
            if(command.startsWith("push")){
                int X = Integer.parseInt(command.split(" ")[1]);
                stack.push(X);
            }
            if(command.equals("pop")){
                System.out.println(stack.pop());
            }
            if(command.equals("size")){
                System.out.println(stack.size());
            }

        }
    }
}
