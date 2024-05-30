package algorithm;

import java.util.Scanner;

public class BinarySearchTree2_easy {

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

        public void deleteKey(int key){
            root = deleteRec(root,key);
        }

        private Node deleteRec(Node root, int key){
            if(root == null) { // 현재 node가 null 인 경우  트리가 비어있거나, 끝인 경우
                return root; // null을 반환
            }
            if(key < root.data) {  // 삭제할 키가 현재 노드의 데이터보다 작은 경우, 왼쪽 서브트리에서 키를 삭제
                root.left = deleteRec(root.left, key);
            } else if(key > root.data){  // 삭제할 키가 현재 노드의 데이터보다 큰 경우, 오른쪽 서브트리에서 키를 삭제
                root.right = deleteRec(root.right, key);
            }

            // 삭제할 키가 현재 노드의 데이터와 같은 경우,
            else{
                if(root.left == null){ // 삭제하려는 노드의 왼쪽 자식이 없다면, 오른쪽 자식을 반환
                    return root.right; // 삭제할 노드의 위치에 오른쪽 자식을 올려놓는 것
                }else if(root.right == null){
                    return root.left;
                }
                // 삭제할 노드가 두 자식을 모두 가지고 있는 경우
                root.data = minValue(root.right); // 오른쪽 서브트리에서 가장 작은 값을 찾아서
                root.right = deleteRec(root.right, root.data);  // 삭제
            }
            return root;
        }

        // 오른쪽 서브트리에서 최소값을 찾기
        public int minValue(Node root){
            int minv = root.data;   // 현재 노드의 데이터를 최소값으로 초기화
            while (root.left != null){ // 왼쪽 자식이 있는 동안 계속 왼쪽으로 이동 (최소값을 찾기 위해)  // 이진 탐색 트리에서는 각 노드의 왼쪽 자식은 항상 그 노드보다 작은 값을 가지고..!
                minv = root.left.data;  // 최소값을 왼쪽 자식의 데이터로 업데이트
                root = root.left; // 루트를 왼쪽 자식으로 이동
            }
            return minv;
        }

        void preOrder(Node node){
            if(node == null){
                return;
            }
            System.out.print(node.data + " "); // root
            preOrder(node.left); // 왼쪽
            preOrder(node.right); // 오른쪽
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수 (T)  2
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  // 입력될 자연수의 수 (N)  7
            BinarySearchTree bst = new BinarySearchTree();

            for (int i = 0; i < N; i++) {
               int num = sc.nextInt();  // 18 7 26 3 12 22 30
               bst.insert(num);
            }

            int M = sc.nextInt();  // 삭제할 노드의 수 (M)  3
            for (int i = 0; i < M; i++) {
                int deleteNum = sc.nextInt();  // 18 22 12
                bst.deleteKey(deleteNum);
            }

            // 전위 순회를 하며 출력
            if(bst.root != null){
                bst.preOrder(bst.root);
                System.out.println();
            }else{
                System.out.println("0");
            }
        }
        sc.close();
    }
}




