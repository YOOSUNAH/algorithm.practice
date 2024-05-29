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
            tree.put(1, new ArrayList<>());
            depthMap.put(1, 0);  // 루트 노드 깊이 : 0
        }

        public void insert(int X, int Y) {
            if (!tree.containsKey(X)) {
                System.out.println(-1);
                return;
            }
            tree.putIfAbsent(X, new ArrayList<>());
            tree.get(X).add(Y);
            tree.put(Y, new ArrayList<>());
            depthMap.put(Y, depthMap.get(X) + 1);
        }

        public void printChild(int X) {
            if (!tree.containsKey(X)) {
                System.out.println(-1);
                return;
            }
            List<Integer> children = tree.get(X);
            if (children.isEmpty()) {
                System.out.println(0);
            } else {
                for (int child : children) {
                    System.out.print(child + " ");
                }
                System.out.println();
            }

        }

        public void printDepth(int X) {
            if (depthMap.containsKey(X)) {
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




