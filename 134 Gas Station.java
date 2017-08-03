// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
// You begin the journey with an empty tank at one of the gas stations.
// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
// Note:
// The solution is guaranteed to be unique.

// time complexity O(n), space complexity O(1)
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length != cost.length) return -1;

        int start = 0;
        int tank = 0;
        int gasSum = 0;
        int costSum = 0;

        for(int i=0; i<gas.length; i++){
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                start = i +1; // all the point before i can't be the start point
                tank = 0; // remember to reset to 0 whenever tank is < 0
            }
            gasSum += gas[i];
            costSum += cost[i];
        }

        return (gasSum < costSum) ? -1: start; // if gasSum >= costSum, there must be an answer.
    }
}
