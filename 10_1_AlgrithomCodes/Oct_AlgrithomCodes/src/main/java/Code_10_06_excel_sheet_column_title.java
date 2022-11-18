import sun.swing.StringUIClientPropertyKey;

/**
 * 168. Excel表列名称
 */
public class Code_10_06_excel_sheet_column_title {
    public String convertToTitle(int columnNumber) {
        String[] strings = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I",
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            int res = (columnNumber - 1) % 26;
            ans.insert(0, strings[res]);
            columnNumber = (columnNumber - 1) / 26;
        }
        return ans.toString();
    }
    public String convertToTitle2(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            int res = (columnNumber - 1) % 26;
            ans.append((char)('A' + res));
            columnNumber = (columnNumber - 1) / 26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(26 / 26);
        Code_10_06_excel_sheet_column_title code1006 = new Code_10_06_excel_sheet_column_title();
        System.out.println(code1006.convertToTitle2(
                701));
    }
}
