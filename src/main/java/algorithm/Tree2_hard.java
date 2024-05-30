package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tree2_hard {

    static class Tree {

        Map<Integer, List<Integer>> tree;
        int maxHeight;

        public Tree() {
            tree = new HashMap<>();
            tree.put(1, new ArrayList<>());
            maxHeight = 0;
        }

        public void insert(int X, int Y) {
            tree.putIfAbsent(X, new ArrayList<>()); // 노드 X에 자식 List 생성
            tree.putIfAbsent(Y, new ArrayList<>());
            tree.get(X).add(Y); // 노드 X에 자식리스트에 Y 추가
        }

        public void printLeft(int node, List<Integer> result) {
            result.add(node); // 현재 노드를 방문
            for (int child : tree.get(node)) {  // 1의 child : 2, 3, 4
                printLeft(child, result); // 2의 child
            }
        }

        public void printRight(int node, List<Integer> result) {
            for (int child : tree.get(node)) {
                printRight(child, result);
            } // 자식 노드를 방문한 후에
            result.add(node); // 현재 노드 방문
        }

        public void caculateDepth(int node, int currentheight) {
            maxHeight = Math.max(maxHeight, currentheight);
            for (int child : tree.get(node)) {
                caculateDepth(child, currentheight + 1);
            }
        }

        public int getMaxHeight() {
            return maxHeight;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            sc.nextLine();

            Tree tree = new Tree();
            for (int j = 0; j < M; j++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                tree.insert(parent, child);
            }

            // 전위 순회
            List<Integer> printLeftResult = new ArrayList<>();
            tree.printLeft(1, printLeftResult);
            for (int value : printLeftResult) {
                System.out.print(value + " ");
            }
            System.out.println();
            // 후위 순회
            List<Integer> printRightResult = new ArrayList<>();
            tree.printRight(1, printRightResult);
            for (int value : printRightResult) {
                System.out.print(value + " ");
            }
            System.out.println();
            // 트리 높이
            tree.caculateDepth(1, 0);
            System.out.println(tree.getMaxHeight());
        }
        sc.close();
    }
}




