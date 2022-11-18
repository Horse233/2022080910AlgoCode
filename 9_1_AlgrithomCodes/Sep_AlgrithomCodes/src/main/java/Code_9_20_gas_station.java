/**
 * 134. 加油站
 */
public class Code_9_20_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGas = 0, restGas = 0, start = 0;
        /*
         * 两句话：
         *      1. curGas < 0 肯定不能作为起点
         *      2. restGas < 0 肯定走不完全程
         */
        for(int i = 0; i < gas.length; i++){
            restGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if(curGas < 0){
                start = i + 1;
                curGas = 0;
            }
        }
        return restGas < 0 ? -1 : start;
    }
}
