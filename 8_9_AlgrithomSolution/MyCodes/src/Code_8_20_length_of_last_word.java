//58. 最后一个单词的长度
public class Code_8_20_length_of_last_word {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length-1].length();
    }
}
