public class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        for(int i=0;i<numRows;i++){

            List<Integer> row = new ArrayList<Integer>();
            if(i==0) {
                row.add(1);

            }else {
                List<Integer> lastRow = triangle.get(i-1); // 取得三角形的上一層的陣列 //
                int size = lastRow.size();
                row.add(1); // 第一個值永遠是 1 //
                for(int j=0;j<size-1;j++){
                    row.add(lastRow.get(j) + lastRow.get(j+1)); // row[j+1] = lastRow[j] + lastRow[j+1] //
                }
                row.add(1); // 最後一個值永遠是 1 //
            }

            triangle.add(row);

        }

        return triangle;

    }
}
