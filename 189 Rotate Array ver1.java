public class Solution {
   public void rotate(int[] nums, int k) {
       // O(n) space, not best solution//

       int[] temp = nums.clone(); // copy the whole nums array to temp //

       int last = nums.length - 1; // last element's index //

       int count = 0;

       if( k > nums.length ) k = k % nums.length;

       for(int i=0; i<temp.length; i++){
// after store the element in the end of the array, starts from 0 //
           if( (i+k) > last )
           {
               nums[count] = temp[i];
               count++;
           }
           else
           {
               nums[i+k] = temp[i]; // move right //
           }

       }

   }
}
