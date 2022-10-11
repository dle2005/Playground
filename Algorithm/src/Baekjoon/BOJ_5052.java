package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_5052 {
    public static class TrieNode {
        // 자식 노드 맵
        private Map<Character, TrieNode> childNodes = new HashMap<>();

        // 마지막 글자인지 여부
        private boolean isLastChar;

        //자식 노드 맵 Getter
        public Map<Character, TrieNode> getChildNodes() {
            return childNodes;
        }

        // 마지막 글자인지 여부 Getter
        public boolean isLastChar() {
            return isLastChar;
        }

        // 마지막 글자인지 여부 Setter
        public void setLastChar(boolean lastChar) {
            isLastChar = lastChar;
        }
    }

    public static class Trie {
        // 루트 노드
        private TrieNode rootNode;

        // 생성자
        Trie() {
            rootNode = new TrieNode();
        }

        // 자식 노드 추가
        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            // 한 문자씩 존재하지 않는다면 추가
            for(int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes()
                        .computeIfAbsent(word.charAt(i), c -> new TrieNode());
//                thisNode.setLastChar(false);
            }

            // 마지막 문자 마지막 문자임으로 체크
            thisNode.setLastChar(true);
        }

        // 특정 단어가 들어있는지 확인
        boolean contains(String word) {
            TrieNode thisNode = this.rootNode;

            // 문자가 존재하는지 확인
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(c);

                if(node == null) return false;

                thisNode = node;
            }

            // 마지막 문자인지 여부로 리턴

            if(thisNode.getChildNodes().isEmpty()) {
                return true;
            }
            else
                return false;

//            return !thisNode.isLastChar();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 전화번호의 수
            Trie trie = new Trie(); // trie 노드 생성
            String[] input = new String[n]; // 입력 전화번호

            for(int j = 0; j < n; j++) {
                input[j] = br.readLine();

                trie.insert(input[j]); // trie 노드에 추가
            }

            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if(!trie.contains(input[j])) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }

            if(flag) System.out.println("YES");
        }
    }
}
