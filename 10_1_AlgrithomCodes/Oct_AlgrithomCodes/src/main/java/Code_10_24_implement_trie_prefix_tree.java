/**
 * 208. 实现 Trie (前缀树)
 */
public class Code_10_24_implement_trie_prefix_tree {

}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }
    public Trie searchPrefix(String word){
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
           int index = word.charAt(i) - 'a';
           if(node.children[index] == null){
               return null;
           }
           node = node.children[index];
        }
        return node;
    }
}
