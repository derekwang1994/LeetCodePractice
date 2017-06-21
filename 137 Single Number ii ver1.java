public class Solution {
    public int singleNumber(int[] nums) {
        // slower one but easier to understand //
        // O(32n) which eventually is also a linear runtime algorithm //

        /*
        e.g.: [3,3,2,3]

            1  1
            1  1
            1  0
        +   1  1
        ------------
            4  3
            %3 %3
        ------------
            1  0   => 2
        */

        int ans = 0;

        for(int i = 0; i < 32; i++) {

            int sum = 0;

            for(int j = 0; j < nums.length; j++) {

                if(((nums[j] >> i) & 1) == 1) // 將數字右移i次，再 AND 1，若此位數為1則此位數的sum +1，再將sum/3取餘數 //
                {
                    sum++;
                    sum %= 3;
                }

            }
            if(sum != 0) {
                ans |= (sum << i); // 將數字左移i次，再 OR ans，將二進位組回去 //
            }

        }
        return ans;
    }
}
