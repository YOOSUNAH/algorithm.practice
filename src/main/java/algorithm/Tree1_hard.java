package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tree1_hard {

    static class Tree {

        Map<Integer, List<Integer>> tree;
        Map<Integer, Integer> depthMap;

        public Tree() {
            tree = new HashMap<>();
            depthMap = new HashMap<>();
            tree.put(1, new ArrayList<>());
            depthMap.put(1, 0);  // 루트 노드 깊이 : 0
        }

        public void insert(int X, int Y) {
            if (!tree.containsKey(X)) { // 부모 노드가 없을 경우
                System.out.println(-1);
                return;
            }
            tree.putIfAbsent(X, new ArrayList<>()); // 노드 X에 자식 List 생성
            tree.get(X).add(Y); // 노드 X에 자식리스트에 Y 축
            tree.put(Y, new ArrayList<>());  // 노드 Y에 대한 자식 list 추가
            depthMap.put(Y, depthMap.get(X) + 1); // 노드 Y 깊이 설명 (X+1)
        }

        public void printChild(int X) {
            if (!tree.containsKey(X)) { // 노드가 없을 경우
                System.out.println(-1);
                return;
            }
            List<Integer> children = tree.get(X);
            if (children.isEmpty()) { // 자식 노드가 없을 경우
                System.out.println(0);
            } else {
                for (int child : children) { // 자식 노드 출력
                    System.out.print(child + " ");
                }
                System.out.println();
            }

        }

        public void printDepth(int X) {
            if (!depthMap.containsKey(X)) { // 부모 노드가 없을 경우
                System.out.println(-1);
            } else {
                System.out.println(depthMap.get(X));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            String[] command = sc.nextLine().split(" ");

            switch (command[0]) {

                case "insert":
                    int X = Integer.parseInt(command[1]);
                    int Y = Integer.parseInt(command[2]);
                    tree.insert(X, Y);
                    break;

                case "printChild":
                    X = Integer.parseInt(command[1]);
                    tree.printChild(X);
                    break;

                case "printDepth":
                    X = Integer.parseInt(command[1]);
                    tree.printDepth(X);
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        }
        sc.close();
    }
}




