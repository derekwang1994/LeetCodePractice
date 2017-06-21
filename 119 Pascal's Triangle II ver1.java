// Given an index k, return the kth row of the Pascal's triangle.//
// For example, given k = 3,
// Return [1,3,3,1]

// 此解法需要多一個ArrayList，耗時3ms，非最佳解 //
public class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0 ;i <= rowIndex ;i++){

            List<Integer> row = new ArrayList<Integer>();

            if(i!=0)row.add(1); // 第一個一定為1 //

            for(int j=0; j<i-1; j++){

                row.add( ans.get(j) + ans.get(j+1) ); // 取得上一列的兩個值，相加後存入新的List //

            }
            row.add(1); // 最後一個一定為1 //
            ans = row;
        }

        return ans;
    }
}
