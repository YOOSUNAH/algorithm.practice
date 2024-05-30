package algorithm;

import java.util.Scanner;

public class BinarySearchTree1_hard {

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

        public int height(){
            return heightRec(root);
        }

        private int heightRec(Node root){
            if(root == null){
                return -1;
            }else{
                int leftHeight = heightRec(root.left);
                int rightHeight = heightRec(root.right);
                return Math.max(leftHeight, rightHeight) + 1; // 현재 노드 높이 포함 + 1
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수 (T)  3
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  // 입력될 자연수의 수 (N)  7
            BinarySearchTree bst = new BinarySearchTree();
            int[] values = new int[N];
            for (int i = 0; i < N; i++) {
               int num = sc.nextInt();  // 4 2 6 1 3 5 7
               bst.insert(num);
            }
            System.out.println(bst.height());
        }
        sc.close();
    }
}




