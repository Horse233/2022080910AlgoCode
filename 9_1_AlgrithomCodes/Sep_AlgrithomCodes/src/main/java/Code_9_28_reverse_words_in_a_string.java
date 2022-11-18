import java.sql.Connection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 */
public class Code_9_28_reverse_words_in_a_string {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = strings.length-1; i>=0;i--){
            if(strings[i].equals("")){
                continue;
            }else {
                ans.append(strings[i]).append(" ");
            }
        }
        return ans.toString().substring(0, ans.length()-1);
    }
    public String reverseWords1(String s){
        s = s.trim();
        List<String> stringList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(stringList);
        return String.join(" ", stringList);
    }
}
