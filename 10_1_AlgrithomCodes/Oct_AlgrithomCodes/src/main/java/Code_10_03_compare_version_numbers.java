public class Code_10_03_compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length;
        int n = v2.length;
        for(int i = 0; i < Math.min(m, n); i++){
            Integer v1Num = Integer.parseInt(v1[i]);
            Integer v2Num = Integer.parseInt(v2[i]);
            if(v1Num > v2Num){
                return 1;
            }
            if(v1Num < v2Num){
                return -1;
            }
        }
        if(m == n){
            return 0;
        }else if(m > n){
            for(int i = n; i < m; i++){
                if(Integer.parseInt(v1[i]) > 0){
                    return 1;
                }
            }
            return 0;
        }else{
            for(int i = m; i < n; i++){
                if(Integer.parseInt(v2[i]) > 0){
                    return -1;
                }
            }
            return 0;
        }
    }
    public int compareVersion2(String version1, String version2){
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < v1.length || i < v2.length; i++){
            int x = 0;
            int y = 0;
            if(i < v1.length){
                x = Integer.parseInt(v1[i]);
            }
            if(i < v2.length){
                y = Integer.parseInt(v2[i]);
            }
            if(x > y){
                return 1;
            }
            if(x < y){
                return -1;
            }
        }
        return 0;
    }
}
