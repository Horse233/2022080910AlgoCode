import java.net.BindException;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 */
public class Code_10_27_design_add_and_search_words_data_structure {

}

class WordDictionary {

    private Tire tire;

    public WordDictionary() {
        tire = new Tire();
    }

    public void addWord(String word) {
        tire.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, tire);
    }
    public boolean dfs(String word, int index, Tire tire){
        if(index == word.length()){
            return tire.isEnd();
        }
        char ch = word.charAt(index);
        if(Character.isLetter(ch)){
            int childIndex = ch - 'a';
            Tire child = tire.getChildren()[childIndex];
            if(child != null && dfs(word, index + 1, child)){
                return true;
            }
        }else{
            for(int i = 0; i < 26; i++){
                Tire child = tire.getChildren()[i];
                if(child != null && dfs(word, index + 1, child)){
                    return true;
                }
            }
        }
        return false;
    }
}
class Tire{
    private Tire[] children;
    private boolean isEnd;
    public Tire(){
        children = new Tire[26];
        isEnd = false;
    }
    public void insert(String word){
        Tire node = this;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new Tire();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public Tire[] getChildren(){
        return children;
    }
    public boolean isEnd(){
        return isEnd;
    }

}
