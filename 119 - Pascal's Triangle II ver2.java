// Given an index k, return the kth row of the Pascal's triangle.//
// For example, given k = 3,
// Return [1,3,3,1]

// 此解法只需要一個ArrayList，耗時3ms，最佳解 //
public class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<Integer>();

        for(int i=0; i <= rowIndex; i++){

            row.add(0,1); // 在最前面塞入一個 1，把上一列的值往後推 //

            for(int j=1; j<i; j++){ // j 從 1 開始， 最後一個為 1 不需要處理所以用 < 非 <= //

              row.set( j , row.get(j) + row.get(j+1) ); // 將 j 和 j+1 的和，存入 j 的位置 //

            }

        }

        return row;

    }
}
