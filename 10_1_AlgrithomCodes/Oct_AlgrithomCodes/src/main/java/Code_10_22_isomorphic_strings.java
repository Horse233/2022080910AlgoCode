import java.util.HashMap;

/**
 * 205. 同构字符串
 */
public class Code_10_22_isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(map.containsKey(sChar)){
                if(map.get(sChar) != tChar){
                    return false;
                }
            }else if(map2.containsKey(tChar)){
                if(map2.get(tChar) != sChar){
                    return false;
                }
            } else{
                map.put(sChar, tChar);
                map2.put(tChar, sChar);
            }

        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
