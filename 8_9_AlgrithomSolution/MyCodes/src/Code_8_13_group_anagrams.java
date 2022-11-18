import java.util.*;

public class Code_8_13_group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            ArrayList<String> tmp = map.getOrDefault(key, new ArrayList<>());
            tmp.add(str);
            map.put(key,  tmp);
        }
        return new ArrayList<>(map.values());
    }
    public List<List<String>> groupAnagrams2(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] box = new int[26];
            char[] ch = str.toCharArray();
            for(char c : ch){
                box[c - 'a'] += 1;
            }
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(box[i] != 0){
                    key.append('a'+i).append(box[i]);
                }
            }
            List<String> list = map.getOrDefault(key.toString(), new ArrayList<String>());
            list.add(str);
            map.put(key.toString(), list);
        }
        return new ArrayList<>(map.values());
    }
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
