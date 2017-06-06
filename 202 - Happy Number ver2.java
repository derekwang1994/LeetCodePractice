public class Solution {
    public boolean isHappy(int n) {
    // better solution, O(1) space //
    // use the fast and slow to check if there is an endless loop //
    // same method is also used in the 141 - Linked List Cycle //
        if(n==0) return false;

        int slow = n, fast = n;

        do{
            slow = doSum(slow);

            fast = doSum(fast);

            if(fast==1) return true;

            fast = doSum(fast);

            if(fast==1) return true;

        }while(slow!=fast);

        return false;
    }

    public int doSum(int happy){

        int sum = 0;

        while(happy>=1)
        {
            sum += Math.pow((happy % 10),2);

            happy = happy / 10;
        }

        return sum;
    }
}
