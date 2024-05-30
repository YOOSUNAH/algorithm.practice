package algorithm;

import java.util.Scanner;

public class BinarySearchTree1_easy {

    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class BinarySearchTree{
        Node root;

        public void insert(int data){
            root = insertRec(root, data);
        }

        private Node insertRec(Node root, int data){
            if(root == null){
                root = new Node(data);
                return root;
            }
            if (data < root.data){
                root.left = insertRec(root.left, data);
            }
            else if(data > root.data){
                root.right = insertRec(root.right, data);
            }
            return root;
        }

        public int[] find(int data){
            return findRec(root, data, 0);
        }

        private int[] findRec(Node root, int data, int depth){
            if(root == null) return new int[]{0, 0};
            if(root.data == data){
                int degree = 0;
                if(root.left != null) degree++;
                if(root.right != null) degree++;
                return new int[]{degree, depth};
            }
            if(data < root.data){
                return findRec(root.left, data, depth + 1);
            }
            else return findRec(root.right, data, depth + 1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수 (T)  2
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  // 입력될 자연수의 수 (N)  7
            BinarySearchTree bst = new BinarySearchTree();
            int[] values = new int[N];
            for (int i = 0; i < N; i++) {
               int num = sc.nextInt();
               bst.insert(num);
            }

            int M = sc.nextInt();  // 탐색할 노드의 수 (M) 3

            for (int i = 0; i < M; i++) {
                int searchNum = sc.nextInt(); // 탐색할 노드의 입력  12 10 20
                int[] result = bst.find(searchNum);
                if (result[0] == 0 && result[1] == 0) {
                    System.out.println(0);
                }else{
                    System.out.println(result[0] + " " + result[1]);
                }
            }
        }
        sc.close();
    }
}




