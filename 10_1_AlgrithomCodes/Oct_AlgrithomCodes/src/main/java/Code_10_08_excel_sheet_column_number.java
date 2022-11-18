/**
 *  171. Excel 表列序号
 */
public class Code_10_08_excel_sheet_column_number {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int j = columnTitle.length() - 1;
        for(int i = 0; i < columnTitle.length(); i++){
            ans += ((columnTitle.charAt(i) - 'A') + 1) * Math.pow(26, j);
            j--;
        }
        return ans;
    }

    public int titleToNumber2(String columnTitle) {
        int ans = 0;
        int pow = 1;
        for(int i = columnTitle.length() - 1; i >= 0; i--){
            ans += ((columnTitle.charAt(i) - 'A') + 1) * pow;
            pow *= 26;
        }
        return ans;
    }


    public static void main(String[] args) {
        Code_10_08_excel_sheet_column_number code1008 = new Code_10_08_excel_sheet_column_number();
        System.out.println(code1008.titleToNumber2("ZY"));
    }
}
