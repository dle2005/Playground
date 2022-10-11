package Algorithm;

public class Tire {
    class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!current.hasChild(c))
                    current.children[c - 'a'] = new TrieNode();
                current = current.getChild(c);
            }
        }

        boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.hasChild(c)) current = current.getChild(c);
                else return false;
            }
            return true;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }
}
