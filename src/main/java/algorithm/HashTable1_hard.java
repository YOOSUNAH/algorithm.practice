package algorithm;

import java.util.Scanner;

public class HashTable1_hard {

    static class Item {

        int key, value;

        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class Arr {
        Item data;
        boolean flag = false;
        boolean deleted = false; // 삭제되었는지 확인
    }


    static class HashTable {
        private static final int MAX = 353333;
        private Arr[] hashArr = new Arr[MAX];
        private int sz = 0;

        public HashTable() {
            for (int i = 0; i < MAX; i++) {
                hashArr[i] = new Arr();
            }
        }

        private int hashFunc(int idx) {
            return idx % MAX;
        }

        public void insert(int key) {
            int index = hashFunc(key);
            int originalIndex = index;
            int probingCount = 1;

            while (hashArr[index].flag && hashArr[index].data != null) { // 현재 슬롯이 이미 사용 중(flag가 true이고 data가 null이 아닌 경우
                index = (index + 1) % MAX; // index 증가
                probingCount++;
                if (index == originalIndex) { // 테이블이 가득찬 경우
                    System.out.println("table이 가득 찼습니다.");
                    return;
                }
            }
            // 비어있는 슬롯을 찾으면, 새로운 Item 을 넣고 저장
            hashArr[index].data = new Item(key, key);
            hashArr[index].flag = true;
            hashArr[index].deleted = false;
            sz++;
        }

        public String delete(int key){
            int index = hashFunc(key);
            int originalIndex = index;
            int probaingCount = 1;

            while (hashArr[index].flag){ // 현재 슬롯이 사용 중(flag가 true인 경우)일 때,
                if(hashArr[index].data != null && hashArr[index].data.key == key && !hashArr[index].deleted){ // 찾고자 하는 key 와 일치하면

                    hashArr[index].deleted = true;
                    return "1 " + probaingCount;
                }
                index = (index + 1) % MAX;
                probaingCount++;
                if(index == originalIndex){
                break;
                }
            }
            return "0 " + probaingCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // 해시 테이블 구성할 자연수의 N
            HashTable hashTable = new HashTable();
            for (int j = 0; j < N; j++) {
                int n = sc.nextInt(); // 해시 테이블을 구성할 수
                hashTable.insert(n);
            }
                int M = sc.nextInt(); // // 해시 테이블을 탐색할 자연수의 수
                StringBuilder result = new StringBuilder();
                for (int k = 0; k < M; k++) {
                    int num = sc.nextInt(); // 해시 테이블을 탐색할 수
                    result.append(hashTable.delete(num)).append("\n");
                }
                System.out.println(result.toString());
            }
            sc.close();
        }
    }




