//67.二进制求和
public class Code_8_26_add_binary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int pre = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i --, j --){
            int cur = 0;
            if(i < 0 || j < 0){
                if(i < 0){
                    cur = b.charAt(j) - '0' + pre;
                }else{
                    cur = a.charAt(i) - '0' + pre;
                }
            }else{
                cur = (a.charAt(i) - '0') + (b.charAt(j) - '0') + pre;
            }
            pre = cur / 2;
            cur = cur % 2;
            ans.insert(0, cur);
        }
        if(pre != 0){
            ans.insert(0, pre);
        }
        return ans.toString();
    }
    public String addBinary2(String a, String b){
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }
    public String addBinary3(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


}
